package com.jntuh.cse.dms.controller;

import java.security.Principal;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jntuh.cse.dms.model.Student;
import com.jntuh.cse.dms.service.StudentService;

@Controller
@RequestMapping("/student/attendance")
public class StudentAttendanceController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView attendanceList(@RequestParam("ayear") int ayear,@RequestParam("cid") String cid,
			@RequestParam("sid") String sid)
	{
	
		int attended=0;
		int total=0;
		int average=0;
		ModelAndView mv=new ModelAndView("student/viewAttendance");
		
		List<Object[]> list=studentService.getAttendanceByUserIdAndDate(sid, ayear, cid);
		
		
		for (Object[] objects : list) {
			
			
			attended+=(int)objects[3];
			total+=(int)objects[4];
			
		}
		
		average=(attended*100/total);
		
		mv.addObject("average",average);
		mv.addObject("list",list);
		
		return mv;
	}

	@RequestMapping("/presentSem")
	public ModelAndView presentSemAttendance(Principal principal)
	{
		String sid=principal.getName();
		
		Student student=studentService.getStudentDetailsByUserId(sid);
		
		long attendance=0;
		
		try {
			attendance=studentService.getPresentSemAttendance(student.getSid(), student.getSpyear(), student.getSpsem(),student.getSpsec());
				
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		ModelAndView mv=new ModelAndView("student/dashboard");
		mv.addObject("attendance", attendance);
		
		return mv;
	}
	
	
	
}
