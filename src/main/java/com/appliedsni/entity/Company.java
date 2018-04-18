package com.appliedsni.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="XCOMPANY")
public class Company extends PersistenceObject implements Serializable {
	@Id
     @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "XID", columnDefinition = "NUMBER(38)", nullable = false)
    private Long id;

	@Column(name = "XNAME", nullable = false)
	private String name;
	
	@Column(name = "XEMAIL")
	private String email;
	
	@Column(name = "XPHONENUMBER")
	private String phoneNumber;
	
	@Column(name = "XSTATUS")
	private Boolean status;
	 
	public Company() {
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Boolean isStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Company))
			return false;
		if (obj == this)
			return true;
		Company com = (Company) obj;
		return this.getName().equals(com.getName());
	}
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	

}
