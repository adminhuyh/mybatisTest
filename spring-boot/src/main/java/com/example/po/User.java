package com.example.po;


import javax.persistence.Entity;
import javax.persistence.Table;


import com.example.common.CommonEntity;


@Entity
@Table(name = "tb_user")
public class User extends CommonEntity{
	
	/**
	 * 
	 */	
	
	private String username;
	
	private String password;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
