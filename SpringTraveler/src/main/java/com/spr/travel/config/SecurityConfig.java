package com.spr.travel.config;

import javax.servlet.DispatcherType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

//@EnableWebSecurity //시큐리티 필터가 등록
//@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근을 하면 권한 및 인증을 미리 체크
@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http.authorizeHttpRequests(authorize -> {
			try {
				authorize.antMatchers("/css/**", "/images/**", "/js/**", "/main/*.do", "/main/*", "/member/files/**")
						.permitAll() // 해당 경로는 인증 없이 접근 가능
						.antMatchers("/member/**") // 해당 경로는 인증이 필요
						.hasRole("MEMBER") // ROLE 이 MEMBER 가 포함된 경우에만 인증 가능
						.and().formLogin().loginPage("/member/login/loginForm") // 로그인 페이지 설정
						.loginProcessingUrl("/member/login/login") // 로그인 처리 URL 설정
						.defaultSuccessUrl("/member/main") // 로그인 성공 후 이동할 페이지
//	                        .successHandler(new MemberAuthSuccessHandler()) // 로그인 성공 후 처리할 핸들러
						.permitAll().and().logout().logoutUrl("/member/login/logout") // 로그아웃 처리 URL 설정
						.logoutSuccessUrl("/member/login/loginForm?logout=1") // 로그아웃 성공 후 이동할 페이지
						.deleteCookies("JSESSIONID"); // 로그아웃 후 쿠키 삭제
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});
		return http.build();
	}

}