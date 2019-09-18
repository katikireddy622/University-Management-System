package com.jntuh.cse.dms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jntuh.cse.dms.model.Faculty;
import com.jntuh.cse.dms.model.Student;

@Repository
public interface FacultyDao {

	public Faculty getFacultyDetailsByUserId(String userId);
	
public List<Object[]> getCourseDetails(String fid);
	
	public List<Object[]> getCourseDetails(int year,int sem,String sec);
	
	public void prasentAttendance(String sid,String cid,int total,int ayear,int year,int sem,String sec);
	public void absentAttendance(String sid,String cid,int total,int ayear,int year,int sem,String sec);
	
	public void updateAttendance(String sid,String cid,String date,int total,int ayear);
	
	
	public Student getStudentDetailsByUserId(String userId);
	
}
