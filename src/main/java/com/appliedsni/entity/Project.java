package com.appliedsni.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(name="XPROJECT",uniqueConstraints={@UniqueConstraint(columnNames={"XNAME"})})
public class Project extends PersistenceObject implements Serializable {
	@Id
     @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "XID", columnDefinition = "NUMBER(38)", nullable = false)
    private Long id;

	@Column(name = "XNAME", nullable = false)
	private String name;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "XUSER", referencedColumnName = "XID")
	private List<User> user;
	@Column(name = "XEMAIL", nullable = true)
	private String Email;
	@Column(name = "XPHONE", nullable = true)
	private String Phone;
	@Column(name = "XNOTIFICATIONKEY", nullable = true)
	private String notificationKey; 
	@Column(name = "XOTPKEY", nullable = true)
	private String OTPKey; 
	@Column(name = "XFACEBOOKKEY", nullable = true)
	private String FacebookKey; 
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.PERSIST,CascadeType.MERGE })
	@JoinColumn(name = "XCOMPANY", referencedColumnName = "XID")
	private Company company;
	public Project()
	{}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getNotificationKey() {
		return notificationKey;
	}
	public void setNotificationKey(String notificationKey) {
		this.notificationKey = notificationKey;
	}
	public String getOTPKey() {
		return OTPKey;
	}
	public void setOTPKey(String oTPKey) {
		OTPKey = oTPKey;
	}
	public String getFacebookKey() {
		return FacebookKey;
	}
	public void setFacebookKey(String facebookKey) {
		FacebookKey = facebookKey;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	

}
