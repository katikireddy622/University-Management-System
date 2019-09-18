package com.jntuh.cse.dms.service;



import java.util.List;



import org.springframework.stereotype.Service;

import com.jntuh.cse.dms.model.Course;
import com.jntuh.cse.dms.model.Mapping;
import com.jntuh.cse.dms.model.Admin;
import com.jntuh.cse.dms.model.Faculty;
import com.jntuh.cse.dms.model.Student;

@Service
public interface AdminService {

	public Admin getAdminDetailsByUserId(String userId);

	
	
	
	//student services...
	public void saveStudentDetails(Student student);
	public Student getStudentDetails(String sid);
	public void deleteStudentDetails(String sid);
	public List<Student> getStudentsList(int spyear, int spsem, String spsec);
	public List<Student> getAluminiStudentsList(int sjyear,int spyear, int spsem, String spsec);



	//faculty services...
	public void saveFacultyDetails(Faculty faculty);
	public List<Faculty> getFacultysList();
	public Faculty getFacultyDetails(String fid);
	public void deleteFacultyDetails(String fid);
	
	
	//course services...
	public void saveCourseDetails(Course course);
	public List<Course> getCoursesList();
	public Course getCourseDetails(String cid);
	public void deleteCourseDetails(String cid);
	
	
	//mapping services...
	public void deleteMappingDetails(int mid);
	public List<Mapping> getMappingsList();
	public void saveMappingDetails(Mapping mapping);
	public List<Object[]> getAllMappingsList();




	
	
	
}
