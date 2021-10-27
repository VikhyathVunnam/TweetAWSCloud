package com.tweetapp.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JwtReponseBean implements Serializable {
	private static final long serialVersionUID = 5371056224136006966L;

	private String token;
	private Date expireIn;
	private String userId;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getExpireIn() {
		return expireIn;
	}
	public void setExpireIn(Date expireIn) {
		this.expireIn = expireIn;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
