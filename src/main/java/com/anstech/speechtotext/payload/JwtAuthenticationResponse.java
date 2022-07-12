package com.anstech.speechtotext.payload;

public class JwtAuthenticationResponse {
	private String accessToken;
	private String tokenType = "Bearer";
	private String getUsernameOrEmail;

	public JwtAuthenticationResponse(String accessToken, String getUsernameOrEmail) {
		this.accessToken = accessToken;
		this.getUsernameOrEmail = getUsernameOrEmail;
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

	public String getGetUsernameOrEmail() {
		return getUsernameOrEmail;
	}

	public void setGetUsernameOrEmail(String getUsernameOrEmail) {
		this.getUsernameOrEmail = getUsernameOrEmail;
	}
}
