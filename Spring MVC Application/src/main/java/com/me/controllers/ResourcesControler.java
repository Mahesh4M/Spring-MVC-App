package com.me.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.me.model.entites.Resource;
import com.me.model.services.ResourceService;

@Controller
@RequestMapping("/resource")
@SessionAttributes("resource")
public class ResourcesControler
{
	@Autowired
	private ResourceService resourceService;
	
	
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
		
	/*	if(1==1)
		{
				throw new RuntimeException();	
		}
	*/	
		return "resource_add";
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
		status.setComplete();
		return "redirect:/resource/add";
	}
	
	@RequestMapping("/find")
	public String findResources(Model model)
	{
		model.addAttribute("resources", this.resourceService.findAll());
		
		return "resources";
	}
	
	@RequestMapping(value={"/{resourceId}"}, produces=MediaType.APPLICATION_ATOM_XML_VALUE)
	public @ResponseBody Resource findResource(@PathVariable("resourceId") Resource resource, Model model )
	{
		return resource;
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST, produces=MediaType.IMAGE_GIF_VALUE)
	public @ResponseBody byte[] uploadFile(@RequestParam("file") MultipartFile file) throws IOException
	{
	
		byte[] b = file.getBytes();
		 return 	      b;      
		
		/*if(!file.isEmpty())
		{
			//return "file size is "+file.getSize();
	
		}
		else
		{
			//return "There was a problem";
		}
	*/	
	}
}
