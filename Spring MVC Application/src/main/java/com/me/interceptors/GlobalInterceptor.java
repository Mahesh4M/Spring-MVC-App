package com.me.interceptors;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.me.mvc.HitCounter;

public class GlobalInterceptor extends HandlerInterceptorAdapter 
{
	@Autowired
	private HitCounter hitcounter;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception 
	{
		hitcounter.setHits(hitcounter.getHits()+1);
		System.out.println("we got "+hitcounter.getHits()+ "hits");
		
		return super.preHandle(request, response, handler);
	}
	
}
