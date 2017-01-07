package com.springboot.example.exception;

public class LoginException extends RuntimeException{
	private static final long serialVersionUID = -7926313458438047463L;
	private String message;
	
	public LoginException() {
		super();
	}
	
	public LoginException(String message){
		super(message);
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
