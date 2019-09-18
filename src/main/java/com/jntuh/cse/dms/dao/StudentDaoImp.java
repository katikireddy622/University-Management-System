package com.jntuh.cse.dms.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.jntuh.cse.dms.model.Student;


@Repository
public class StudentDaoImp implements StudentDao {

	@Autowired
	SessionFactory sf;
	
	@Autowired
	JdbcTemplate jt;
	
	@Override
	public Student getStudentDetailsByUserId(String userId) {
		Session s=sf.openSession();
		Student student=s.get(Student.class, userId);
		
		return student;
	}

	
	@Override
	public List<Object[]> getCoursesByUserId(String sid) {
		
	
		String hql=" select distinct a.compositeKey.cid,c.cname,a.ayear "
				+ " From Attendance a,Course c "
				+ " Where a.compositeKey.sid='"+sid+"' and a.compositeKey.cid=c.cid ";
		Session session=sf.openSession();
	
	
		@SuppressWarnings("unchecked")
		Query<Object[]> query= session.createQuery(hql);
		   List<Object[]> list=query.list();
	
   
	  return list;
	}


	@Override
	public List<Object[]> getAttendanceByUserIdAndDate(String sid, int ayear, String cid) {
		

		String hql=" select a.compositeKey.cid,a.compositeKey.adate,c.cname,a.attended,a.atotal"
				+ " From Attendance a,Course c "
				+ " Where a.compositeKey.sid='"+sid+"' and "
						+ "a.compositeKey.cid='"+cid+"'and "
								+ "a.ayear="+ayear+" and "
										+ "a.compositeKey.cid=c.cid ";
		
		Session session=sf.openSession();
	
		
	
		@SuppressWarnings("unchecked")
		Query<Object[]> query= session.createQuery(hql);
		   List<Object[]> list=query.list();
	
		   
		return list;
	}


	@Override
	public long getPresentSemAttendance(String sid, int spyear, int spsem, String spsec) {
	
		long average=0;
		long attended=0;
		long total=0;
		
		Session session=sf.openSession();
		
		String sql = "select max(ayear) from attendance_table"; 
        
		 long maxYear = (long) jt.queryForObject(sql,Long.class);

		
		
		
	String hql1="select sum(a.attended),sum(a.atotal) from Attendance a,Mapping m "
			+ "where a.compositeKey.sid='"+sid+"' and a.compositeKey.cid=m.mcid "
					+ "and a.ayear="+maxYear+" and m.msec='"+spsec+"' "
							+ "and m.msem="+spsem+" and m.myear="+spyear+" ";
	
	
	@SuppressWarnings("unchecked")
	Query<Object[]> query1= session.createQuery(hql1);
	   List<Object[]> list1=query1.list();

	   for (Object[] objects : list1) {
		
		   attended=(long) objects[0];
		   total=(long) objects[1];
	}
	   
	    average=(attended*100)/total;
				
		return average;
	}


}
