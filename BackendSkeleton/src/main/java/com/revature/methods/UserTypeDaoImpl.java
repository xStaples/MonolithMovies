package com.revature.methods;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.UserTypeDao;
import com.revature.models.UserType;
import com.revature.util.HibernateUtil;

public class UserTypeDaoImpl implements UserTypeDao{
	public void insert (UserType ut) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(ut);
		tx.commit();
	}

	public void update(UserType ut) {
		// TODO Auto-generated method stub
		
	}

	public void delete(UserType ut) {
		// TODO Auto-generated method stub
		
	}

	public List<UserType> selectAll() {
		Session ses = HibernateUtil.getSession();
		return ses.createQuery("from UserType", UserType.class).list();
	}

	public UserType selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserType selectByType(String type) {
		Session ses = HibernateUtil.getSession();
		List<UserType> utList = ses.createQuery("from UserType where type='"+type+"'", UserType.class).list();
		
		if (utList.isEmpty()) {
			System.out.println("No User found with that username");
			return null;
		}
		
		return utList.get(0);
	}
}
