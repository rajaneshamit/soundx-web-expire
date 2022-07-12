package com.anstech.speechtotext.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user_details")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	// @Size(max = 40)
	private String firstName;

	@NotBlank
	// @Size(max = 15)
	private String lastName;

	@NotBlank
	// @Size(max = 200)
	private String mobile;

	@NotBlank
	// @Size(max = 40)
	@Email
	private String email;

	@NotBlank
	// @Size(max = 100)
	private String password;

	// private String address; // for agent only

	@Column(name = "active")
	private String active;

	// @ManyToMany(fetch = FetchType.LAZY)
	// @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
	// inverseJoinColumns = @JoinColumn(name = "role_id"))
	// private Set<Role> roles = new HashSet<>();

	public User() {

	}

	public User(String firstName, String lastName, String email, String password, String mobile, String active) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.active = active;
		// this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile=" + mobile
				+ ", email=" + email + ", password=" + password + ", active=" + active + "]";
	}
	
	

}
