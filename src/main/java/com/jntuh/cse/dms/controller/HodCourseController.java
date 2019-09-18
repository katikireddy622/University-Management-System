package com.jntuh.cse.dms.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.jntuh.cse.dms.service.FacultyService;



@Controller
@RequestMapping("/hod/course")
public class HodCourseController {
	
	@Autowired
	FacultyService facultyService;
	
	@GetMapping("/")
	public ModelAndView viewCourse(Principal principal)
	{
		String fid=principal.getName();
		List<Object[]> listOfCourse=facultyService.getCourseDetails(fid);
		ModelAndView mv=new ModelAndView("hod/viewCourse");
		mv.addObject("listOfCourse", listOfCourse);
		
		return mv;
	}

}
