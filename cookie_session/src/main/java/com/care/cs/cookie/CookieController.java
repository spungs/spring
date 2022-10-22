package com.care.cs.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CookieController {
	
	//http://localhost:8085/cs/index
	@GetMapping("index")
	public String index(HttpServletResponse res) {
		Cookie cookie = new Cookie("cookieName", "쿠키값");
		res.addCookie(cookie);
		
		return "cookie/index";
	}
	
	//http://localhost:8085/cs/cookie/result
	@GetMapping("cookie/result")
	public String result(HttpServletRequest req, Model model) {
		Cookie[] cookies = req.getCookies();
		for(Cookie c : cookies) {
			if(c.getName().equals("cookieName"))
				model.addAttribute("cookieName", c.getValue());
		}
		
		return "cookie/result";
	}
	
	@GetMapping("cookie/result2")
	public String result2(
			@CookieValue(value = "cookieName2", required = false) Cookie c, 
			Model model) {
		
			if(c != null)
				model.addAttribute("cookieName", c.getValue());
		
		return "cookie/result";
	}
}
