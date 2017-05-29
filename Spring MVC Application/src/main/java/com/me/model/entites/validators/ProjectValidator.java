package com.me.model.entites.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.me.model.entites.Project;

public class ProjectValidator implements Validator
{

	public boolean supports(Class<?> clazz) 
	{
		// defining what class this validator support
		//return Project.class.equals(clazz);
		
		//below is for all the global validatior classes will apply this validator unlike above line which is for only Project class
		return true;
		
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
