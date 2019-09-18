package com.jntuh.cse.dms.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jntuh.cse.dms.model.Faculty;
import com.jntuh.cse.dms.model.Course;
import com.jntuh.cse.dms.model.Mapping;
import com.jntuh.cse.dms.dao.AdminDao;
import com.jntuh.cse.dms.model.Admin;
import com.jntuh.cse.dms.model.Student;

@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	AdminDao adminDao;
	
	@Override
	public Admin getAdminDetailsByUserId(String userId) {
		
		return adminDao.getAdminDetailsByUserId(userId);
	}

	
	
	
	@Override
	public void saveStudentDetails(Student student) {
		adminDao.saveStudentDetails(student);
		
	}

	@Override
	public List<Student> getStudentsList(int spyear, int spsem, String spsec) {
		
		return adminDao.getStudentsList(spyear,spsem,spsec);
	}

	@Override
	public Student getStudentDetails(String sid) {
		
		return adminDao.getStudentDetails(sid);
	}

	@Override
	public void deleteStudentDetails(String sid) {
		
		adminDao.deleteStudentDetails(sid);
		
	}
	@Override
	public List<Student> getAluminiStudentsList(int sjyear, int spyear, int spsem, String spsec) {
		return adminDao.getAluminiStudentsList(sjyear,spyear,spsem,spsec);
	}
	
	
	
	
	
	
	
	
	
	@Override
	public void saveFacultyDetails(Faculty faculty) {
		adminDao.saveFacultyDetails(faculty);
		
	}

	@Override
	public List<Faculty> getFacultysList() {
		
		return adminDao.getFacultysList();
	}

	@Override
	public Faculty getFacultyDetails(String fid) {
		
		return adminDao.getFacultyDetails(fid);
	}

	@Override
	public void deleteFacultyDetails(String fid) {
		
		adminDao.deleteFacultyDetails(fid);
		
		
	}

	
	
	
	
	

	@Override
	public void saveCourseDetails(Course course) {
		adminDao.saveCourseDetails(course);
		
	}

	@Override
	public List<Course> getCoursesList() {
		
		return adminDao.getCoursesList();
	}

	@Override
	public Course getCourseDetails(String cid) {
		
		return adminDao.getCourseDetails(cid);
	}

	@Override
	public void deleteCourseDetails(String cid) {
		
		adminDao.deleteCourseDetails(cid);
		
	
	}

	
	
	
	
	
	@Override
	public void deleteMappingDetails(int mid) {
		adminDao.deleteMappingDetails(mid);
	}

	@Override
	public List<Mapping> getMappingsList() {
		
		return adminDao.getMappingsList();
	}

	@Override
	public void saveMappingDetails(Mapping mapping) {
		
		adminDao.saveMappingDetails(mapping);
	}

	@Override
	public List<Object[]> getAllMappingsList() {
		return adminDao.getAllMappingsLsit();
	}




	
	
	
}
