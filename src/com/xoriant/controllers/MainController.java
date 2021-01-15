package com.xoriant.controllers;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.xoriant.beans.Admin;
import com.xoriant.beans.Clerk;
import com.xoriant.dao.AdminDao;
import com.xoriant.dao.ClerkDao;
import com.xoriant.util.SessionUtility;

@Controller
public class MainController {
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private ClerkDao clerkDao;

	@RequestMapping("/")
	public ModelAndView displayHome() {
		ModelAndView modelAndView=null;
		HttpSession session=SessionUtility.openSession();
		Admin admin=null;
		admin=(Admin) session.getAttribute("admin");
		if(admin!=null) {
			modelAndView= new ModelAndView("adminHome");
			modelAndView.addObject("admin", admin);
			return modelAndView;
		}else if(session.getAttribute("clerk")!=null) {
			Clerk clerk=(Clerk)session.getAttribute("clerk");
			modelAndView=new ModelAndView("ClerkHome");
			modelAndView.addObject("clerk", clerk);
			return modelAndView;
		}
		else return new ModelAndView("index");

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
			HttpSession session=SessionUtility.openSession();
			session.setAttribute("admin", admin);
			System.out.println("Admin login successfull");
			modelAndView = new ModelAndView("adminHome");
			modelAndView.addObject("admin",admin);
			return modelAndView;
		}else {
			Clerk clerk=this.clerkDao.login(userName, password);
			if(clerk==null) {
				System.out.println("Invalid Credentials");
				return new ModelAndView("index");
			}
			System.out.println("Clerk login successfull");
			HttpSession session=SessionUtility.openSession();
			session.setAttribute("clerk", clerk);
			
			modelAndView = new ModelAndView("ClerkHome");
			modelAndView.addObject("clerk",clerk);
			return modelAndView;
		}
		//	return null;
	}
}
