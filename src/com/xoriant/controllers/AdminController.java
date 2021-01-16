package com.xoriant.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xoriant.beans.Admin;
import com.xoriant.beans.Clerk;
import com.xoriant.beans.Game;
import com.xoriant.beans.Plan;
import com.xoriant.dao.AdminDao;
import com.xoriant.util.HibernateConnect;
import com.xoriant.util.SessionUtility;

@Controller
@RequestMapping("/admin")

public class AdminController {
	@Autowired
	private AdminDao adminDao;
	@RequestMapping("/logoutAdmin")
	public ModelAndView logoutAdmin() {
		boolean res=SessionUtility.isAdminLoggedIn();
		if(res) {
			Admin admin;
			HttpSession session=SessionUtility.openSession();
			admin=(Admin)session.getAttribute("admin");
			session.removeAttribute("admin");
			SessionUtility.invalidateSession();
		}
		return new ModelAndView("index");

	}
	@RequestMapping("/createClerkForm")
	public ModelAndView getClerkForm() {
		ModelAndView modelAndView = null;
		boolean res1=SessionUtility.isAdminLoggedIn();
		if (res1) {
			modelAndView = new ModelAndView("createClerkForm");
			modelAndView.addObject("msg","");
		}
		else {
			modelAndView = new ModelAndView("index");
		}
		return modelAndView;

	}
	@RequestMapping("/createClerk")
	public ModelAndView createClerk(@RequestParam("userName") String userName,@RequestParam("password")String password) {
		boolean res=SessionUtility.isAdminLoggedIn();
		ModelAndView modelAndView=null;

		if(res) {
			Clerk clerk=new Clerk(userName,password);
			int cid=-1;
			cid=this.adminDao.createClerkAccount(clerk);
			if(cid>0) {
				//				System.out.println("Clerk Created");
				//				modelAndView=new ModelAndView("viewClerks");
				//				modelAndView.addObject("clerks",adminDao.getAllClerks());
				modelAndView = new ModelAndView("createClerkForm");
				modelAndView.addObject("msg","Clerk Created Successfully");

			}else {
				System.out.println("Clerk not created");
				modelAndView = new ModelAndView("createClerkForm");
				modelAndView.addObject("msg","Clerk NOT Created ");
			}

		}else {
			modelAndView=new ModelAndView("index");
		}
		return modelAndView;
	}
	@RequestMapping("/viewClerks")
	public ModelAndView getAllClerks() {
		boolean res=SessionUtility.isAdminLoggedIn();
		ModelAndView modelAndView=null;

		if(res) {
			List<Clerk> clerks=this.adminDao.getAllClerks();
			if(clerks.size()>0) {
				modelAndView=new ModelAndView("viewClerks");
				modelAndView.addObject("clerks",clerks);
			}else {
				System.out.println("No clerk is available to display");
				modelAndView=new ModelAndView("adminHome");
			}

		}else {
			modelAndView=new ModelAndView("index");
		}
		return modelAndView;
	}
	@RequestMapping("/deleteClerk")
	public ModelAndView deleteClerk(@RequestParam("clerkId")int id) {
		ModelAndView modelAndView=null;
		boolean res1=SessionUtility.isAdminLoggedIn();
		if(res1) {
			boolean res=this.adminDao.deleteClerkAccount(id);

			List<Clerk> clerks=this.adminDao.getAllClerks();
			if(clerks.size()>0) {
				modelAndView=new ModelAndView("viewClerks");
				modelAndView.addObject("clerks",clerks);
			}else {
				System.out.println("No clerk is available to display");
				modelAndView=new ModelAndView("adminHome");
			}

		}else {
			modelAndView=new ModelAndView("index");
		}
		return modelAndView;

	}
	@RequestMapping("/createGameForm")
	public ModelAndView getGameForm() {
		boolean res1=SessionUtility.isAdminLoggedIn();
		ModelAndView modelAndView =null;
		if (res1) {
			modelAndView = new ModelAndView("createGameForm");
			modelAndView.addObject("msg","");
		}
		else {
			modelAndView = new ModelAndView("index");
		}
		return modelAndView;
	}
	@RequestMapping("/createGame")
	public ModelAndView createGame(@RequestParam("gameName") String gameName) {
		boolean res1=SessionUtility.isAdminLoggedIn();
		ModelAndView modelAndView=null;
		if(res1) {
			Game game = new Game(gameName);
			int gid=-1;
			gid=this.adminDao.addGame(game);
			if(gid>0) {
				modelAndView = new ModelAndView("createGameForm");
				modelAndView.addObject("msg","Game Added Successfully");

			}else {
				modelAndView = new ModelAndView("createGameForm");
				modelAndView.addObject("msg","Game NOT Added");
			}

		}else {
			modelAndView=new ModelAndView("index");			
		}
		return modelAndView;
	}

	@RequestMapping("/viewGames")
	public ModelAndView getAllGames() {
		boolean res1=SessionUtility.isAdminLoggedIn();
		ModelAndView modelAndView=null;
		if(res1) {
			List<Game> games=this.adminDao.getAllGames();
			if(games.size()>0) {
				modelAndView=new ModelAndView("viewGames");
				modelAndView.addObject("games",games);
			}else {
				System.out.println("No game is available to display");
				modelAndView=new ModelAndView("adminHome");
			}			
		}else {
			modelAndView=new ModelAndView("index");
		}
		return modelAndView;
	}
	@RequestMapping("/deleteGame")
	public ModelAndView deleteGame(@RequestParam("gameId")int id) {
		boolean res1=SessionUtility.isAdminLoggedIn();
		ModelAndView modelAndView=null;

		if(res1) {
			boolean res=this.adminDao.deleteGame(id);
			List<Game> games=this.adminDao.getAllGames();
			if(games.size()>0) {
				modelAndView=new ModelAndView("viewGames");
				modelAndView.addObject("games",games);
			}else {
				System.out.println("No game is available to display");
				modelAndView=new ModelAndView("adminHome");
			}

		}else {
			modelAndView=new ModelAndView("index");
		}
		return modelAndView;

	}
	@RequestMapping("/createPlanForm")
	public ModelAndView getPlanForm() {
		boolean res1=SessionUtility.isAdminLoggedIn();
		ModelAndView modelAndView = null;
		if (res1) {
			modelAndView = new ModelAndView("createPlanForm");
			modelAndView.addObject("msg","");
		}
		else {
			modelAndView = new ModelAndView("index");
		}
		return modelAndView;


	}
	@RequestMapping("/createPlan")
	public ModelAndView createPlan(@RequestParam("planName") String planName,@RequestParam("noOfDays")int noOfDays,@RequestParam("price")double price) {
		ModelAndView modelAndView=null;
		boolean res1=SessionUtility.isAdminLoggedIn();
		if(res1) {
			Plan plan=new Plan(noOfDays, planName, price);
			int pid=-1;
			pid=this.adminDao.addMembershipPlan(plan);
			if(pid>0) {
				modelAndView = new ModelAndView("createPlanForm");
				modelAndView.addObject("msg","Plan Added Successfully");

			}else {
				modelAndView = new ModelAndView("createPlanForm");
				modelAndView.addObject("msg","Plan NOT Added");
			}

		}else {
			modelAndView=new ModelAndView("index");
		}
		return modelAndView;
	}
	@RequestMapping("/viewPlans")
	public ModelAndView getAllPlans() {
		boolean res1=SessionUtility.isAdminLoggedIn();
		ModelAndView modelAndView=null;
		if(res1) {
			List<Plan> plans=this.adminDao.getAllPlans();
			if(plans.size()>0) {
				modelAndView=new ModelAndView("viewPlans");
				modelAndView.addObject("plans",plans);
			}else {
				System.out.println("No plan is available to display");
				modelAndView=new ModelAndView("adminHome");
			}
		}else {
			modelAndView=new ModelAndView("index");
		}
		return modelAndView;
	}

	@RequestMapping("/editPlanForm")
	public ModelAndView editPlanForm(@RequestParam("planId") int planId) {
		boolean res1=SessionUtility.isAdminLoggedIn();
		ModelAndView modelAndView=null;
		if(res1) {
			Plan plan=this.adminDao.getPlanById(planId);
			System.out.println(plan);
			modelAndView=new ModelAndView("editPlanForm");
			modelAndView.addObject("plan", plan);

		}else {
			modelAndView=new ModelAndView("index");
		}
		return modelAndView;
	}
	@RequestMapping("/editPlan")
	public ModelAndView editPlan(@RequestParam("planId") int planId,@RequestParam("planName") String planName,@RequestParam("noOfDays") int noOfDays,@RequestParam("planPrice") double planPrice) {

		ModelAndView modelAndView=null;
		boolean res1=SessionUtility.isAdminLoggedIn();
		if(res1) {
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

		}else {
			modelAndView=new ModelAndView("index");
		}
		return modelAndView;
	}
	@RequestMapping("/deletePlan")
	public ModelAndView deletePlan(@RequestParam("planId")int id) {
		boolean res1=SessionUtility.isAdminLoggedIn();
		ModelAndView modelAndView=null;
		if(res1) {
			boolean res=this.adminDao.deleteMembershipPlan(id);
			List<Plan> plans=this.adminDao.getAllPlans();
			if(plans.size()>0) {
				modelAndView=new ModelAndView("viewPlans");
				modelAndView.addObject("plans",plans);
			}else {
				System.out.println("No plan is available to display");
				modelAndView=new ModelAndView("adminHome");
			}
		}else {
			modelAndView=new ModelAndView("index");
		}
		return modelAndView;

	}
}
