package com.hello.forum.exceptions;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.google.gson.Gson;
import com.hello.forum.utils.AjaxResponse;
import com.hello.forum.utils.RequestUtil;

import jakarta.servlet.http.HttpServletRequest;

/**
 * "BasePackage (com.hello.forum)" 아래에서 발생하는
 * 처리되지 않은 모든 예외들을 ControllerAdvice 가 처리해준다.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * PageNotFoundException 이 발생했을 때, 동작하는 메소드
	 * @param pnfe ControllerAdvice 까지 처리되지 않은 PageNotFoundException 객체
	 * @return 에러페이지.
	 */
	@ExceptionHandler(PageNotFoundException.class)
	public Object viewPageNotFoundPage(PageNotFoundException pnfe, Model model) {
		pnfe.printStackTrace();
		
		HttpServletRequest request = RequestUtil.getRequest();
		String uri = request.getRequestURI();
		if(uri.startsWith("/ajax")) {
			AjaxResponse ar = new AjaxResponse();
			ar.append("errorMessage", pnfe.getMessage());
			
			// AjaxResponse 를 JOSN으로 변환
			Gson gson = new Gson();
			String ajaxJsonResponse = gson.toJson(ar);
			
//			return new ResponseEntity<String>(ajaxJsonResponse, HttpStatus.OK);
			return ResponseEntity.ok()
					.contentType(MediaType.APPLICATION_JSON)
					.body(ajaxJsonResponse);
		}
		
		model.addAttribute("message", pnfe.getMessage());
		
		return "error/404";
		
	}
	
	@ExceptionHandler({FileNotExistsException.class, MakeXlsxFileException.class,
		AlreadyUserException.class, RuntimeException.class} )
	public Object viewErrorPage(RuntimeException re, Model model) {
		re.printStackTrace();
		HttpServletRequest request = RequestUtil.getRequest();
		String uri = request.getRequestURI();
		if(uri.startsWith("/ajax")) {
			
			AjaxResponse ar = new AjaxResponse();
			ar.append("errorMessage", re.getMessage());
			
			// AjaxResponse 를 JOSN으로 변환
			Gson gson = new Gson();
			String ajaxJsonResponse = gson.toJson(ar);
			
//			return new ResponseEntity<String>(ajaxJsonResponse, HttpStatus.OK);
			return ResponseEntity.ok()
					.contentType(MediaType.APPLICATION_JSON)
					.body(ajaxJsonResponse);
		}
		
		if( re instanceof AlreadyUserException) {
			AlreadyUserException aue = (AlreadyUserException) re;
			model.addAttribute("email", aue.getEmail());
		}
		
		model.addAttribute("message", re.getMessage());
		return "error/500";
	}
	
	

	
}
