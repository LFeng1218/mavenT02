package com.cssl.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cssl.service.UsersService;

@WebFilter(urlPatterns="/*")
public class MyFilter implements Filter {
	private UsersService service;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext application = filterConfig.getServletContext();
		ApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext(application);
		service=ctx.getBean(UsersService.class);
		System.out.println("init:"+service);
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
		//Filter.super.destroy();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("============doFilter:"+service);
		chain.doFilter(request, response);
		System.out.println("============doFilter:after");
		
	}

}
