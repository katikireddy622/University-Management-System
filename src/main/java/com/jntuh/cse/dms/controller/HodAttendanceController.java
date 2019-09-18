package com.jntuh.cse.dms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jntuh.cse.dms.service.FacultyService;



@Controller
@RequestMapping("/hod/attendance")
public class HodAttendanceController {
	
	@Autowired
	FacultyService facultyService;
	
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView listStudents(@RequestParam("cid") String cid,
			@RequestParam("year") int year,
			@RequestParam("sem") int sem,
			@RequestParam("ayear") int ayear,
			@RequestParam("sec") String sec,ModelMap model) {
		
		List<Object[]> listOfStudents=facultyService.getCourseDetails(year, sem, sec);
		ModelAndView mv=new ModelAndView("hod/studentAttendance");
		model.addAttribute("cid",cid);
		model.addAttribute("year", year);
		model.addAttribute("sem", sem);
		model.addAttribute("sec", sec);
		model.addAttribute("ayear", ayear);
		model.addAttribute("listOfStudents", listOfStudents);
		mv.addAllObjects(model);
		return mv;
	}


	@RequestMapping(value="/both",method=RequestMethod.POST)
	public String pasesntView(@RequestParam(value="prasentList",defaultValue="dummy") List<String> prasentList,
			@RequestParam(value="absentList",defaultValue="dummy") List<String> absentList,
			@RequestParam(value="numberOfClasses",required=true,defaultValue="2") int numberOfClasses,
			@RequestParam("cid") String cid,
			@RequestParam("year") int year,
			@RequestParam("sem") int sem,
			@RequestParam("ayear") int ayear,
			@RequestParam("sec") String sec,ModelMap model)
	{
	
		
		if(!prasentList.get(0).equals("dummy"))
		{
			for (String pl : prasentList) {
				
				facultyService.prasentAttendance(pl, cid, numberOfClasses,ayear,year,sem,sec);
			
			}
		}
		
		if(!absentList.get(0).equals("dummy"))
		{
			
			
				for (String al : absentList) {
				
				 facultyService.absentAttendance(al, cid, numberOfClasses,ayear,year,sem,sec);
				}
			
		}
		
		model.addAttribute("success", "Success ! Attendance Updated Sucessfully...");
		
		
		return "redirect:/hod/attendance/list?cid="+cid+"&year="+year+"&sem="+sem+"&sec="+sec+"&ayear="+ayear+"";
	}
	
	
	
}
