package com.example.bean;

public class ResponseBean<T>{
	private int statusCode;
	private String statusMsg;
	private T data;
	
	
	public ResponseBean() {}
	
	public ResponseBean(int statusCode, String statusMsg, T statusObj) {
		this.statusCode = statusCode;
		this.statusMsg = statusMsg;
		this.data = statusObj;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
