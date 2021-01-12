package com.xoriant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xoriant.beans.Clerk;
import com.xoriant.beans.Game;
import com.xoriant.beans.Plan;
import com.xoriant.dao.AdminDao;
import com.xoriant.util.HibernateConnect;

@Controller
@RequestMapping("/admin")

public class AdminController {
	@Autowired
	private AdminDao adminDao;
	@RequestMapping("/createClerkForm")
	public ModelAndView getClerkForm() {
		return new ModelAndView("createClerkForm");
		
	}
	@RequestMapping("/createClerk")
	public ModelAndView createClerk(@RequestParam("userName") String userName,@RequestParam("password")String password) {
		ModelAndView modelAndView=null;
		Clerk clerk=new Clerk(userName,password);
		int cid=-1;
		cid=this.adminDao.createClerkAccount(clerk);
		if(cid>0) {
			System.out.println("Clerk Created");
			modelAndView=new ModelAndView("adminHome");

		}else {
			System.out.println("Clerk not created");
			modelAndView=new ModelAndView("createClerkForm");
		}
		return modelAndView;
	}
	@RequestMapping("/viewClerks")
	public ModelAndView getAllClerks() {
		ModelAndView modelAndView=null;
		List<Clerk> clerks=this.adminDao.getAllClerks();
		if(clerks.size()>0) {
			modelAndView=new ModelAndView("viewClerks");
			modelAndView.addObject("clerks",clerks);
		}else {
			System.out.println("No clerk is available to display");
			modelAndView=new ModelAndView("adminHome");
		}
		return modelAndView;
	}
	@RequestMapping("/deleteClerk")
	public ModelAndView deleteClerk(@RequestParam("clerkId")int id) {
		boolean res=this.adminDao.deleteClerkAccount(id);
		ModelAndView modelAndView=null;
		List<Clerk> clerks=this.adminDao.getAllClerks();
		if(clerks.size()>0) {
			modelAndView=new ModelAndView("viewClerks");
			modelAndView.addObject("clerks",clerks);
		}else {
			System.out.println("No clerk is available to display");
			modelAndView=new ModelAndView("adminHome");
		}
		return modelAndView;
	
	}
	@RequestMapping("/createGameForm")
	public ModelAndView getGameForm() {
		return new ModelAndView("createGameForm");
		
	}
	@RequestMapping("/createGame")
	public ModelAndView createGame(@RequestParam("gameName") String gameName) {
		ModelAndView modelAndView=null;
		Game game = new Game(gameName);
		int gid=-1;
		gid=this.adminDao.addGame(game);
		if(gid>0) {
			System.out.println("Game Added");
			modelAndView=new ModelAndView("adminHome");

		}else {
			System.out.println("Game not Added");
			modelAndView=new ModelAndView("createGameForm");
		}
		return modelAndView;
	}
	
	@RequestMapping("/viewGames")
	public ModelAndView getAllGames() {
		ModelAndView modelAndView=null;
		List<Game> games=this.adminDao.getAllGames();
		if(games.size()>0) {
			modelAndView=new ModelAndView("viewGames");
			modelAndView.addObject("games",games);
		}else {
			System.out.println("No game is available to display");
			modelAndView=new ModelAndView("adminHome");
		}
		return modelAndView;
	}
	@RequestMapping("/deleteGame")
	public ModelAndView deleteGame(@RequestParam("gameId")int id) {
		boolean res=this.adminDao.deleteGame(id);
		ModelAndView modelAndView=null;
		List<Game> games=this.adminDao.getAllGames();
		if(games.size()>0) {
			modelAndView=new ModelAndView("viewGames");
			modelAndView.addObject("games",games);
		}else {
			System.out.println("No game is available to display");
			modelAndView=new ModelAndView("adminHome");
		}
		return modelAndView;
	
	}
	@RequestMapping("/createPlanForm")
	public ModelAndView getPlanForm() {
		return new ModelAndView("createPlanForm");
		
	}
	@RequestMapping("/createPlan")
	public ModelAndView createPlan(@RequestParam("planName") String planName,@RequestParam("noOfDays")int noOfDays,@RequestParam("price")double price) {
		ModelAndView modelAndView=null;
		Plan plan=new Plan(noOfDays, planName, price);
		int pid=-1;
		pid=this.adminDao.addMembershipPlan(plan);
		if(pid>0) {
			System.out.println("Plan Added");
			modelAndView=new ModelAndView("adminHome");

		}else {
			System.out.println("Plan not Added");
			modelAndView=new ModelAndView("createPlanForm");
		}
		return modelAndView;
	}
	@RequestMapping("/viewPlans")
	public ModelAndView getAllPlans() {
		ModelAndView modelAndView=null;
		List<Plan> plans=this.adminDao.getAllPlans();
		if(plans.size()>0) {
			modelAndView=new ModelAndView("viewPlans");
			modelAndView.addObject("plans",plans);
		}else {
			System.out.println("No plan is available to display");
			modelAndView=new ModelAndView("adminHome");
		}
		return modelAndView;
	}

	@RequestMapping("/editPlanForm")
	public ModelAndView editPlanForm(@RequestParam("planId") int planId) {
		ModelAndView modelAndView=null;
		Plan plan=this.adminDao.getPlanById(planId);
		System.out.println(plan);
		modelAndView=new ModelAndView("editPlanForm");
		modelAndView.addObject("plan", plan);
		return modelAndView;
	}
	@RequestMapping("/editPlan")
	public ModelAndView editPlan(@RequestParam("planId") int planId,@RequestParam("planName") String planName,@RequestParam("noOfDays") int noOfDays,@RequestParam("planPrice") double planPrice) {
		ModelAndView modelAndView=null;
		Plan plan = new Plan(noOfDays,planName,planPrice);
		plan.setPlanId(planId);
		System.out.println(plan);
		this.adminDao.updateMembershipPlan(plan);
		List<Plan> plans=this.adminDao.getAllPlans();
		if(plans.size()>0) {
			modelAndView=new ModelAndView("viewPlans");
			modelAndView.addObject("plans",plans);
		}else {
			System.out.println("No plan is available to display");
			modelAndView=new ModelAndView("adminHome");
		}
		return modelAndView;
	}
	@RequestMapping("/deletePlan")
	public ModelAndView deletePlan(@RequestParam("planId")int id) {
		boolean res=this.adminDao.deleteMembershipPlan(id);
		ModelAndView modelAndView=null;
		List<Plan> plans=this.adminDao.getAllPlans();
		if(plans.size()>0) {
			modelAndView=new ModelAndView("viewPlans");
			modelAndView.addObject("plans",plans);
		}else {
			System.out.println("No plan is available to display");
			modelAndView=new ModelAndView("adminHome");
		}
		return modelAndView;
	
	}
}
