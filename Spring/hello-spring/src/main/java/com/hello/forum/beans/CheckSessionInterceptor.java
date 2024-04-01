package com.hello.forum.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import com.hello.forum.member.vo.MemberVO;
import com.hello.forum.utils.StringUtils;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CheckSessionInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(CheckSessionInterceptor.class);
	
	/**
	 * Controller 실행 전에 Interceptor 가 개입
	 * @param request 브라우저가 서버에게 요청한 정보
	 * @param response 서버가 브라우저에게 응답할 정보
	 * @param handler 실행할 Controller 
	 * return controller 실행을 계속할 것인지 여부 (false 일 경우 컨트롤러를 실행하지 않고 즉시 응답해버린다.)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 세션을 가져온다.
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("_LOGIN_USER_");
		
		// 세션이 없다면?
		if(memberVO == null) {
			// 현재 요청중인 URL 확인..
			// GET, POST, PUT, DELETE, FETCH 등등..
			String httpMethod = request.getMethod().toLowerCase();
			String uri = request.getRequestURI();
//			String url = request.getRequestURL().toString();
			String queryString = request.getQueryString();
			
			logger.debug("HttpMethod: " + httpMethod);
			logger.debug("RequestURI: " + uri);
			logger.debug("QueryString: " + queryString);
//			System.out.println("RequestURL: " + url);
			
			
			if(httpMethod.equals("get")) {
				
				String nextUrl = uri;
				if(!StringUtils.isEmpty(queryString)) {
					nextUrl += "?" + queryString;
				}
				
				// Model로 로그인 이후에 요청할 주소를 보내준다.
				request.setAttribute("nextUrl", nextUrl);
			}
			
			// servlet 에서...작성했던 것 처럼.. why? Controller 가 아니기 때문에.. 
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/memberlogin.jsp");
			rd.forward(request, response);
			// Controller 실행하지 않고 즉시 응답..
			return false;
		}
		return true;
	}
	
	
	/**
	 * Controller 가 실행 된 후에 Interceptor가 개입
	 * @param request 브라우저가 서버에게 요청한 정보
	 * @param response 서버가 브라우저에게 응답할 정보
	 * @param handler 실행한 Controller
	 * @param modelAndView Controller 가 반환한 ModelAndView 객체
	 *        Controller 가 String 을 반환해도 ModelAndView로 변환된다.
	 */
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//	}
	
	
	/**
	 * 요청과 응답처리가 모두 완료된 후에 Interceptor가 개입
	 * @param request 브라우저가 서버에게 요청한 정보
	 * @param response 서버가 브라우저에게 응답할 정보
	 * @param handler 실행한 Controller
	 * @param ex 실행 중 발생한 예외 객체
	 * 		      예외가 발생하지 않았다면 null 이다.
     */
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//	}
}
