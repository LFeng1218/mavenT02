package com.cssl.web;

import java.util.List;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cssl.interceptor.MyInterceptor;

/**
 * 
 * @author 锋
 * 
 *
 */
@Component
public class MyWebConfiger implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/image/**");
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		System.out.println("configureMessageConverters");
	//	WebMvcConfigurer.super.configureMessageConverters(converters);
	}

}
