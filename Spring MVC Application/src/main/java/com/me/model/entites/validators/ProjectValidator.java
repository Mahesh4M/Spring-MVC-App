package com.me.model.entites.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.me.model.entites.Project;

public class ProjectValidator implements Validator
{

	public boolean supports(Class<?> clazz) 
	{
		// defining what class this validator support
		return Project.class.equals(clazz);
	}

	public void validate(Object obj, Errors errors) 
	{
		Project project = (Project) obj;
		
		if(project.getName().length() < 4)
		{
			errors.rejectValue("name", "project.name", "This Name Is Too Short");
		}

	}

}
