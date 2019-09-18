package com.jntuh.cse.dms.controller;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("loginPage");
		return model;
	}
	
	@RequestMapping(value = { "/403"}, method = RequestMethod.GET)
	public ModelAndView errorPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("403");
		return model;
	}

	
	@RequestMapping(value= {"/dashboard"},method=RequestMethod.GET)
	public ModelAndView dashboardSelection()
	{
	
		 
		if(hasRole("ROLE_ADMIN"))
		{
			
			return new ModelAndView("admin/dashboard");
			
		}
		else if(hasRole("ROLE_HOD"))
		{
			
			return new ModelAndView("hod/dashboard");
			
		}
		else if(hasRole("ROLE_FACULTY"))
		{
			
			return new ModelAndView("faculty/dashboard");
			
		}
		else
		{
			return new ModelAndView("student/dashboard");
		}
		
	}
	
	
	private boolean hasRole(String role) {
		  @SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
		  SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		  boolean hasRole = false;
		  for (GrantedAuthority authority : authorities) {
		     hasRole = authority.getAuthority().equals(role);
		     if (hasRole) {
			  break;
		     }
		  }
		  return hasRole;
		}
	
	
	
	
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
	@RequestParam(value = "logout",	required = false) String logout) {
		
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
			model.addObject("message", "Logged out Sucessfully.");
		}

		model.setViewName("loginPage");
		return model;
	}

}