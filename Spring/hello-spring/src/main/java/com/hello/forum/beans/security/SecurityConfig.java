package com.hello.forum.beans.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.hello.forum.beans.security.handler.LoginFailureHandler;
import com.hello.forum.beans.security.handler.LoginSuccessHandler;
import com.hello.forum.beans.security.jwt.JwtAuthenticationFilter;
import com.hello.forum.beans.security.oauth2.OAuthService;
import com.hello.forum.member.dao.MemberDao;

/**
 * <pre>
 * Spring Security 의 전반적인 설정이 이루어지는 곳.
 * 
 * Spring Security 에 필요한 Bean 의 생성
 * Spring Security 의 보안 정책을 설정.
 * </pre>
 */
@Configuration
@EnableWebSecurity // Spring Security Filter 정책 설정을 위한 Annotation
public class SecurityConfig {

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
	private OAuthService oAuthService;
	/**
	 * 사용자 세부정보 서비스에 대한 Spring Bean 생성.
	 * 
	 * @return SecurityUserDetailsService 의 bean
	 */
	@Bean
	UserDetailsService userDetailsService() {
		return new SecurityUserDetailsService(this.memberDao); 
	}
	
	/**
	 * 암호 인코더에 대한 Spring Bean 생성
	 * @return SecuritySHA의 bean
	 * @return
	 */
	@Bean
	PasswordEncoder passwordEncoder() {
		return new SecuritySHA();
	}
	
	/**
	 * <pre>
	 * Spring Security 가 절대 개입하지 말아야 하는 URL들을 정의.
	 * 아래 URL에서 보여지는 페이지 내부에서는 Security Taglib 을 사용할 수 없다.
	 * ignoring 은 Security가 절대 개입하지 않기 때문이다. 
	 * </pre>
	 * @return
	 */
	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring()
				           .requestMatchers(AntPathRequestMatcher.antMatcher("/WEB-INF/views/**"))
				           // CSRF 적용을 위해 Security 설정 필요.
//				           .requestMatchers(AntPathRequestMatcher.antMatcher("/member/login"))
//				           .requestMatchers(AntPathRequestMatcher.antMatcher("/member/regist/**"))
				           .requestMatchers(AntPathRequestMatcher.antMatcher("/error/**"))
				           .requestMatchers(AntPathRequestMatcher.antMatcher("/favicon.ico"))
				           .requestMatchers(AntPathRequestMatcher.antMatcher("/member/**-delete-me"))
				           .requestMatchers(AntPathRequestMatcher.antMatcher("/js/**"))
				           .requestMatchers(AntPathRequestMatcher.antMatcher("/css/**"))
				           ;
	}
	
	/**
	 * Spring Security Filter 가 돛작해야할 방식(순서)를 정의 
	 * @param http HttpSecurity 필터 전략
	 * @return SpringSecurityFilterChain Spring Security 가 동작해야할 순서
	 * @throws Exception
	 */
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(httpRequest ->
			// /board/search 는 인증 여부와 관계없이 모두 접근이 가능하다.
			httpRequest.requestMatchers(AntPathRequestMatcher.antMatcher("/board/search"))
			           .permitAll()
			           .requestMatchers(AntPathRequestMatcher.antMatcher("/ajax/menu/list"))
			           .permitAll()
			           // CSRF 설정을 위해..
			           .requestMatchers(AntPathRequestMatcher.antMatcher("/member/login"))
			           .permitAll()
			           .requestMatchers(AntPathRequestMatcher.antMatcher("/ajax/member/regist/available"))
			           .permitAll()
			           .requestMatchers(AntPathRequestMatcher.antMatcher("/member/regist/**"))
			           .permitAll()
			           .requestMatchers(AntPathRequestMatcher.antMatcher("/auth/token"))
			           .permitAll()
			           .requestMatchers(AntPathRequestMatcher.antMatcher("/ajax/excel/download2"))
			           .hasRole("ADMIN")
			           .requestMatchers(AntPathRequestMatcher.antMatcher("/ajax/board/delete/massive"))
			           .hasRole("ADMIN")
			           .requestMatchers(AntPathRequestMatcher.antMatcher("/ajax/board/excel/write"))
			           .hasRole("ADMIN")
			           // 그 외 모든 URL은 인증이 필요하다.
			           .anyRequest()
			           .authenticated());
		
		// 로그인(필터) 정책 설정.
		
		// 우리 애플리케이션은 Form 기반으로 로그인을 하며
		// 로그인이 완료되면 /board/search 로 이동을 해야한다.
		http.formLogin(formLogin -> formLogin
				
				// Spring Security 인증이 성공할 경우 LoginSuccessHandler가 동작되도록 설정.
				 .successHandler(new LoginSuccessHandler())
				// Spring Security 인증이 실패할 경우 LoginFailureHandler가 동작되도록 설정.
				 .failureHandler(new LoginFailureHandler())
				// Spring Security Login URL 변경
				 .loginPage("/member/login")
				// Spring Security Login 처리 URL 변경
				// SecurityAuthenticationProvider 실행 경로 지정
				 .loginProcessingUrl("/member/login-proc")
				// 로그인 ID가 전달될 파라미터 이름
				 .usernameParameter("email")
				// 로그인 PW가 전달될 파라미터 이름
				 .passwordParameter("password"));
		
		// OAuth Login 및 후 처리 설정.
		http.oauth2Login(auth -> auth.defaultSuccessUrl("/board/search",true)
									 .userInfoEndpoint(user ->
									 		user.userService(oAuthService))
									 .loginPage("/member/login"));
		
		// CSRF 방어로직 무효화.
//		http.csrf(csrf -> csrf.disable());
		// /auth/token URL에서는 CSRE 검사를 하지 않음. 화면에 보여주지 않는 URL의 CSRF토큰을 매번 저장해서 보내주기 어려우니.. 이렇게..
		http.csrf(csrf -> csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/auth/token")));
		
		http.addFilterAfter(this.jwtAuthenticationFilter, BasicAuthenticationFilter.class);
		
		return http.build();
	}
	
	
}
