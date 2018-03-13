package com.appliedsni.entity;

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
import javax.persistence.Table;

import com.appliedsni.constants.Role;
import com.appliedsni.entity.PersistenceObject;
@Entity
@Table(name = "XPROFILE")
public class Profile extends PersistenceObject {
    private static final long serialVersionUID = 3539102181989695535L;

    @Id
    @Column(name = "XOID", columnDefinition = "XNUMBER(38)", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "XROLE", length = 10, nullable = false)
    private Role role;
    
    @Column(name = "XPROFILEDESCRIPTION", length = 64, nullable = false)
    private String profileDescription;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "XPROFILE_OID", referencedColumnName = "XOID")
    private List<User> users;
 

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
    
}
