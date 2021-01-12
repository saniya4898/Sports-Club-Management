package com.xoriant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xoriant.beans.Admin;
import com.xoriant.beans.Clerk;
import com.xoriant.dao.AdminDaoImpl;
import com.xoriant.dao.ClerkDaoImpl;

@Controller
public class MainController {
	@Autowired
	AdminDaoImpl adminDao;
	@Autowired
	ClerkDaoImpl clerkDao;

	@RequestMapping("/")
	public ModelAndView displayHome() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("userCategory") String userCategory,@RequestParam("userName") String userName,@RequestParam("password")String password) {
		System.out.println(userName+" "+password+" "+userCategory);
		if(userCategory.equalsIgnoreCase("admin")) {
			Admin admin=this.adminDao.login(userName, password);
			if(admin==null) {
				System.out.println("Invalid Credentials");
				return new ModelAndView("index");
			}
			System.out.println("Admin login successfull");
			return new ModelAndView("adminHome");
		}else {
			Clerk clerk=this.clerkDao.login(userName, password);
			if(clerk==null) {
				System.out.println("Invalid Credentials");
				return new ModelAndView("index");
			}
			System.out.println("Clerk login successfull");
			return new ModelAndView("ClerkHome");
		}
	//	return null;
	}
}
