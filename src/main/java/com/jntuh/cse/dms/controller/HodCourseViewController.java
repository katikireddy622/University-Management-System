package com.jntuh.cse.dms.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jntuh.cse.dms.model.Course;
import com.jntuh.cse.dms.service.AdminService;



@Controller
@RequestMapping("/hod/course")
public class HodCourseViewController {

	@Autowired
	AdminService AdminService;
	
	
//	@GetMapping(value="/")
//	public String courseIndex() {
//		
//		return "admin/courseServices";
//	}
//
//	@GetMapping("/add")
//	public String addCourseGet(ModelMap map) {
//		map.addAttribute("course",new Course());
//		return "admin/addCourse";
//	}
//	
//	
//	@RequestMapping(value="/add",method=RequestMethod.POST)
//	public ModelAndView addCourse(@Valid @ModelAttribute("course") Course course,BindingResult result)
//	{
//		
//		if(result.hasErrors())
//		{
//			ModelAndView mv=new ModelAndView("admin/addCourse");
//			return mv;
//			
//		}
//		AdminService.saveCourseDetails(course);
//
//		ModelAndView mv=new ModelAndView("admin/addCourse").addObject("message", "Course Added Succesfully");
//		
//		
//		return mv;
//		
//	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public ModelAndView viewCourse()
	{
		List<Course> listOfCourses=AdminService.getCoursesList();
		
		ModelAndView mv=new ModelAndView("hod/viewCourses");
		mv.addObject("listOfCourses",listOfCourses);
		
		return mv;
	}

	
//	@RequestMapping(value="/update",method=RequestMethod.GET)
//	public String updateCourse(@RequestParam("cid") String cid,ModelMap model)
//	{
//		Course course=AdminService.getCourseDetails(cid);
//		model.put("course",course);
//		
//		return "admin/addCourse";
//	}
//	
//
//	@RequestMapping(value="/delete",method=RequestMethod.GET)
//	public String deleteCourse(@RequestParam("cid") String cid,ModelMap model)
//	{
//		AdminService.deleteCourseDetails(cid);
//		
//		
//		return "redirect:/admin/course/view";
//	}
	
	
}
