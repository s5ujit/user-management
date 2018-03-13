package com.appliedsni.dto;




public class UserDto extends PersistenceObjectDto {
    private static final long serialVersionUID = -1679970109556600138L;
    

    private Long id;
    
    private String emailAddress;
    
    private int failLoginAttempts;

    private String firstName;

    private String lastName;
    
    private boolean lockUserIndicator;

    private int numberOfLogins;


    private String passwordHash;

    private ProfileDto profile;
    
    private String mobileNumber;

    public UserDto() {

    }

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getFailLoginAttempts() {
		return failLoginAttempts;
	}

	public void setFailLoginAttempts(int failLoginAttempts) {
		this.failLoginAttempts = failLoginAttempts;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isLockUserIndicator() {
		return lockUserIndicator;
	}

	public void setLockUserIndicator(boolean lockUserIndicator) {
		this.lockUserIndicator = lockUserIndicator;
	}

	public int getNumberOfLogins() {
		return numberOfLogins;
	}

	public void setNumberOfLogins(int numberOfLogins) {
		this.numberOfLogins = numberOfLogins;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public ProfileDto getProfile() {
		return profile;
	}

	public void setProfile(ProfileDto profile) {
		this.profile = profile;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	

}
