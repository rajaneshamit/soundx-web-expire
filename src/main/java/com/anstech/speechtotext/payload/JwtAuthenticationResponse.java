package com.anstech.speechtotext.payload;

import com.anstech.speechtotext.model.UserResponse;

public class JwtAuthenticationResponse {
	private String accessToken;
	private String tokenType = "Bearer";
		private UserResponse user;

	public JwtAuthenticationResponse(String accessToken, String getUsernameOrEmail) {
		this.accessToken = accessToken;
	}

	public JwtAuthenticationResponse(String accessToken, String tokenType, UserResponse user) {
		super();
		this.accessToken = accessToken;
		this.tokenType = tokenType;
		this.user = user;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}


	public UserResponse getUser() {
		return user;
	}

	public void setUser(UserResponse user) {
		this.user = user;
	}

}
