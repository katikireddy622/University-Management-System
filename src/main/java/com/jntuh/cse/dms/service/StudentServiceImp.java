package com.jntuh.cse.dms.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jntuh.cse.dms.dao.StudentDao;
import com.jntuh.cse.dms.model.Student;


@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	StudentDao studentDao;
	
	@Override
	public Student getStudentDetailsByUserId(String userId) {
		
		return studentDao.getStudentDetailsByUserId(userId);
	}

	@Override
	public List<Object[]> getCourseDetails(String sid) {
		return studentDao.getCoursesByUserId(sid);
	}

	@Override
	public List<Object[]> getAttendanceByUserIdAndDate(String sid, int ayear, String cid) {

		return studentDao.getAttendanceByUserIdAndDate(sid, ayear, cid);
	}

	@Override
	public long getPresentSemAttendance(String sid, int spyear, int spsem, String spsec) {
		
		return studentDao.getPresentSemAttendance(sid, spyear, spsem, spsec);
	}

		
	
}
