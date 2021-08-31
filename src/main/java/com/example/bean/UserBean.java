package com.example.bean;

public class UserBean {
	private int user_id;
	private String user_name;
	private String user_email;
	private String user_password;
	private String user_token;
	private String user_salt;

	public String getUser_salt() {
		return user_salt;
	}

	@Override
	public String toString() {
		return "UserBean [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email
				+ ", user_password=" + user_password + ", user_token=" + user_token + ", user_salt=" + user_salt
				+ ", user_isDeleted=" + user_isDeleted + "]";
	}

	public void setUser_salt(String user_salt) {
		this.user_salt = user_salt;
	}

	private String user_isDeleted;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getuser_email() {
		return user_email;
	}

	public void setuser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_token() {
		return user_token;
	}

	public void setUser_token(String user_token) {
		this.user_token = user_token;
	}

	public String getUser_isDeleted() {
		return user_isDeleted;
	}

	public void setUser_isDeleted(String user_isDeleted) {
		this.user_isDeleted = user_isDeleted;
	}

}
