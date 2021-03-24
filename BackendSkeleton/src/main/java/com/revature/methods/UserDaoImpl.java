package com.revature.methods;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.UserDao;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class UserDaoImpl implements UserDao{

	
	public void insert (User u) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(u);
		tx.commit();
	}

	public void update(User u) {
		// TODO Auto-generated method stub
		
	}

	public void delete(User u) {
		// TODO Auto-generated method stub
		
	}

	public List<User> selectAll() {
		Session ses = HibernateUtil.getSession();
		return ses.createQuery("from User", User.class).list();
	}

	public User selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User selectByUsername(String username) {
		Session ses = HibernateUtil.getSession();
		List<User> uList = ses.createQuery("from User where username='"+username+"'", User.class).list();
		
		if (uList.isEmpty()) {
			System.out.println("No User found with that username");
			return null;
		}
		
		return uList.get(0);
	}
	
}
