package com.revature.dao;

import java.util.List;

import com.revature.models.User;
import com.revature.models.UserType;

public interface UserTypeDao {
	
	public void insert(UserType ut);
	public void update(UserType ut);
	public void delete(UserType ut);
	
	public List<UserType> selectAll();
	public UserType selectById(int id);
	public UserType selectByType(String type);

}
