package com.dfmp.users;

import java.util.Date;

public class User {
	private long id;
	private String name;
	private Date userCreation;

	public User() {
		super();
	}
	public User(long id, String name, Date userCreation) {
		super();
		this.id = id;
		this.name = name;
		this.userCreation = userCreation;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getUserCreation() {
		return userCreation;
	}
	public void setUserCreation(Date userCreation) {
		this.userCreation = userCreation;
	}

}
