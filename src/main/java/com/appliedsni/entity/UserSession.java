package com.appliedsni.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "XUSERSESSION")
public class UserSession extends PersistenceObject{
	@Id
    @Column(name = "XOID", columnDefinition = "XNUMBER(38)", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@Column(name = "XTOKEN", length = 1000, nullable = true)
	private String token;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "XUSER_OID", referencedColumnName = "XOID", nullable = false)
	private User user;
	public Long getId() {
		return id;
	}
	
	public String getToken() {
		return token;
	}
	
	public User getUser() {
		return user;
	}
	public UserSession(User user,String token)
	{
		this.user=user;
		this.token=token;
	}
	
	

}
