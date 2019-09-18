package com.jntuh.cse.dms.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.jntuh.cse.dms.model.Student;

@Repository
public interface StudentDao {

	public Student getStudentDetailsByUserId(String userId);
	
	public List<Object[]> getCoursesByUserId(String userId);
	

	public 	List<Object[]> getAttendanceByUserIdAndDate(String sid, int ayear, String cid);

	
	public long getPresentSemAttendance(String sid, int spyear, int spsem, String spsec);
}
