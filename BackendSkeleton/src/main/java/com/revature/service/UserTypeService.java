package com.revature.service;

import java.util.List;

import com.revature.dao.UserTypeDao;
import com.revature.methods.UserTypeDaoImpl;
import com.revature.models.UserType;

public class UserTypeService {
	public static UserTypeDao utDao = new UserTypeDaoImpl();
	
	public static void insert(UserType ut) {
		utDao.insert(ut);
	}
	
	public static UserType selectByType(String type) {
		List<UserType> all = utDao.selectAll();
		
		for(UserType ut : all) {
			if (ut.getType().equals(type)) {
				return ut;
			} else {
				continue;
			}
		}
		return null;
	}
	
}
