package com.appliedsni.dto;





public class UserLoginResponse extends AbstractResponse {

	private UserDto userDto;

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	

}
