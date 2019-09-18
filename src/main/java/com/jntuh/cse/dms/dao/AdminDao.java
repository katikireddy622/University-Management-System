package com.jntuh.cse.dms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jntuh.cse.dms.model.Faculty;
import com.jntuh.cse.dms.model.Course;
import com.jntuh.cse.dms.model.Mapping;
import com.jntuh.cse.dms.model.Admin;
import com.jntuh.cse.dms.model.Student;

@Repository
public interface AdminDao{

	public Admin getAdminDetailsByUserId(String userId);

	
	
	//student services...
	public void saveStudentDetails(Student student);

	public List<Student> getStudentsList(int spyear, int spsem, String spsec);

	public Student getStudentDetails(String sid);

	public void deleteStudentDetails(String sid);
	
	public List<Student> getAluminiStudentsList(int sjyear,int spyear, int spsem, String spsec);
	
	
	
	
	public void saveFacultyDetails(Faculty faculty);
	public List<Faculty> getFacultysList();
	public Faculty getFacultyDetails(String fid);
	public void deleteFacultyDetails(String fid);
	
	
	
	
	public void saveCourseDetails(Course course);
	public List<Course> getCoursesList();
	public Course getCourseDetails(String cid);
	public void deleteCourseDetails(String cid);

	
	
	public void deleteMappingDetails(int mid);
	public List<Mapping> getMappingsList();
	public void saveMappingDetails(Mapping mapping);
	public List<Object[]> getAllMappingsLsit();

}
