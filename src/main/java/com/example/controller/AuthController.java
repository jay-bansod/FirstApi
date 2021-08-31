package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.LoginBean;
import com.example.bean.ResponseBean;
import com.example.bean.UserBean;
import com.example.dao.UserDao;
import com.example.util.HashExecutor;
import com.example.util.RandomTokenizer;

@RestController
public class AuthController {

	public final int DEFAULT_SALT_SIZE = 16;
	public final int DEFAULT_TOKEN_SIZE = 64;

	@Autowired
	UserDao userDao;

	@PostMapping("/authenticate")
	public ResponseBean<UserBean> authenticateUser(@RequestBody LoginBean user) {
		UserBean dbUser = userDao.getUserByEmail(user.getUser_email());

		if (dbUser != null) {
			String userPwd = HashExecutor.getSHA512Hash(dbUser.getUser_salt() + user.getUser_password());
			if (userPwd.equals(dbUser.getUser_password())) {
//				Generate new token for user
				if (userDao.updateUserToken(dbUser.getUser_id(), RandomTokenizer.getRandomToken(DEFAULT_TOKEN_SIZE))) {
//					get reflected user with new token
					dbUser = userDao.getUserByEmail(user.getUser_email());
					return new ResponseBean<UserBean>(200, "user authenticate !", dbUser);
				} else {
					return new ResponseBean<UserBean>(-1, "could not generate new token !", dbUser);
				}
			} else {
				return new ResponseBean<UserBean>(-1, "Invalid email or password", null);
			}
		} else {
			return new ResponseBean<UserBean>(-1, "Invalid email or password", null);
		}
	}
}
