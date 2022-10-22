package com.care.cs.session;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SessionDbController {
	@Autowired private HttpSession session;
	@Autowired private SessionDbService service;
	
	@GetMapping("session/login") public void login() {}
	@RequestMapping("session/index") public void index() {}

	@PostMapping("session/login")
	public String login(String id, String pw, 
			Model model, RedirectAttributes ra) {
		
		String result = service.login(id, pw);
		if(result.equals("로그인 성공")) {
//			ra.addFlashAttribute("msg", result);
			model.addAttribute("msg", result);
			return "redirect:index";
		}
		model.addAttribute("msg", result);
		return "session/login";
	}
	
	@RequestMapping("session/logout")
	public String logout() {
		session.invalidate();
		return "redirect:index";
	}
}







