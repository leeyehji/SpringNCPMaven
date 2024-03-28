package user.service;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import spring.conf.NaverConfiguration;

@Service
public class NCPObjectStorageService implements ObjectStorageService {
	final AmazonS3 s3;
	
	//constructor: final s3에 필요한 data 주입.
	//https://guide.ncloud-docs.com/docs/storage-storage-8-1
	public NCPObjectStorageService(NaverConfiguration naverConfiguration) {
        s3 = AmazonS3ClientBuilder
                .standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder
                            .EndpointConfiguration(naverConfiguration.getEndPoint(),
                                    naverConfiguration.getRegionName())
                )
                .withCredentials(new AWSStaticCredentialsProvider(
                                    new BasicAWSCredentials(naverConfiguration.getAccessKey(),
                                                            naverConfiguration.getSecretKey())
                                    )
                )
                .build();
    }
	
	@Override
	public String uploadFile(String bucketName, String diretoryPath, MultipartFile img) {
		if(img.isEmpty()) return null;
		
		try(InputStream fileIn = img.getInputStream()) {
			String fileName = img.getOriginalFilename();//imageOriginalFileName
			//String fileName = UUID.randomUUID().toString();//imageFileName
			
			ObjectMetadata objectMatadata = new ObjectMetadata();
			objectMatadata.setContentType(img.getContentType());
			
			PutObjectRequest putObjectRequest =new PutObjectRequest (bucketName
																	,diretoryPath + fileName
																	,fileIn
																	,objectMatadata
																	).withCannedAcl(CannedAccessControlList.PublicRead);
			s3.putObject(putObjectRequest);//실제 업로드
			
			return fileName;
		}catch(Exception e) {
			throw new RuntimeException("파일 업로드 에러: "+e);//throws:에러발생 시 exception 막기  throw: 에러 발생 시 강제로 예외 생성
			//e.printStackTrace();//return 타입이 달라 사용 불가능.
		}
	}//uploadFile
	
	@Override
	public void deleteFile(String bucketName, String directoryPath, String imageFileName) {
		s3.deleteObject(bucketName, directoryPath+imageFileName);
		
	}
	
	@Override
	public void deleteFile(String bucketName, String directoryPath, List<String> list) {
		for(String imageFileName : list) {
			s3.deleteObject(bucketName, directoryPath+imageFileName);
		}
	}
}
