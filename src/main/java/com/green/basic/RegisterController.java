package com.green.basic;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	
	//@RequestMapping(value="/register/add")
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm";
//	}
	
	//@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")
	public String save(User user, Model m) throws Exception {
		
		//1. 유효성검사
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 확인하세요", "utf-8");
		}
		//2. DB 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
	}
	
}
