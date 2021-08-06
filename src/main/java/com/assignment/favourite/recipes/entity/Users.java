package com.assignment.favourite.recipes.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER_TBL")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_Id", updatable = false, nullable = false)
	private Long userId;
	
	@Column(name = "user_name", length = 100, unique = true, nullable = false)
	private String userName;
	private String email;
	private char active;
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="user_role", joinColumns= 
			@JoinColumn(name="user_Id"), inverseJoinColumns=
			@JoinColumn(name="role_Id"))
	private Set<Role> roles;
	
	public Users() {
		
	}

	public Users(Users user) {
		super();
		this.userId = user.userId;
		this.userName = user.userName;
		this.email = user.email;
		this.active = user.active;
		this.roles = user.roles;
		this.password = user.password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getActive() {
		return active;
	}

	public void setActive(char active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}