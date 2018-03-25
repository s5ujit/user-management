package com.appliedsni.exception;

public class UnauthorizedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String exceptionMessage;
    public UnauthorizedException(String exceptionMessage)
    {
    	this.exceptionMessage=exceptionMessage;
    }
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	

}
