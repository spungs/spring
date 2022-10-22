package com.care.cs.session;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {
	@Autowired private HttpSession session;
	//http://localhost:8085/cs/make
	@RequestMapping("make")
	public String make() {
		session.setAttribute("id", "admin");
		session.setAttribute("pw", "1234");
		return "session/make";
	}
	@RequestMapping("result")
	public String result() { 
		return "session/result"; 
	}
	
	@RequestMapping("delete")
	public String delete() {
		session.invalidate();
		return "session/delete";
	}
}







