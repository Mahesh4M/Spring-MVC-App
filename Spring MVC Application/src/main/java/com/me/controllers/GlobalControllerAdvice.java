package com.me.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.me.model.entites.validators.ProjectValidator;

@ControllerAdvice(annotations=Controller.class)
public class GlobalControllerAdvice 
{
	@ExceptionHandler(NullPointerException.class)
	public String handleError(HttpServletRequest request)
	{
		return "controller_error";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.addValidators(new ProjectValidator());
	}
	
	@ModelAttribute("currentDate")
	public Date date()
	{
		return new Date();
	}
}
