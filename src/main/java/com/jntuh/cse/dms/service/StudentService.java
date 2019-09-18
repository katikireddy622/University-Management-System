package com.jntuh.cse.dms.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.jntuh.cse.dms.model.Student;

@Service
public interface StudentService {

	public Student getStudentDetailsByUserId(String userId);
	
	public List<Object[]> getCourseDetails(String sid);
	
	public 	List<Object[]> getAttendanceByUserIdAndDate(String sid, int ayear, String cid);
	
	public long getPresentSemAttendance(String sid, int spyear, int spsem, String spsec);

}
