package user.dao;

import java.util.List;

import user.bean.UserImageDTO;

public interface UserUploadDAO {

	public void upload(UserImageDTO userImageDTO, List<String> fileNameList);

	public List<UserImageDTO> getUploadList();

}
