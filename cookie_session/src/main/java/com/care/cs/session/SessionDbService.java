package com.care.cs.session;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionDbService {
	@Autowired private HttpSession session;
	@Autowired private SessionDbDAO dao;
	
	public String login(String id, String pw) {
		if(id.isEmpty() || pw.isEmpty()) {
			return "필수 정보입니다.";
		}
		SessionDbDTO dto = dao.login(id);
		if(dto == null || dto.getPw().equals(pw) == false) {
			return "아이디/ 비밀번호를 확인 후 입력하세요.";
		}
		
		session.setAttribute("id", id);
		session.setAttribute("name", dto.getName());
		session.setAttribute("email", dto.getEmail());
		return "로그인 성공";
	}
}
