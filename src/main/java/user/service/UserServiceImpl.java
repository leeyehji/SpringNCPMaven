package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.bean.UserPaging;
import user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserPaging userPaging;

	@Override
	public String isExistId(String id) {
		UserDTO userDTO = userDAO.isExistId(id);
		
		if(userDTO == null)
			return "non_exist";
		else
			return "exist";
	}

	@Override
	public void write(UserDTO userDTO) {
		userDAO.write(userDTO);
	}

	@Override
	public Map<String, Object> getUserList(String pg) {
		//1페이지당 3개씩 - MySQL
		int startNum = Integer.parseInt(pg) * 3 - 3; //시작위치는 0부터
		
		//List객체가 JSON으로 자동 변환된다. - pom.xml <dependency>에 추가해야 함
		List<UserDTO> list = userDAO.getUserList(startNum);
		System.out.println("list = " + list);
		
		//페이징 처리
		int totalA = userDAO.getTotalA(); //총글수
		
		userPaging.setCurrentPage(Integer.parseInt(pg));
		userPaging.setPageBlock(3);
		userPaging.setPageSize(3);
		userPaging.setTotalA(totalA);
		userPaging.makePaingHTML();
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("userPaging", userPaging);
		
		return map;
	}

	@Override
	public UserDTO getUser(String id) {
		return userDAO.getUser(id);
	}

	@Override
	public void update(UserDTO userDTO) {
		userDAO.update(userDTO);
	}

	@Override
	public void delete(String id) {
		userDAO.delete(id);
	}

}











