package user.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import user.bean.UserImageDTO;

public interface UserUploadService {

	public void upload(List<UserImageDTO> userImageList);

	public List<UserImageDTO> getUploadList();

	public UserImageDTO getUploadImage(String seq);

	public void uploadUpdate(UserImageDTO userImageDTO, MultipartFile img);

	public void uploadDelete(String[] check);

	
}
