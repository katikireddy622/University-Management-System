package com.jntuh.cse.dms.dao;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jntuh.cse.dms.model.Attendance;
import com.jntuh.cse.dms.model.CompositeKey;
import com.jntuh.cse.dms.model.Faculty;
import com.jntuh.cse.dms.model.Student;

@Repository
public class FacultyDaoImp implements FacultyDao {

	@Autowired
	SessionFactory sf;
	
	@Override
	public Faculty getFacultyDetailsByUserId(String userId) {
		Session s=sf.openSession();
		Faculty faculty=s.get(Faculty.class, userId);
		
		return faculty;
	}

	

	@Override
	public List<Object[]> getCourseDetails(String fid) {

        
		String hql=" select c.cid,c.cname,m.myear,m.msem,m.msec,m.mayear "
				+ " From Mapping m,Course c "
				+ " Where m.mfid='"+fid+"' and m.mcid=c.cid ";
		Session session=sf.openSession();
		@SuppressWarnings("unchecked")
		Query<Object[]> query= session.createQuery(hql);
		   List<Object[]> list=query.list();
		
		return list;
			
	
	
	
	}


	@Override
	public List<Object[]> getCourseDetails(int year, int sem, String sec) {
	
		
		
		String hql=" select s.sid,s.sname "
				+ " From Student s "
				+ " Where s.spyear=:year and s.spsem=:sem and s.spsec=:sec";
		
		Session session=sf.openSession();
		@SuppressWarnings("unchecked")
		Query<Object[]> query= session.createQuery(hql);
		
		query.setParameter("year",year);
		query.setParameter("sem",sem);
		query.setParameter("sec",sec);
		   List<Object[]> list=query.list();
		
		return list;
		
		
		
		
	}



	@Override
	public void prasentAttendance(String sid, String cid, int total, int ayear, int year, int sem, String sec) {
		
//		/* To get Local Time*/
//		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		   LocalDateTime now = LocalDateTime.now();
//		   
//		
//		   String date=dtf.format(now);
		
		
		
		Session s=sf.openSession();
		
		CompositeKey ck=new CompositeKey();
		ck.setAdate(new Date());
		ck.setCid(cid);
		ck.setSid(sid);
		
		Attendance attendance=new Attendance();
		attendance.setCompositeKey(ck);
		attendance.setAyear(ayear);
		attendance.setAttended(total);
		attendance.setAtotal(total);
		
		s.beginTransaction();
		s.saveOrUpdate(attendance);
		s.getTransaction().commit();
		   
		   
	}



	@Override
	public void absentAttendance(String sid, String cid, int total, int ayear, int year, int sem, String sec) {
		
//		/* To get Local Time*/
//		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		   LocalDateTime now = LocalDateTime.now();
//		   
//		
//		   String date=dtf.format(now);
//		
		
		
Session s=sf.openSession();
		
		CompositeKey ck=new CompositeKey();
		ck.setAdate(new Date());
		ck.setCid(cid);
		ck.setSid(sid);
		
		Attendance attendance=new Attendance();
		attendance.setCompositeKey(ck);
		attendance.setAyear(ayear);
		attendance.setAttended(0);
		attendance.setAtotal(total);
		
		s.beginTransaction();
		s.saveOrUpdate(attendance);
		s.getTransaction().commit();		
	}



	@Override
	public Student getStudentDetailsByUserId(String userId) {
	
		Session s=sf.openSession();
		Student student=s.get(Student.class, userId);
		
		return student;
	}



	@Override
	public void updateAttendance(String sid, String cid, String date, int total, int ayear) {
		
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();  
		
		Date date1=null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
         try {

            date1 = formatter.parse(date);
            System.out.println(date);
            

        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		
		
		String hql = "UPDATE Attendance set attended = :total "  + 
	             "WHERE sid = :sid "
	             + "and cid = :cid "
	             + "and ayear= :ayear "
	             + "and adate= :date ";
	@SuppressWarnings("rawtypes")
	Query query = session.createQuery(hql);
	query.setParameter("total", total);
	query.setParameter("sid", sid);
	query.setParameter("cid", cid);
	query.setParameter("ayear", ayear);
	
	query.setParameter("date", date1);
	@SuppressWarnings("unused")
	int result = query.executeUpdate();
	tx.commit(); 
	}
	
	
	
	
}
