package com.jntuh.cse.dms.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.jntuh.cse.dms.service.StudentService;



@Controller
@RequestMapping("/student/course")
public class StudentCourseController {
	
	@Autowired
	StudentService studentService;
	
	
	@GetMapping("/")
	public ModelAndView viewCourse(Principal principal)
	{
		List<Object[]> listOfCourse=studentService.getCourseDetails(principal.getName());
		ModelAndView mv=new ModelAndView("student/viewCourse");
		mv.addObject("listOfCourse", listOfCourse);
		mv.addObject("sid",principal.getName());
		
		return mv;
	}

}
