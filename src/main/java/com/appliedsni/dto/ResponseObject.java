
package com.appliedsni.dto;


import java.io.Serializable;

public  class ResponseObject implements Serializable {

    private static final long serialVersionUID = -6273179309355246894L;
    private String status; 
    private Object object;
    private String exceptionMessage;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

    

}
