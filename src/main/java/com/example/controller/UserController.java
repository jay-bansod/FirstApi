package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.ResponseBean;
import com.example.bean.UserBean;
import com.example.dao.UserDao;
import com.example.util.HashExecutor;
import com.example.util.RandomTokenizer;
import com.example.util.SaltGenerator;

@RestController
public class UserController {

	public final int DEFAULT_SALT_SIZE = 16;
	public final int DEFAULT_TOKEN_SIZE = 64;

	@Autowired
	UserDao userDao;

	@PostMapping(value = "/users")
	public ResponseBean<UserBean> addUser(@RequestBody UserBean user) {

		if (userDao.getUserByEmail(user.getuser_email()) == null) {
			user.setUser_salt(SaltGenerator.getRandomSalt(DEFAULT_SALT_SIZE));
			String pwd = user.getUser_password();
			user.setUser_password(HashExecutor.getSHA512Hash(user.getUser_salt() + pwd));
			user.setUser_token(RandomTokenizer.getRandomToken(DEFAULT_TOKEN_SIZE));
			userDao.insertUser(user);
			user = userDao.getUserByToken(user.getUser_token());
			return new ResponseBean<UserBean>(200, "User Created", user);
		} else {
			return new ResponseBean<UserBean>(-1, "User Already Exist !", null);
		}

	}

}
