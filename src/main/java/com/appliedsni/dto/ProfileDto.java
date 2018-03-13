package com.appliedsni.dto;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.appliedsni.constants.Role;



public class ProfileDto extends PersistenceObjectDto {
	
    private static final long serialVersionUID = 3539102181989695535L;
    private Long id;
    private Role role;
    private String profileDescription;
    
    private List<UserDto> users;
 

    public ProfileDto() {

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

	public List<UserDto> getUsers() {
		return users;
	}

	public void setUsers(List<UserDto> users) {
		this.users = users;
	}
	@Override
    public String toString(){
    	return this.role.toString();
    	
    }
}
