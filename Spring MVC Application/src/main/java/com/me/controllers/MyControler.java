package com.me.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.me.model.entites.Project;
import com.me.model.entites.Sponser;
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
	
	@RequestMapping("/find/{projectId}")
	public @ResponseBody Project findProjectObject(Model model, @PathVariable("projectId") Long projectId)
	{
		return this.projectService.find(projectId); 
	}
	
	@RequestMapping(value=("/project/{projectId}"))
	public String findProject(@PathVariable("projectId") Long projectId, Model model)
	{
		model.addAttribute("project", projectService.find(projectId) );
		return "project";
	}
	
	@RequestMapping(value={"/", "/index"})
	public String homeControl(Model model)
	{	
		Project project = new Project();
		project.setName("First Project");
		project.setSponsor(new Sponser("NASA", "555-555-5555", "nasa@nasa.com"));
		project.setDescription("This is a simple project sponsored by NASA");
		
		model.addAttribute("currentProject", project);
		return "welcome"; 
	}
	
	
	//redirected from added form project
	
	@RequestMapping(value="/home")
	public String homeAgain(Model model, @ModelAttribute("project") Project project)
	{
		model.addAttribute("currentProject", project);
		return "home";
	}
	
/*	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}
*/	
	
	
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
	public String addPostProject(@Valid @ModelAttribute("project") Project project, BindingResult errors, RedirectAttributes attributes)
	{
		//perform validations here and redirecr view based on the validation
		
		project.setProjectId(55L);
		this.projectService.save(project);
		attributes.addFlashAttribute("project", project);
		System.out.println(project);
		return "redirect:/home"; 
	}
	/*
	//we did this using converters
	@InitBinder
	public void initBinder ( WebDataBinder binder)
	{
		try {
			SimpleDateFormat sd = new SimpleDateFormat("DD/MM/YY");
			
			CustomDateEditor e = new CustomDateEditor(sd, true);
			binder.registerCustomEditor(Date.class, e);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
}
