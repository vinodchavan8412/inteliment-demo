package com.inteliment.demo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;


@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;

	@Column(name = "email_id", unique = true, nullable = false)
	private String emailId = null;

	@Column(name = "password")
	private String password = null;

	@Column(name = "mobile_no")
	private String mobileNo = null;

	@Column(name = "phone_no_home")
	private String phoneNoHome = null;

	@Column(name = "phone_no_work")
	private String phoneNoWork = null;

	@Column(name = "salutation")
	private String salutation = null;

	@Column(name = "first_name")
	private String firstName = null;

	@Column(name = "last_name")
	private String lastName = null;

	@Column(name = "dob")
	private String dob = null;

	@Column(name = "score")
	private Double score = null;

	@Column(name = "net_worth")
	private Double netWorth = null;

	

	@Column(name = "profile_pic")
	private String profilePic;

	@Column(name = "country_code")
	private String countryCode;

	@Column(name = "address")
	private String address;

	
	@Column(name = "device_token")
	private String deviceToken;

	@Column(name = "otp")
	private String otp;


	@Column(name = "identity_proof_id")
	private int identityProofId;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	@Column(name = "active")
	private int active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPhoneNoHome() {
		return phoneNoHome;
	}

	public void setPhoneNoHome(String phoneNoHome) {
		this.phoneNoHome = phoneNoHome;
	}

	public String getPhoneNoWork() {
		return phoneNoWork;
	}

	public void setPhoneNoWork(String phoneNoWork) {
		this.phoneNoWork = phoneNoWork;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Double getNetWorth() {
		return netWorth;
	}

	public void setNetWorth(Double netWorth) {
		this.netWorth = netWorth;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public int getIdentityProofId() {
		return identityProofId;
	}

	public void setIdentityProofId(int identityProofId) {
		this.identityProofId = identityProofId;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public User(Long id, String emailId, String password, String mobileNo, String phoneNoHome, String phoneNoWork,
			String salutation, String firstName, String lastName, String dob, Double score, Double netWorth,
			String profilePic, String countryCode, String address, String deviceToken, String otp, int identityProofId,
			Set<Role> roles, int active) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.password = password;
		this.mobileNo = mobileNo;
		this.phoneNoHome = phoneNoHome;
		this.phoneNoWork = phoneNoWork;
		this.salutation = salutation;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.score = score;
		this.netWorth = netWorth;
		this.profilePic = profilePic;
		this.countryCode = countryCode;
		this.address = address;
		this.deviceToken = deviceToken;
		this.otp = otp;
		this.identityProofId = identityProofId;
		this.roles = roles;
		this.active = active;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", emailId=" + emailId + ", password=" + password + ", mobileNo=" + mobileNo
				+ ", phoneNoHome=" + phoneNoHome + ", phoneNoWork=" + phoneNoWork + ", salutation=" + salutation
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", score=" + score
				+ ", netWorth=" + netWorth + ", profilePic=" + profilePic + ", countryCode=" + countryCode
				+ ", address=" + address + ", deviceToken=" + deviceToken + ", otp=" + otp + ", identityProofId="
				+ identityProofId + ", roles=" + roles + ", active=" + active + "]";
	}

	
	
	 

}