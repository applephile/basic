package com.green.basic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class boardController {
	
	@GetMapping("/list")
	public String list(HttpServletRequest request) {
		if(!loginCheck(request)) {
			return "redirect:/login/login?toURL=" + request.getRequestURL();
		}
		return "boardList";
	}

	private boolean loginCheck(HttpServletRequest request) {
		//1. ������ ����
		HttpSession session = request.getSession();
		
		//2. ���ǿ� ID�� �ִ��� Ȯ��
		return session.getAttribute("id") != null;
	}
}
