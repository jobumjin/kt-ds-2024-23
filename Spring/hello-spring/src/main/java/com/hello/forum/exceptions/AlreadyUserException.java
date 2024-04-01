package com.hello.forum.exceptions;

public class AlreadyUserException extends RuntimeException {

	private static final long serialVersionUID = -454119708867254511L;
	
	private String email;
	
	public AlreadyUserException(String email) {
		super("이미 사용중인 이메일입니다.");
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

}
