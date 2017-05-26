package com.me.model.services;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.me.model.entites.Project;

public class ProjectService 
{
		private List<Project> projects = new LinkedList<Project>();
		
		public ProjectService()
		{
			Project javaProject = this.createProject("Java Project", "This is a Java Project", 1l );
			Project javascriptProject = this.createProject("Javascript Project", "This is a Javascript Project", 2l);
			Project htmlProject = this.createProject("HTML Project", "This is an HTML project", 3l);
			
			this.projects.addAll(Arrays.asList(new Project[]{javaProject, javascriptProject, htmlProject}));
		}
		
	public List<Project> findAll()
	{
		return this.projects;
	}
	
	public Project find(final Long projectId)
	{
		return (Project) this.projects.stream().filter(new Predicate<Project>() {
			public boolean test(Project p) {
				return p.getProjectId().equals(projectId);
			}
		}).collect(Collectors.toList()).get(0);
	}

	private Project createProject(String title, String description, Long projectId) {
		Project project = new Project();
		project.setName(title);
		project.setAuthorizedFunds(new BigDecimal("100000"));
		project.setAuthorizedHours(new BigDecimal("1000"));
		project.setProjectId(projectId);
		project.setSpecial(false);
		project.setType("multi");
		project.setYear("2015");
		project.setDescription(description);
		return project;
	}
}
