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

import com.jntuh.cse.dms.model.Faculty;
import com.jntuh.cse.dms.service.AdminService;

@Controller
@RequestMapping("/admin/faculty")
public class AdminFacultyController {

	@Autowired
	AdminService AdminService;

	@RequestMapping(value="/")
	public String facultyIndex(){
		
		return "admin/facultyServices";
	}
	
	@GetMapping("/add")
	public String addFacultyGet(ModelMap map) {
		map.addAttribute("faculty",new Faculty());
		return "admin/addFaculty";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class,"fdob", new CustomDateEditor(sdf, false));
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView addfaculty(@Valid @ModelAttribute("faculty") Faculty faculty,BindingResult result)
	{
		
		if(result.hasErrors())
		{
			ModelAndView mv=new ModelAndView("admin/addFaculty");
			return mv;
			
		}
		AdminService.saveFacultyDetails(faculty);

		ModelAndView mv=new ModelAndView("admin/addFaculty").addObject("message", "Faculty Added Succesfully");
		
		
		return mv;
		
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public ModelAndView viewFaculty()
	{
		List<Faculty> listOfFacultys=AdminService.getFacultysList();
		
		ModelAndView mv=new ModelAndView("admin/viewFaculties");
		mv.addObject("listOfFacultys",listOfFacultys);
		
		return mv;
	}

	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updatefaculty(@RequestParam("fid") String fid,ModelMap model)
	{
		Faculty faculty=AdminService.getFacultyDetails(fid);
		model.put("faculty",faculty);
		
		return "admin/addFaculty";
	}
	

	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteFaculty(@RequestParam("fid") String fid,ModelMap model)
	{
		AdminService.deleteFacultyDetails(fid);
		
		
		return "redirect:/admin/faculty/view";
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
	
	 

	 
	 @ModelAttribute("designationList")
	   public Map<String, String> getDesignationList() {
	      Map<String, String> designationList = new HashMap<String, String>();
	      designationList.put("lecturer", "Lecturer");
	      designationList.put("asstprof", "AsstProf");
	      designationList.put("assoprof", "Assoprof");
	      designationList.put("professor", "Professor");
	      designationList.put("hod", "Hod");
	      return designationList;
	   }
	
	
}
