package user.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import user.bean.UserImageDTO;
import user.dao.UserUploadDAO;

@Service
public class UserUploadServiceImpl implements UserUploadService {
	@Autowired
	private UserUploadDAO userUploadDAO;
	@Autowired
	private ObjectStorageService objectStorageService;
	@Autowired
	private HttpSession session;
	
	private String bucketName = "bitcamp-6th-bucket-105";
	
	
	@Override
	public void upload(List<UserImageDTO> userImageList) {
		userUploadDAO.upload(userImageList);
	}

	@Override
	public List<UserImageDTO> getUploadList() {
		return userUploadDAO.getUploadList();
	}
	
	@Override
	public UserImageDTO getUploadImage(String seq) {
		// TODO Auto-generated method stub
		return userUploadDAO.getUploadImage(seq);
	}
	
	@Override
	public void uploadUpdate(UserImageDTO userImageDTO, MultipartFile img) {
		//실제폴더
		//D:/Spring/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Chapter06_Web/WEB-INF/storage
		String filePath = session.getServletContext().getRealPath("WEB-INF/storage");
		System.out.println("실제폴더 = " + filePath);
		
		//DB에서 seq에 해당하는 imageFileName 꺼내오기. Object Storage(NCP)의 이미지를 삭제.
		//Object Storage에 이미지 덮어쓰기가 불가능 하기 때문. 따라서 삭제 후 새 이미지 업로드 필요.
		String imageFileName = userUploadDAO.getImageFileName(userImageDTO.getSeq());
		System.out.println("imageFilename= "+imageFileName);
		
		//NCP 파일지우자
		objectStorageService.deleteFile(bucketName, "storage/", imageFileName);
		
		//NCP 업로드
		imageFileName=objectStorageService.uploadFile(bucketName, "storage/", img);
		String originalFileName=img.getOriginalFilename();
		File file=new File(filePath,originalFileName);
		try {
			img.transferTo(file);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		userImageDTO.setImageFileName(imageFileName);
		userImageDTO.setImageContent(userImageDTO.getImageContent());
		userImageDTO.setImageOriginalName(originalFileName);
		
		System.out.println("업데이트 할게요 이미지파일이름/내용/찐이름"+userImageDTO.getImageFileName()+"/"+userImageDTO.getImageContent()+"/"+userImageDTO.getImageOriginalName() );

		//DB 수정
		userUploadDAO.uploadUpdate(userImageDTO);
		
	}
	
	@Override
	public void uploadDelete(String[] check) {
		List<String> list=new ArrayList<>();
		
		
		//DB seq 보고 imageFileName 꺼내서 List에 담기 ->userUploadMapper.xml에서 for each 사용을 위해 list에 담음.
		for(String data : check) {
			String imageFileName=userUploadDAO.getImageFileName(Integer.parseInt(data));
			list.add(imageFileName);
		}
		
		//NCP 삭제
		objectStorageService.deleteFile(bucketName, bucketName, list);
		
		//DB 삭제
		userUploadDAO.uploadDelete(list);
	}
}
