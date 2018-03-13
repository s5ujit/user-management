
package com.appliedsni.dto;


import java.io.Serializable;

public abstract class AbstractResponse implements Serializable {

    public RequestHeader getRequestHeader() {
    	if(this.requestHeader==null)
    		this.requestHeader=new RequestHeader();
		return requestHeader;
	}
	public void setRequestHeader(RequestHeader requestHeader) {
		this.requestHeader = requestHeader;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
     * Unique serial version UID.
     */
    private static final long serialVersionUID = -6273179309355246894L;
    private RequestHeader requestHeader;
    private String status; 

    

}
