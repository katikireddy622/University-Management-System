package com.jntuh.cse.dms.controller;




import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.jntuh.cse.dms.model.Student;
import com.jntuh.cse.dms.service.AdminService;

@Controller
@RequestMapping("/admin/student")
public class AdminStudentController {

	@Autowired
	AdminService AdminService;

	@RequestMapping(value="/")
	public String studentIndex(){
		
		return "admin/studentServices";
	}
	
	@GetMapping("/add")
	public String addStudentGet(ModelMap map) {
		map.addAttribute("student",new Student());
		return "admin/addStudent";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class,"sdob", new CustomDateEditor(sdf, false));
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView addStudent(@Valid @ModelAttribute("student") Student student,BindingResult result)
	{
		
		if(result.hasErrors())
		{
			ModelAndView mv=new ModelAndView("admin/addStudent");
			return mv;
			
		}
		AdminService.saveStudentDetails(student);

		ModelAndView mv=new ModelAndView("admin/addStudent").addObject("message", "Student Added Succesfully");
		
		
		return mv;
		
	}
	
	
	@RequestMapping(value="/select",method=RequestMethod.GET)
	public ModelAndView selectStudent()
	{
		ModelAndView mv=new ModelAndView("admin/selectStudents");
		
		return mv;
	}
	
	
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public ModelAndView viewStudent(@RequestParam("spyear") int spyear,
			@RequestParam("spsem") int spsem,
			@RequestParam("spsec") String spsec,ModelMap model)
	{
		
		
		List<Student> listOfStudents=AdminService.getStudentsList(spyear,spsem,spsec);
		
		ModelAndView mv=new ModelAndView("admin/viewStudents");
		mv.addObject("listOfStudents",listOfStudents);
		
		return mv;
	}
	
	
	@RequestMapping(value="/viewAlumini",method=RequestMethod.GET)
	public ModelAndView viewAluminiStudent(@RequestParam("sjyear") int sjyear,
			@RequestParam("spyear") int spyear,
			@RequestParam("spsem") int spsem,
			@RequestParam("spsec") String spsec,ModelMap model)
	{
		
		
		List<Student> listOfStudents=AdminService.getAluminiStudentsList(sjyear, spyear, spsem, spsec);
		
		ModelAndView mv=new ModelAndView("admin/viewStudents");
		mv.addObject("listOfStudents",listOfStudents);
		
		return mv;
	}
	
	
	

	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateStudent(@RequestParam("sid") String sid,ModelMap model)
	{
		Student student=AdminService.getStudentDetails(sid);
		model.put("student",student);
		
		return "admin/addStudent";
	}
	

	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteStudent(@RequestParam("sid") String sid,
			@RequestParam("spyear") int spyear,
			@RequestParam("spsem") int spsem,
			@RequestParam("spsec") String spsec,ModelMap model)
	{
		AdminService.deleteStudentDetails(sid);
		
		
		return "redirect:/admin/student/view?spyear="+spyear+"&spsem="+spsem+"&spsec="+spsec+"";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 @ModelAttribute("branchesList")
	   public Map<String, String> getBranchesList() {
	      Map<String, String> branchesList = new HashMap<String, String>();
	      branchesList.put("CSE", "CSE");
	      branchesList.put("ECE", "ECE");
	      branchesList.put("EEE", "EEE");
	      branchesList.put("MECH", "MECH");
	      branchesList.put("CIVIL", "CIVIL");
	      branchesList.put("CHE", "CHE");
	      branchesList.put("MET", "MET");
	      return branchesList;
	   }
	
	 @ModelAttribute("presentYearList")
	 public Map<Integer, String> getPresentYearList() {
	      Map<Integer, String> presentYearList = new HashMap<Integer, String>();
	      presentYearList.put(1, "1st Year");
	      presentYearList.put(2, "2nd Year");
	      presentYearList.put(3, "3rd Year");
	      presentYearList.put(4, "4th Year");
	      presentYearList.put(5, "5th Year");
	      presentYearList.put(6, "Alumini");
	      
	      return presentYearList;
	   }

	 @ModelAttribute("presentSemesterList")
	 public Map<Integer, String> getPresentSemesterList() {
	      Map<Integer, String> presentSemesterList = new HashMap<Integer, String>();
	      presentSemesterList.put(1, "1st Sem");
	      presentSemesterList.put(2, "2nd Sem");
	      presentSemesterList.put(3, "Alumini");
	      return presentSemesterList;
	   }
	 
	 
	 @ModelAttribute("presentSectionList")
	 public Map<String, String> getPresentSectionList() {
	      Map<String, String> presentSectionList = new HashMap<String, String>();
	      presentSectionList.put("A", "A");
	      presentSectionList.put("B", "B");
	      presentSectionList.put("C", "C");
	      presentSectionList.put("D", "D");
	      presentSectionList.put("E", "E");
	      presentSectionList.put("Alumini", "Alumini");
	      
	      return presentSectionList;
	   }
	 
	 @ModelAttribute("joinYearList")
	 public Map<Integer, String> getJoinYearList() {
	      Map<Integer, String> joinYearList = new HashMap<Integer, String>();
	      joinYearList.put(2012, "2012");
	      joinYearList.put(2013, "2013");
	      joinYearList.put(2014, "2014");
	      joinYearList.put(2015, "2015");
	      joinYearList.put(2016, "2016");
	      joinYearList.put(2017, "2017");
	      joinYearList.put(2018, "2018");
	      joinYearList.put(2019, "2019");
	      joinYearList.put(2020, "2020");
	      joinYearList.put(2021, "2021");
	      joinYearList.put(2022, "2022");
	      joinYearList.put(2023, "2023");
	      joinYearList.put(2024, "2024");
	      joinYearList.put(2025, "2025");
	      joinYearList.put(2026, "2026");
	      
	      return joinYearList;
	   }
	 
}