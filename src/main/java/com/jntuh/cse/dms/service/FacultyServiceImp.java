package com.jntuh.cse.dms.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jntuh.cse.dms.SmtpMailSender;
import com.jntuh.cse.dms.dao.FacultyDao;
import com.jntuh.cse.dms.model.Faculty;
import com.jntuh.cse.dms.model.Student;

@Service
public class FacultyServiceImp implements FacultyService {

	@Autowired
	FacultyDao facultyDao;
	
	@Autowired
	SmtpMailSender mailSender;
	
	
	
	@Override
	public Faculty getFacultyDetailsByUserId(String userId) {
		
		return facultyDao.getFacultyDetailsByUserId(userId);
	}

	@Override
	public List<Object[]> getCourseDetails(String fid) {
		
		return facultyDao.getCourseDetails(fid);
	}

	@Override
	public List<Object[]> getCourseDetails(int year, int sem, String sec) {
		
	  return facultyDao.getCourseDetails(year, sem, sec);
	}

	
	@Override
	public void prasentAttendance(String sid, String cid,int total,int ayear,int year,int sem,String sec) {
		
	   facultyDao.prasentAttendance(sid, cid,total,ayear,year,sem,sec);
	}
	@Override
	
	public void absentAttendance(String sid, String cid,int total,int ayear,int year,int sem,String sec) {
		
		Student student=facultyDao.getStudentDetailsByUserId(sid);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		String subject="Absent Alert...!";
		String body="Your Son/Daughter bearing roll number "+sid+" is Absent on "+dateFormat.format(date)+""
				+ "for course "+cid+" ";
		
		try {
			mailSender.send(student.getSfemail(),subject, body);
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		
	
	   facultyDao.absentAttendance(sid, cid,total,ayear,year,sem,sec);
	}

	@Override
	public void updateAttendance(String sid, String cid, String date, int total, int ayear) {
		facultyDao.updateAttendance(sid, cid, date, total, ayear);
		
	}
	
	
}
