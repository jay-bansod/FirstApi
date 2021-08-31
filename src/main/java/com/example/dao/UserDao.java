package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public boolean insertUser(UserBean user) {
		int rowAffected = 0;
		try {
			rowAffected = stmt.update(
					"insert into users(user_name,user_email,user_password,user_token,user_salt) values(?,?,?,?,?)",
					user.getUser_name(), user.getuser_email(), user.getUser_password(), user.getUser_token(),
					user.getUser_salt());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowAffected == 1 ? true : false;
	}

	public UserBean getUserByToken(String user_token) {
		try {
			return stmt.queryForObject(
					"select user_name, user_email, user_token, user_salt from users where user_token = ? and user_isDeleted = 'ACTIVE' ",
					new BeanPropertyRowMapper<UserBean>(UserBean.class), user_token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public UserBean getUserByEmail(String user_email) {
		try {
			return stmt.queryForObject(
					"select user_id, user_name, user_email, user_password, user_token, user_salt from users where user_email = ? and user_isDeleted = 'ACTIVE' ",
					new BeanPropertyRowMapper<UserBean>(UserBean.class), user_email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateUserToken(int userId, String user_token) {
		int rowAffected = 0;
		try {
			System.out.println("userId : " + userId);
			System.out.println("userToken : " + user_token);
			rowAffected = stmt.update(
					"update users set user_token = ? where user_id = ? and user_isDeleted = 'ACTIVE' ", user_token,
					userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowAffected == 1 ? true : false;
	}
}
