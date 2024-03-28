package user.service;

import java.util.List;

import user.bean.UserImageDTO;

public interface UserUploadService {

	public void upload(UserImageDTO userImageDTO, List<String> fileNameList);

	public List<UserImageDTO> getUploadList();

}
