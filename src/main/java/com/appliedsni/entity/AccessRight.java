package com.appliedsni.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.appliedsni.constants.Role;
@Entity
@Table(name="XACCESSRIGHT")
public class AccessRight extends PersistenceObject implements Serializable {
	@Id
     @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "XID", columnDefinition = "NUMBER(38)", nullable = false)
    private Long id;
	
	@Column(name="XREADACCESS")
	private Boolean  readAccess=true;
	
	@Column(name="XWRITEACESS")
	private Boolean writeAccess=true;
	
	@Column(name="XURL")
	private String url;
	
	@Column(name = "XROLE", length = 10, nullable = true)
	private String role;

	public AccessRight(){}
	@Override
	public Long getId() {
		return this.id;
	}

	public Boolean isReadAccess() {
		return readAccess;
	}

	public void setReadAccess(Boolean readAccess) {
		this.readAccess = readAccess;
	}

	public Boolean isWriteAccess() {
		return writeAccess;
	}

	public void setWriteAccess(Boolean writeAccess) {
		this.writeAccess = writeAccess;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
