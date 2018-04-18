package com.appliedsni.entity;

import java.io.Serializable;
import java.util.List;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.appliedsni.constants.Role;
import com.appliedsni.entity.PersistenceObject;
@Entity
@Table(name = "XPROFILE",uniqueConstraints={@UniqueConstraint(columnNames={"XROLE"})})
public class Profile extends PersistenceObject implements Serializable{
    private static final long serialVersionUID = 3539102181989695535L;

    @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "XID", columnDefinition = "NUMBER(38)", nullable = false)
    private Long id;
    
    @Column(name = "XROLE", length = 10, nullable = false)
    private String role;
    
    @Column(name = "XPROFILEDESCRIPTION", length = 64, nullable = false)
    private String profileDescription;

    public Profile() {

    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProfileDescription() {
		return profileDescription;
	}

	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	 public String toString() {
	        return this.role;
	    }
    
}
