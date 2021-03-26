package com.revature.service;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.methods.UserDaoImpl;
import com.revature.models.User;

public class UserService {

	public static UserDao uDao = new UserDaoImpl();
	
	public static void insert(User u) {
		uDao.insert(u);
	}
	
	public static User selectByUsername(String username) {
		List<User> all = uDao.selectAll();
		
		for(User u : all) {
			if (u.getUsername().equals(username)) {
				return u;
			} else {
				continue;
			}
		}
		return null;
	}
	
}
