package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import user.service.UserUploadService;

@Controller
@RequestMapping(value="user")
public class UserUploadAJaxController {
	@Autowired
	private UserUploadService userUploadService;
	
	@GetMapping(value="uploadFormAJax")
	public String uploadFormAJax() {
		return "user/uploadFormAJax";
	}

}
