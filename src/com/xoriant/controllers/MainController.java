package com.xoriant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xoriant.beans.Admin;
import com.xoriant.beans.Clerk;
import com.xoriant.dao.AdminDao;
import com.xoriant.dao.ClerkDao;

@Controller
public class MainController {
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private ClerkDao clerkDao;

	@RequestMapping("/")
	public ModelAndView displayHome() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("userCategory") String userCategory,@RequestParam("userName") String userName,@RequestParam("password")String password) {
		ModelAndView modelAndView = null;
		if(userCategory.equalsIgnoreCase("admin")) {
			Admin admin=this.adminDao.login(userName, password);
			if(admin==null) {
				System.out.println("Invalid Credentials");
				return new ModelAndView("index");
			}
			System.out.println("Admin login successfull");
			modelAndView = new ModelAndView("adminHome");
			modelAndView.addObject("userName",userName);
			return modelAndView;
		}else {
			Clerk clerk=this.clerkDao.login(userName, password);
			if(clerk==null) {
				System.out.println("Invalid Credentials");
				return new ModelAndView("index");
			}
			System.out.println("Clerk login successfull");
			modelAndView = new ModelAndView("ClerkHome");
			modelAndView.addObject("userName",userName);
			return modelAndView;
		}
		//	return null;
	}
}
