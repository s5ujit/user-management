
package com.appliedsni.dto;
import java.io.Serializable;
import java.util.Date;

import com.appliedsni.constants.ChannelType;


public class RequestHeader implements Serializable {

    /**
     * Unique serial version UID.
     */
    private static final long serialVersionUID = -5116863854693994330L;
    private ChannelType channel;
    private String userId;
    private String token;
	public ChannelType getChannel() {
		return channel;
	}
	public void setChannel(ChannelType channel) {
		this.channel = channel;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
    
    
    
    
}
