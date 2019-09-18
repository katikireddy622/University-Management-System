package com.jntuh.cse.dms.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jntuh.cse.dms.model.Course;
import com.jntuh.cse.dms.model.Student;
import com.jntuh.cse.dms.service.AdminService;
import com.jntuh.cse.dms.service.FacultyService;
import com.jntuh.cse.dms.service.StudentService;



@Controller
@RequestMapping("/admin/attendance")
public class AdminAttendanceController {

	@Autowired
	AdminService AdminService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	FacultyService facultyService;
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateAttendance(ModelMap model)
	{	
		return "admin/updateAttendance";
	}
	
	@RequestMapping(value="/selectAttendance",method=RequestMethod.GET)
	public String selectAttendance(ModelMap model)
	{
		return "admin/selectAttendance";
	}
	
	@RequestMapping(value="/viewPresentAttendance",method=RequestMethod.GET)
	public ModelAndView viewPresentAttendance(@RequestParam("spyear") int spyear,
			@RequestParam("spsem") int spsem,
			@RequestParam("spsec") String spsec,ModelMap model)
	{
		List<Student> listOfStudents=AdminService.getStudentsList(spyear,spsem,spsec);
		
		HashMap<String, Long> hm=new HashMap<>();
		
		for (Student student : listOfStudents) {
			
			long attendance=0;
			
			try {
				attendance=studentService.getPresentSemAttendance(student.getSid(), student.getSpyear(), student.getSpsem(),student.getSpsec());
					
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			
			hm.put(student.getSid(), attendance);
		}
		
		ModelAndView mv=new ModelAndView("admin/listOfStudentsWithAttendance");
		mv.addObject("hm", hm);
		
		return mv;
	}
	
	@RequestMapping(value="/updateValue",method=RequestMethod.GET)
	public String updateAttendance(@RequestParam("sid") String sid,
			@RequestParam("cid") String cid,
			@RequestParam("date") String date,
			@RequestParam("ayear") int ayear,
			@RequestParam("value") int value,ModelMap model)
	{	
		
		facultyService.updateAttendance(sid, cid, date, value, ayear);
		
			model.addAttribute("success", "Success ! Attendance Updated Sucessfully...");
		return "redirect:/admin/attendance/viewAttendanceAfterUpdate?cList="+cid+"&ayear="+ayear+"&rollNumber="+sid+" ";
	}
	
		
	@RequestMapping(value="/viewAttendanceAfterUpdate",method=RequestMethod.GET)
	public ModelAndView viewAttendanceAfterUpdate(@RequestParam("rollNumber") String rollNumber,
			@RequestParam("cList") String cList,
			@RequestParam("ayear") int ayear,ModelMap model)
	{	
		
		int attended=0;
		int total=0;
		int average=0;
		
		ModelAndView mv=new ModelAndView("admin/viewAttendance");
		
		List<Object[]> list=studentService.getAttendanceByUserIdAndDate(rollNumber, ayear, cList);
		
		
			for (Object[] objects : list) {
			
			
						attended+=(int)objects[3];
						total+=(int)objects[4];
			
				}
		if(!list.isEmpty()) {
		average=(attended*100/total);
		
		mv.addObject("average",average);
		}
		

		mv.addObject("list",list);
		mv.addObject("sid",rollNumber);
		mv.addObject("cid",cList);
		mv.addObject("ayear",ayear);
		
		return mv;
	
	}
	
	
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public ModelAndView viewAttendance(@RequestParam("rollNumber") String rollNumber,
			@RequestParam("cList") String cList,
			@RequestParam("ayear") int ayear,ModelMap model)
	{	
		
		int attended=0;
		int total=0;
		int average=0;
		
		ModelAndView mv=new ModelAndView("admin/viewAttendance");
		
		List<Object[]> list=studentService.getAttendanceByUserIdAndDate(rollNumber, ayear, cList);
		
		
			for (Object[] objects : list) {
			
			
						attended+=(int)objects[3];
						total+=(int)objects[4];
			
				}
		if(!list.isEmpty()) {
		average=(attended*100/total);
		
		mv.addObject("average",average);
		}
		

		mv.addObject("list",list);
		mv.addObject("sid",rollNumber);
		mv.addObject("cid",cList);
		mv.addObject("ayear",ayear);
		
		return mv;
	
	}
	
	@ModelAttribute("coursesList")
	   public Map<String, String> getCoursesList() {
	      Map<String, String> coursesList = new HashMap<String, String>();
	      
	      List<Course> list=AdminService.getCoursesList();
	    
	    		  for(Course c:list)
	    		  {
	    			  coursesList.put(c.getCid(),c.getCname());
	    		  }
	    		  
	    	  
	      return coursesList;
	   }
	
	
	
	
	
}
