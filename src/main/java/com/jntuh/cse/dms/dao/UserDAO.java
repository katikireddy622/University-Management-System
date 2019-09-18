package com.jntuh.cse.dms.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.jntuh.cse.dms.model.Users;

@Repository
@Transactional
public class UserDAO {
	@Autowired
	private SessionFactory sf;
	
	
	public Users getActiveUser(String userName) {
		
//		short enabled = 1;
		
		
		Session s=sf.openSession();
		Users uinfo= s.get(Users.class,userName);
		
//		String hql="FROM UserInfo WHERE userName="+userName+" and enabled="+enabled+" ";
//		Session session=sf.openSession();
//		TypedQuery<UserInfo> query=session.createQuery(hql,UserInfo.class); 
//		List<UserInfo> list=query.getResultList();
//		
//		UserInfo uinfo=(UserInfo)list.get(0);	
		
		return uinfo;
	}
} 