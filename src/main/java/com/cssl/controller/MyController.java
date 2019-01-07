package com.cssl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cssl.pojo.Users;
import com.cssl.service.UsersService;
import com.github.pagehelper.Page;

@Controller
public class MyController {
	
	@Autowired
	private UsersService service;
	
	@PostMapping("/regist")
	public String hello(Users user,Model model) {
		System.out.println("hello springboot:"+user.getUsername());
		model.addAttribute("user", user);
		if(service.saveUsers(user))		
			return "success";
		return "redirect:/index.html";
	}
	
	@RequestMapping("/success")
	public Model findPage(int pageno,Model model) {
		Page<Users> page= service.page(pageno);
		System.out.println("total:"+page.getTotal());
		System.out.println("pages:"+page.getPages());
		System.out.println("list:"+page.getResult());
		model.addAttribute("page",page);
		return model;
	}

}
