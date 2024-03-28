package user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import user.bean.UserImageDTO;

@Mapper
public interface UserUploadDAO {

	public void upload(List<UserImageDTO> userImageList);

	public List<UserImageDTO> getUploadList();

	//public void delete(String id);
	
	public UserImageDTO getUploadImage(String seq);

	public String getImageFileName(int seq);

	public void uploadUpdate(UserImageDTO userImageDTO);

	public void uploadDelete(List<String> list);
}
