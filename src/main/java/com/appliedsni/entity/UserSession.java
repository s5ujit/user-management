package com.appliedsni.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "XUSERSESSION")
public class UserSession extends PersistenceObject implements Serializable{
	@Id
     @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "XID", columnDefinition = "NUMBER(38)", nullable = false)
    private Long id;
	@Column(name = "XTOKEN", length = 1000, nullable = false)
	private String token;
	@Column(name = "USERID", length = 100, nullable = false)
	private String userId;
	
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public String getUserId() {
		return userId;
	}
	public UserSession(String token,String userId){
		this.token=token;
		this.userId=userId;
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserSession()
	{}

	
	

}
