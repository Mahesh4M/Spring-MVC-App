package com.me.model.services;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.me.model.entites.Resource;

public class ResourceService 
{
	private List<Resource> resources = new LinkedList<Resource>();
	
	public ResourceService()
	{
		this.resources.add(new Resource(1l, "Coder", "Staff", new BigDecimal("100.00"), "Hours"));
		this.resources.add(new Resource(1l, "Analyst", "Staff", new BigDecimal("50.00"), "Hours"));
		this.resources.add(new Resource(1l, "Tester", "Staff", new BigDecimal("70.00"), "Hours"));
		
	}
	
	public List<Resource> findAll()
	{
		return this.resources;
	}
	
	public Resource find(final Long resourceId)
	{
		return (Resource) this.resources.stream().filter(new Predicate<Resource>() {
			public boolean test(Resource rs) {
				return rs.getResourceId().equals(resourceId);
			}
		}).collect(Collectors.toList()).get(0);
	}
	
	public void save(Resource resource)
	{
		this.resources.add(resource);
	}	
}
