package com.tweetapp.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtRequestBean implements Serializable {
	private static final long serialVersionUID = 8110531924867030610L;

	private String loginId;
	private String password;
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
