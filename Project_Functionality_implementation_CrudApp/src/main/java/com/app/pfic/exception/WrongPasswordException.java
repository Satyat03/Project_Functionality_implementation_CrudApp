package com.app.pfic.exception;

public class WrongPasswordException extends RuntimeException{
	
	public WrongPasswordException(String msg)
	{
		super(msg);
	}

}
