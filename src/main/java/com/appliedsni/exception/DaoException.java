package com.appliedsni.exception;

public class DaoException extends Exception {

	/**
	 * 
	 */
	private String exceptionMessage;
    public DaoException(String exceptionMessage)
    {
    	this.exceptionMessage=exceptionMessage;
    	
    }
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	
    
}
