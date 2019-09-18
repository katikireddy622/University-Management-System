package com.jntuh.cse.dms.dao;


import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.jntuh.cse.dms.model.Student;
import com.jntuh.cse.dms.model.Users;
import com.jntuh.cse.dms.model.Faculty;
import com.jntuh.cse.dms.model.Course;
import com.jntuh.cse.dms.model.Mapping;
import com.jntuh.cse.dms.model.Admin;

@Repository
public class AdminDaoImp implements AdminDao{

	@Autowired
	SessionFactory sf;
	
	@Override
	public Admin getAdminDetailsByUserId(String userId) {
		Session s=sf.openSession();
		Admin admin=s.get(Admin.class, userId);
		
		return admin;
	}

	
	
	@Override
	public void saveStudentDetails(Student student) {
		
		Users users=new Users();
		users.setId(student.getSid());
		users.setUserName(student.getSid());
		users.setEnabled((short)1);
		users.setRole("ROLE_STUDENT");
		
		BCryptPasswordEncoder encoder=null;
		try {
		encoder= new BCryptPasswordEncoder();
		}catch (Exception e) {
			
		}
		
		users.setPassword(encoder.encode(student.getSpw()));
		
		try {
			Session session=sf.openSession();
			 session.beginTransaction();
			 session.saveOrUpdate(student);
		 session.saveOrUpdate(users);
            session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> getStudentsList(int spyear, int spsem, String spsec) {
		
		String hql="From Student s "
				+ "Where s.spyear='"+spyear+"' and s.spsem='"+spsem+"' and s.spsec='"+spsec+"' ";
		
		Session session=sf.openSession();
		TypedQuery<Student> query=session.createQuery(hql,Student.class); 
		List<Student> list=query.getResultList();
		return list;
	}
	
	
	@Override
	public List<Student> getAluminiStudentsList(int sjyear, int spyear, int spsem, String spsec) {
		String hql="From Student s "
				+ "Where s.sjyear='"+sjyear+"' and s.spyear='"+spyear+"' and s.spsem='"+spsem+"' and s.spsec='"+spsec+"' ";
		
		Session session=sf.openSession();
		TypedQuery<Student> query=session.createQuery(hql,Student.class); 
		List<Student> list=query.getResultList();
		return list;
	}

	@Override
	public Student getStudentDetails(String sid) {
		
		Session s=sf.openSession();
		Student student=s.get(Student.class,sid);
		return student;
	}

	@Override
	public void deleteStudentDetails(String sid) {
		try {
			Session session=sf.openSession();
			Student student=session.get(Student.class,sid);
			Users users=session.get(Users.class, sid);
			session.beginTransaction();
			session.delete(student);
			session.delete(users);
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		
	}


	
	
	@Override
	public void saveFacultyDetails(Faculty faculty) {
		
		Users users=new Users();
		users.setEnabled((short)1);
		users.setId(faculty.getFid());
		users.setUserName(faculty.getFid());
		if(faculty.getFdes().equalsIgnoreCase("hod"))
		{
			users.setRole("ROLE_HOD");
		}
		else {
			users.setRole("ROLE_FACULTY");
		}
		
		BCryptPasswordEncoder encoder=null;
		try {
		encoder= new BCryptPasswordEncoder();
		}catch (Exception e) {
			
		}
		
		users.setPassword(encoder.encode(faculty.getFpw()));
		
		
		try {
			Session session=sf.openSession();
			session.beginTransaction();
			 session.saveOrUpdate(faculty);
			 session.saveOrUpdate(users);
            session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Faculty> getFacultysList() {
		
		String hql="From Faculty";
		Session session=sf.openSession();
		TypedQuery<Faculty> query=session.createQuery(hql,Faculty.class); 
		List<Faculty> list=query.getResultList();
		return list;
	}

	@Override
	public Faculty getFacultyDetails(String fid) {
		
		Session s=sf.openSession();
		Faculty faculty=s.get(Faculty.class,fid);
		return faculty;
	}

	@Override
	public void deleteFacultyDetails(String fid) {
		try {
			Session session=sf.openSession();
			Faculty faculty=session.get(Faculty.class,fid);
			session.beginTransaction();
			 session.delete(faculty);
            session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	
	
	
	
	
	
	
	@Override
	public void saveCourseDetails(Course course) {
		
		try {
			Session session=sf.openSession();
			session.beginTransaction();
			 session.saveOrUpdate(course);
            session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public List<Course> getCoursesList() {
		
		String hql="From Course";
		Session session=sf.openSession();
		TypedQuery<Course> query=session.createQuery(hql,Course.class); 
		List<Course> list=query.getResultList();
		return list;
	}

	@Override
	public Course getCourseDetails(String cid) {
		
		Session s=sf.openSession();
		Course course=s.get(Course.class,cid);
		return course;
	}

	@Override
	public void deleteCourseDetails(String cid) {
		
		
		try {
			Session session=sf.openSession();
			Course course=session.get(Course.class,cid);
			session.beginTransaction();
			 session.delete(course);
            session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void deleteMappingDetails(int mid) {
		try {
			Session session=sf.openSession();
			Mapping mapping=session.get(Mapping.class,mid);
			session.beginTransaction();
			 session.delete(mapping);
            session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Mapping> getMappingsList() {
		

		String hql="From Mapping";
		Session session=sf.openSession();
		TypedQuery<Mapping> query=session.createQuery(hql,Mapping.class); 
		List<Mapping> list=query.getResultList();
		return list;
		
	}

	@Override
	public void saveMappingDetails(Mapping mapping) {
		
		try {
			Session session=sf.openSession();
			session.beginTransaction();
			 session.saveOrUpdate(mapping);
            session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Object[]> getAllMappingsLsit() {
		
		String hql="select m.mfid,f.fname,m.mcid,c.cname,m.myear,m.msem,m.msec,m.mid,m.mayear "
				+ "From Faculty f,Mapping m,Course c "
				+ "Where m.mfid=f.fid and m.mcid=c.cid";
		Session session=sf.openSession();
		 @SuppressWarnings("unchecked")
		Query<Object[]> query= session.createQuery(hql);
		   List<Object[]> list=query.list();
		
		return list;
	}



	
	
}
