package com.jntuh.cse.dms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jntuh.cse.dms.model.Faculty;

@Service
public interface FacultyService {

	public Faculty getFacultyDetailsByUserId(String userId);
	
	public List<Object[]> getCourseDetails(String fid);
	public List<Object[]> getCourseDetails(int year,int sem,String sec);
	
	public void prasentAttendance(String sid,String cid,int total,int ayear,int year,int sem,String sec);
	public void absentAttendance(String sid,String cid,int total,int ayear,int year,int sem,String sec);
	
	public void updateAttendance(String sid,String cid,String date,int total,int ayear);
	
}
