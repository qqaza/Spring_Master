package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.demo.security.CustomLoginSuccessHandler;
import com.example.demo.users.service.UserService;
import com.example.demo.security.CustomAccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Autowired UserDetailsService detailService;
	
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	

	@Bean // <-- 
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.antMatchers("/", "/home").permitAll()
				//관리자만 접속 가능하게 하기
				.antMatchers("/empList").hasRole("ADMIN")
				.anyRequest().authenticated()
			)
			//람다식 로그인
//			.formLogin((form) -> form
//				.loginPage("/login")
//				.permitAll()
//			)
			//람다식 로그아웃
			//.logout((logout) -> logout.permitAll())
			//.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
			.formLogin().loginPage("/login")
										//유저로그인 이름 바꿈
								  .usernameParameter("userid")
								  		//로그인 액션 이름 바꿈
								  .loginProcessingUrl("/userlogin")
								  .successHandler(authenticationSuccessHandler())
								  .permitAll()
			.and()
			.logout().logoutSuccessUrl("/customLogout").permitAll()
			.and()
			.exceptionHandling( handler -> handler.accessDeniedHandler(accessDeniedHandler()))
			//csrf 토큰 안보이게함 (토큰은 있어야 보안강화됨)
			//.csrf().disable();
			.userDetailsService(detailService)
			;
			

		return http.build();
	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user =
//			 User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("1111")
//				.roles("USER")
//				.build();
//		UserDetails admin =
//				 User.withDefaultPasswordEncoder()
//					.username("admin")
//					.password("admin")
//					.roles("ADMIN")
//					.build();
//
//		return new InMemoryUserDetailsManager(user, admin);
//	}
}