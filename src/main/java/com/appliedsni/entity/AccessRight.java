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
	@Column(name = "XOID", columnDefinition = "NUMBER(38)", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private Long id;
	@Column(name="XREADACCESS")
	private boolean  readAccess=true;
	@Column(name="XWRITEACESS")
	private boolean writeAccess=false;
	@Column(name="XURL")
	private String url;
	@Enumerated(EnumType.STRING)
	@Column(name = "XROLE", length = 10, nullable = false)
	private Role role;

	public AccessRight(){}
	@Override
	public Long getId() {
		return this.id;
	}

	public boolean isReadAccess() {
		return readAccess;
	}

	public void setReadAccess(boolean readAccess) {
		this.readAccess = readAccess;
	}

	public boolean isWriteAccess() {
		return writeAccess;
	}

	public void setWriteAccess(boolean writeAccess) {
		this.writeAccess = writeAccess;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
