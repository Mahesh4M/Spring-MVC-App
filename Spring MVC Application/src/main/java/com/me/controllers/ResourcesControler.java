package com.me.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.me.model.entites.Resource;

@Controller
@RequestMapping("/resource")
@SessionAttributes("resource")
public class ResourcesControler
{
	//from nav bar
	@RequestMapping(value=("/add"), method=RequestMethod.GET)
	public String add(Model model)
	{
		//we did this below adding model attrubutes in the next methods way which are after this method.
		/*List<String> options = new LinkedList<String>(Arrays.asList(new String[]{"Mareial", "Other", "Staff", "Technical Equipment"}));
		model.addAttribute("typeOptions", options);
		
		List<String> radios = new LinkedList<String>(Arrays.asList(new String[]{"Hours", "Piece", "Tons"}));
		model.addAttribute("radioOptions", radios);
		
		List<String> checks = new LinkedList<String>(Arrays.asList(new String[]{"Lead Time","Special Rate", "Requires Approval"}));
		model.addAttribute("checkOptions", checks);		
			
		model.addAttribute("resource", new Resource());*/
		
		if(1==1)
		{
				throw new RuntimeException();	
		}
		return "resource_add";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String handleError(HttpServletRequest request)
	{
		return "controller_error";
	}
	
	
	@RequestMapping("/request")
	@ResponseBody
	public String request(@ModelAttribute Resource resource )
	{
		//Send out an email for request
		return "Request has been sent to server";
	}
	
	@ModelAttribute("typeOptions")
	public List<String> getTypes()
	{
		return new LinkedList<String>(Arrays.asList(new String[]{"Mareial", "Other", "Staff", "Technical Equipment"}));
	}
	
	@ModelAttribute("radioOptions")
	public List<String> getRadios()
	{
		return new LinkedList<String>(Arrays.asList(new String[]{"Hours", "Piece", "Tons"}));
	}
	
	@ModelAttribute("checkOptions")
	public List<String> getChecks()
	{
		return new LinkedList<String>(Arrays.asList(new String[]{"Lead Time","Special Rate", "Requires Approval"}));
	}
	
	@ModelAttribute("resource")
	public Resource getResource()
	{
		return new Resource();
	}
	
	//from subimitting resource form page
	@RequestMapping("/review")
	public String review(@ModelAttribute("resource") Resource resource)
	{
		return "resource_review";
	}
	
	//from review subbimiting
	@RequestMapping("/save")
	public String save(@ModelAttribute("resource") Resource resource, SessionStatus status)
	{
		System.out.println(resource);
		status.setComplete();
		return "redirect:/resource/add";
	}
}
