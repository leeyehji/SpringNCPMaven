package user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserImageDTO;
import user.dao.UserUploadDAO;

@Service
public class UserUploadServiceImpl implements UserUploadService {
	@Autowired
	private UserUploadDAO userUploadDAO;

	@Override
	public void upload(UserImageDTO userImageDTO, List<String> fileNameList) {
		userUploadDAO.upload(userImageDTO, fileNameList);
	}

	@Override
	public List<UserImageDTO> getUploadList() {
		return userUploadDAO.getUploadList();
	}

}
