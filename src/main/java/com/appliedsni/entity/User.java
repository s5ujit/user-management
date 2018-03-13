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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.appliedsni.entity.PersistenceObject;
@Entity
@NamedQueries({
    @NamedQuery(name = "User.findUserByUserId", query = "SELECT User "
                + "FROM User user " + "WHERE emailAddress = :emailAddress")})
@Table(name = "XUSER")
public class User extends PersistenceObject {
    private static final long serialVersionUID = -1679970109556600138L;

    @Id
    @Column(name = "XOID", columnDefinition = "XNUMBER(38)", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "XEMAILADDRESS", length = 200, nullable = true)
    private String emailAddress;
    
    @Column(name = "XFAILLOGINATTEMPTS", length = 1, nullable = true)
    private int failLoginAttempts;

    @Column(name = "XFIRSTNAME", length = 40, nullable = true)
    private String firstName;

    @Column(name = "XLASTNAME", length = 40, nullable = false)
    private String lastName;
    
    @Column(name = "XLOCKUSERINDICATOR", length = 1, nullable = false)
    private boolean lockUserIndicator;

    @Column(name = "XNUMBEROFLOGINS", length = 7, nullable = true)
    private int numberOfLogins;


    @Column(name = "XPASSWORDHASH", length = 40, nullable = true)
    private String passwordHash;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "XPROFILE_OID", referencedColumnName = "XOID", nullable = false)
    private Profile profile;
    
    @Column(name = "XMOBILENUMBER", length = 12, nullable = false)
    private String mobileNumber;

    public User() {

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

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	

}
