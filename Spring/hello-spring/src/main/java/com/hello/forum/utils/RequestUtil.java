package com.hello.forum.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

public class RequestUtil {

	private RequestUtil() {
		
	}
	
	public static HttpServletRequest getRequest() {
		// 한줄로 쓰게됨..원래는..
		// Spring 이 관리하는 Request 객체를 얻어온다.
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		
		// Request 객체를 가져오기 위해서 ServletRequestAttributes로 변경한다. 
		ServletRequestAttributes sra = (ServletRequestAttributes)ra;
		
		return sra.getRequest();
		
	}
}
