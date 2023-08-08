package com.spr.travel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import com.spr.travel.security.*;

import com.spr.travel.auth.PrincipalDetailService;
import com.spr.travel.security.CustomAuthenticationProvider;

import lombok.RequiredArgsConstructor;

//@EnableWebSecurity //시큐리티 필터가 등록
//@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근을 하면 권한 및 인증을 미리 체크
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	
	private PrincipalDetailService userDetailsService;
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

//      String password = passwordEncoder().encode("1111");
//
//      auth.inMemoryAuthentication().withUser("user").password(password).roles("USER");
//      auth.inMemoryAuthentication().withUser("manager").password(password).roles("MANAGER");
//      auth.inMemoryAuthentication().withUser("admin").password(password).roles("ADMIN");
//      auth.userDetailsService(userDetailsService);
  //    auth.authenticationProvider(authenticationProvider());
  }
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http.authorizeHttpRequests(authorize -> {
			try {
				authorize.antMatchers("/css/**", "/images/**", "/js/**", "/main/*.do", "/main/*", "/member/files/**")
					.permitAll() // 해당 경로는 인증 없이 접근 가능
					.antMatchers("/member/**") // 해당 경로는 인증이 필요
					.hasRole("USER") // ROLE 이 MEMBER 가 포함된 경우에만 인증 가능
					.and()
					.formLogin()
						.loginPage("/member/main.do") // 로그인 페이지 설정
						.loginProcessingUrl("/login-process.do") // 로그인 처리 URL 설정
		                .usernameParameter("userId")
		                .passwordParameter("userPwd")
						.defaultSuccessUrl("/main/main.do") // 로그인 성공 후 이동할 페이지
	                    .successHandler(new LoginSuccessHandler()) // 로그인 성공 후 처리할 핸들러
						.permitAll()
					.and()
					.logout().logoutUrl("/member/logout.do") // 로그아웃 처리 URL 설정
					.logoutSuccessUrl("/member/login/loginForm?logout=1") // 로그아웃 성공 후 이동할 페이지
					.deleteCookies("JSESSIONID"); // 로그아웃 후 쿠키 삭제
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});
		return http.build();
	}
    @Bean
    public UserDetailsService userDetailsService() {
    	userDetailsService = new PrincipalDetailService();
        return userDetailsService;
    }
	
    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(new CustomAuthenticationProvider());
    }
    


}