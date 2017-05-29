package com.me.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.me.model.entites.Resource;
import com.me.model.services.ResourceService;

public class ResourceConvertor implements Converter<String, Resource> 
{
	@Autowired
	private ResourceService service;
	
	public Resource convert(String resourceId) 
	{
		return service.find(new Long(resourceId));
	}
	
}
