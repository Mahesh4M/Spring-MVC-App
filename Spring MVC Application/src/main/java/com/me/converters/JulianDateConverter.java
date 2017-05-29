package com.me.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class JulianDateConverter implements Converter<String, Date> 
{

	public Date convert(String strDate) 
	{
		Date tempDate = null;
		
		try 
		{
			tempDate = new SimpleDateFormat("DD/MM/YY").parse(strDate);
	
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempDate;
	}
	
}
