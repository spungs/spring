package com.care.cs.session;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class SessionQuizController {
	@Autowired private HttpSession session;
	
	@GetMapping("session/login") public void login() {}
	@RequestMapping("session/index") public void index() {}

	@PostMapping("session/login")
	public String login(String id, String pw) {
		// 로그인 성공시 index페이지로 이동
		if(id.equals("admin") && pw.equals("1234")) {
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			return "redirect:index";
		} 
		// 로그인 실패시
		return "session/login";
	}
	
	@RequestMapping("session/logout")
	public String logout() {
		session.invalidate();
		return "redirect:index";
	}
}







