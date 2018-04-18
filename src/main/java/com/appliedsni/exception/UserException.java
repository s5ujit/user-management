package com.appliedsni.exception;

public class UserException extends Exception{
	private String exceptionMessage;
    public UserException(String exceptionMessage)
    {
    	this.exceptionMessage=exceptionMessage;
    	
    }
	public String getExceptionMessage() {
		return exceptionMessage;
	}

}
