package com.jntuh.cse.dms.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="users")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")	
	private String role;
	
	@Column(name="enabled")	
	private short enabled;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public short getEnabled() {
		return enabled;
	}

	public void setEnabled(short enabled) {
		this.enabled = enabled;
	}

	public Users(String id, String userName, String password, String role, short enabled) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
	}
	public Users() {
		// TODO Auto-generated constructor stub
	}
	
} 