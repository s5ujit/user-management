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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.appliedsni.entity.PersistenceObject;
@Entity
@Table(name = "XUSER",uniqueConstraints={@UniqueConstraint(columnNames={"XEMAILADDRESS","XMOBILENUMBER"})})
public class User extends PersistenceObject implements Serializable{
    private static final long serialVersionUID = -1679970109556600138L;

    @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "XID", columnDefinition = "NUMBER(38)", nullable = false)
    private Long id;
    
    @Column(name = "XEMAILADDRESS", length = 200, nullable = false)
    private String emailAddress;
    
    @Column(name = "XFAILLOGINATTEMPTS", length = 1, nullable = true)
    private int failLoginAttempts;

    @Column(name = "XFIRSTNAME", length = 40, nullable = true)
    private String firstName;

    @Column(name = "XLASTNAME", length = 40, nullable = true)
    private String lastName;
    
    @Column(name = "XLOCKUSERINDICATOR", length = 1, nullable = false)
    private Boolean lockUserIndicator=true;


    @Column(name = "XPASSWORDHASH", length = 40, nullable = true)
    private String passwordHash;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "XPROFILE_OID", referencedColumnName = "XID", nullable = false)
    private Profile profile;
    
    @Column(name = "XMOBILENUMBER", length = 12, nullable = true)
    private String mobileNumber;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="XUSER_COMPANYLINK",
        joinColumns = {@JoinColumn(name="XUSER", referencedColumnName="XID")},
        inverseJoinColumns = {@JoinColumn(name="XCOMPANY", referencedColumnName="XID")}
    )
    private Set<Company> company;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="XUSER_PROJECT_LINK",
        joinColumns = {@JoinColumn(name="XUSER", referencedColumnName="XID")},
        inverseJoinColumns = {@JoinColumn(name="XPROJECT", referencedColumnName="XID")})
    private Set<Project> project;
    
    public User() {

    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	public Boolean isLockUserIndicator() {
		return lockUserIndicator;
	}
	public void setLockUserIndicator(Boolean lockUserIndicator) {
		this.lockUserIndicator = lockUserIndicator;
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
	
	public Set<Company> getCompany() {
		return company;
	}

	public void setCompany(Set<Company> company) {
		this.company = company;
	}

	public Set<Project> getProject() {
		return project;
	}
	public void setProject(Set<Project> project) {
		this.project = project;
	}

	

}
