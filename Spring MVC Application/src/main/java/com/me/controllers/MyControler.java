package com.me.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.model.entites.Project;
import com.me.model.entites.Sponser;
import com.me.model.entites.validators.ProjectValidator;
import com.me.model.services.ProjectService;

@Controller 
public class MyControler
{
	@Autowired 
	private ProjectService projectService;
	
	@RequestMapping("/project/find")
	public String find(Model model)
	{	
		model.addAttribute("projects", projectService.findAll());
		return "projects"; 
	}
	
	@RequestMapping(value=("/project/{projectId}"))
	public String findProject(@PathVariable("projectId") Long projectId, Model model)
	{
		model.addAttribute("project", projectService.find(projectId) );
		return "project";
	}
	
	@RequestMapping("/home")
	public String homeControl(Model model)
	{	
		Project project = new Project();
		project.setName("First Project");
		project.setSponsor(new Sponser("NASA", "555-555-5555", "nasa@nasa.com"));
		project.setDescription("This is a simple project sponsored by NASA");
		
		model.addAttribute("currentProject", project);
		return "home"; 
	} 
	
	//from index page
	@RequestMapping(value=("/add"), method=RequestMethod.GET)
	public String addPage()
	{
		return "project_add"; 
	}
	
	//requesting page from nav bar
	@RequestMapping(value=("/project/add"), method=RequestMethod.GET)
	public String addProject(Model model)
	{
		Project project = new Project();
		model.addAttribute("project", project);
		
		model.addAttribute("types", new ArrayList<String>(){/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{
			
			add("");
			add("Single Year");
			add("Multi Year");
		}});	
		
		return "project_add"; 
	}
	
	//requestig from form page
	@RequestMapping(value=("/project/add"), method=RequestMethod.POST)
	public String addPostProject(@Valid @ModelAttribute("project") Project project, BindingResult errors)
	{
		if(!errors.hasErrors())
		{
			System.out.println("the project validated");
		}
		else
		{
			System.out.println("not validated");
		}
		System.out.println(project);
		return "project_add"; 
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.addValidators(new ProjectValidator());
	}
}
