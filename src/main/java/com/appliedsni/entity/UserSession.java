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
    @Column(name = "XOID", columnDefinition = "NUMBER(38)", nullable = false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Long id;
	@Column(name = "XTOKEN", length = 1000, nullable = false)
	private String token;
	@Column(name = "USERID", length = 100, nullable = false)
	private String userId;
	public Long getId() {
		return id;
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
	public UserSession()
	{}
	
	

}
