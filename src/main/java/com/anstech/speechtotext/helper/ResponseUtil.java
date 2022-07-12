package com.anstech.speechtotext.helper;

public class ResponseUtil {
	private String mesg;
	private Object object;
	public ResponseUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseUtil(Object object, String mesg) {
		super();
		this.object = object;
		this.mesg = mesg;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public String getMesg() {
		return mesg;
	}
	public void setMesg(String mesg) {
		this.mesg = mesg;
	}
	
	
}
