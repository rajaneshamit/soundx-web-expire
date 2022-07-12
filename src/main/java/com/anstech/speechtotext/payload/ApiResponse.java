package com.anstech.speechtotext.payload;

public class ApiResponse {
	private Boolean success;
	private String message;
	private Object user;

	public ApiResponse(Boolean success, String message, Object user) {
		super();
		this.success = success;
		this.message = message;
		this.user = user;
	}

	public ApiResponse(Boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getUser() {
		return user;
	}

	public void setUser(Object user) {
		this.user = user;
	}

}
