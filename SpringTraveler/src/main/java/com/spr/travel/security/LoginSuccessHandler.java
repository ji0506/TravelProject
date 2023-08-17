package com.spr.travel.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.spr.travel.domain.User;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		User user = (User) auth.getPrincipal();    // 저장된 로그인 정보 가져오기
		HttpSession session = request.getSession();	
		
		if(user != null) { // 로그인 성공 시 세션 생성
			session.setAttribute("user", user);
		}
		response.sendRedirect("/main/main.do"); // 메인페이지로 이동
		
	}

}
