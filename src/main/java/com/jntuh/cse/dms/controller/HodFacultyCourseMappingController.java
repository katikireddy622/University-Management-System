package com.jntuh.cse.dms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.jntuh.cse.dms.model.Course;
import com.jntuh.cse.dms.model.Faculty;
import com.jntuh.cse.dms.model.Mapping;
import com.jntuh.cse.dms.service.AdminService;

@Controller
@RequestMapping("/hod/mapping")
public class HodFacultyCourseMappingController {

	
	@Autowired
	AdminService AdminService;
	
//	
//	@GetMapping(value="/")
//	public String mappingIndex() {
//		
//		return "admin/mappingServices";
//	}
//
//	@GetMapping("/add")
//	public String addMappingGet(ModelMap map) {
//		map.addAttribute("mapping",new Mapping());
//		return "admin/addMapping";
//	}
//	
//	
//	@RequestMapping(value="/add",method=RequestMethod.POST)
//	public ModelAndView addMapping(@Valid @ModelAttribute("mapping") Mapping mapping,BindingResult result)
//	{
//		
//		if(result.hasErrors())
//		{
//			ModelAndView mv=new ModelAndView("admin/addMapping");
//			return mv;
//			
//		}
//		AdminService.saveMappingDetails(mapping);
//
//		ModelAndView mv=new ModelAndView("admin/addMapping").addObject("message", "Faculty Mapped To Course");
//		
//		
//		return mv;
//		
//	}
	
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public ModelAndView viewMapping()
	{
		List<Mapping> listOfMappings=AdminService.getMappingsList();
		List<Object[]> listOfObjectsMapping =AdminService.getAllMappingsList();
		ModelAndView mv=new ModelAndView("hod/viewMapping");
		mv.addObject("listOfMappings",listOfMappings);
		mv.addObject("listOfObjectsMapping",listOfObjectsMapping);
		
		return mv;
	}
	
	
	
//	
//	@RequestMapping(value="/delete",method=RequestMethod.GET)
//	public String deleteMapping(@RequestParam("mid") int mid,ModelMap model)
//	{
//		AdminService.deleteMappingDetails(mid);
//		
//		
//		return "redirect:/admin/mapping/view";
//	}
//	
	
	
	
	
	
	@ModelAttribute("facultysList")
	   public Map<String, String> getFacultysList() {
	      Map<String, String> facultysList = new HashMap<String, String>();
	      
	      List<Faculty> list=AdminService.getFacultysList();
	      
	      for(Faculty f:list)
	      {
	    	  facultysList.put(f.getFid(),f.getFname());
	      }
	      
	      return facultysList;
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
	
	
	
	
	@ModelAttribute("presentYearList")
	 public Map<Integer, String> getPresentYearList() {
	      Map<Integer, String> presentYearList = new HashMap<Integer, String>();
	      presentYearList.put(1, "1st Year");
	      presentYearList.put(2, "2nd Year");
	      presentYearList.put(3, "3rd Year");
	      presentYearList.put(4, "4th Year");
	      presentYearList.put(5, "5th Year");
	      
	      return presentYearList;
	   }

	 @ModelAttribute("presentSemesterList")
	 public Map<Integer, String> getPresentSemesterList() {
	      Map<Integer, String> presentSemesterList = new HashMap<Integer, String>();
	      presentSemesterList.put(1, "1st Sem");
	      presentSemesterList.put(2, "2nd Sem");
	      
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
	      
	      return presentSectionList;
	   }
	
	
	 @ModelAttribute("prasentAcademicYearList")
	 public Map<Integer, String> getprasentAcademicYearList() {
	      Map<Integer, String> prasentAcademicYearList = new HashMap<Integer, String>();
	      prasentAcademicYearList.put(2012, "2012");
	      prasentAcademicYearList.put(2013, "2013");
	      prasentAcademicYearList.put(2014, "2014");
	      prasentAcademicYearList.put(2015, "2015");
	      prasentAcademicYearList.put(2016, "2016");
	      prasentAcademicYearList.put(2017, "2017");
	      prasentAcademicYearList.put(2018, "2018");
	      prasentAcademicYearList.put(2019, "2019");
	      prasentAcademicYearList.put(2020, "2020");
	      prasentAcademicYearList.put(2021, "2021");
	      prasentAcademicYearList.put(2022, "2022");
	      prasentAcademicYearList.put(2023, "2023");
	      prasentAcademicYearList.put(2024, "2024");
	      prasentAcademicYearList.put(2025, "2025");
	      prasentAcademicYearList.put(2026, "2026");
	      
	      return prasentAcademicYearList;
	   }
}
