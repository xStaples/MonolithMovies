package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface UserDao {
	
	public void insert(User u);
	public void update(User u);
	public void delete(User u);
	
	public List<User> selectAll();
	public User selectById(int id);
	public User selectByUsername(String username);

}
