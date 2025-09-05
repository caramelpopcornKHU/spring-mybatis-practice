package lx.edu.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	
	
	@GetMapping(value = "login_form.do")
	public String loginForm() {
		return "login";
	}
	
	
	// request 들어오면 -> 그걸 얼규멘트에 넣어 놓을게 - 자동 매핑 -> req.getParameter() ㅇㅈㄹ 안해도 됨
	@PostMapping(value = "loginaction.do")
	public String loginAction(HttpServletRequest req,
			@RequestParam("id") String id, @RequestParam("pw") String pw, HttpSession session) {
		
		System.out.println("id = " + id + ", pw = " + pw);
		// 로그인 정보 db에서 확인 후 <- dao가 물어와라 정보
		
		if(id.equals(pw)) { // 일단 로그인 id pw같으면 로그인 성공
			// 세션에 key: userId, value: id
			session.setAttribute("userId", id);
			return "redirect:addrbook_list.do";
		}
		
		
		// 아니면 실패하면 리다이랙트
		return "redirect:login_form.do";
		
		
	}

}
