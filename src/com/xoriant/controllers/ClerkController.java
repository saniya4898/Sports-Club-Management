package com.xoriant.controllers;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xoriant.dao.ClerkDao;
import com.xoriant.util.SessionUtility;
import com.xoriant.beans.*;

@Controller
@RequestMapping("/clerk")
public class ClerkController {
	@Autowired
	private ClerkDao clerkDao;

	@RequestMapping("/logoutClerk")
	public ModelAndView logoutClerk() {
		boolean res=SessionUtility.isClerkLoggedIn();
		if(res) {
			Clerk clerk;
			HttpSession session=SessionUtility.openSession();
			clerk=(Clerk)session.getAttribute("clerk");
			session.removeAttribute("clerk");
			SessionUtility.invalidateSession();
		}
		return new ModelAndView("index");

	}
	@RequestMapping("/createMemberForm")
	public ModelAndView createMemberForm() {
		ModelAndView modelAndView;
		boolean res=SessionUtility.isClerkLoggedIn();
		if(res) {
			modelAndView= new ModelAndView("createMemberForm");
			modelAndView.addObject("plans", this.clerkDao.getAllPlans());
			modelAndView.addObject("games", this.clerkDao.getAllGames());
			modelAndView.addObject("msg", "");
		}
		else {
			modelAndView= new ModelAndView("index");
		}
		return modelAndView;
	}

	@RequestMapping("/createMember")
	public ModelAndView createMember(@RequestParam("memberName") String memberName,@RequestParam("dateOfMembership") String dateOfMembership,@RequestParam("endOfMembership") String expiryOfMembership,@RequestParam("plans") String plans,@RequestParam("games") String[] games) {
		ModelAndView modelAndView = null;
		boolean res=SessionUtility.isClerkLoggedIn();
		if(res) {
			List<Game> gamesSelected=new LinkedList<>();
			List<Game> allGames=this.clerkDao.getAllGames();

			for(String id:games) {
				int gid=Integer.parseInt(id);
				for(Game game:allGames) {
					if(game.getGameId()==gid) {
						gamesSelected.add(game);
					}
				}
			}
			System.out.println(dateOfMembership+memberName+plans+expiryOfMembership+games.length);
			Member member=new Member();
			member.setMemberName(memberName);
			member.setGamesSelected(gamesSelected);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			String dateString = format.format( new Date()   );
			Date   dOfMembership = null,eOfMembership = null;

			try {
				dOfMembership= format.parse( dateOfMembership ); 
				eOfMembership=format.parse(expiryOfMembership);
			}catch (Exception e) {
				// TODO: handle exception
			}
			member.setDateOfMembership(dOfMembership);
			member.setExpiryOfMembership(eOfMembership);
			int planId=Integer.parseInt(plans.split("-")[0]);
			Plan 		planSelected=this.clerkDao.getAllPlans().stream().filter(plan->plan.getPlanId()==planId).collect(Collectors.toList()).get(0);
			member.setPlanSelected(planSelected);
			int mid=-1;
			mid=this.clerkDao.createMember(member);
			if(mid>0)
			{
				modelAndView= new ModelAndView("createMemberForm");
				modelAndView.addObject("plans", this.clerkDao.getAllPlans());
				modelAndView.addObject("games", this.clerkDao.getAllGames());
				modelAndView.addObject("msg", "Member Created Successfully");
			}

			else
			{
				modelAndView= new ModelAndView("createMemberForm");
				modelAndView.addObject("plans", this.clerkDao.getAllPlans());
				modelAndView.addObject("games", this.clerkDao.getAllGames());
				modelAndView.addObject("msg", "Member NOT Created ");
			}

		}
		else {
			modelAndView=new ModelAndView("index");
		}
		return modelAndView;

	}

	@RequestMapping("/viewMembers")
	public ModelAndView getAllMembers() {
		ModelAndView modelAndView=null;
		boolean res=SessionUtility.isClerkLoggedIn();
		if(res) {
			List<Member> members=this.clerkDao.getAllMembers();
			if(members.size()>0) {
				modelAndView=new ModelAndView("viewMembers");
				modelAndView.addObject("members",members);
				modelAndView.addObject("plans", this.clerkDao.getAllPlans());
				modelAndView.addObject("games", this.clerkDao.getAllGames());
			}else {
				System.out.println("No member is available to display");
				modelAndView=new ModelAndView("ClerkHome");
			}
		}
		else {
			modelAndView=new ModelAndView("index");

		}
		return modelAndView;
	}
	@RequestMapping("/deleteMember")
	public ModelAndView deleteMember(@RequestParam("memberId")int id) {
		ModelAndView modelAndView=null;
		boolean res1=SessionUtility.isClerkLoggedIn();
		if(res1) {
			boolean res=this.clerkDao.deleteMember(id);

			List<Member> members=this.clerkDao.getAllMembers();
			if(members.size()>0) {
				modelAndView=new ModelAndView("viewMembers");
				modelAndView.addObject("members",members);
			}else {
				System.out.println("No member is available to display");
				modelAndView=new ModelAndView("ClerkHome");
			}
		}
		else {
			modelAndView=new ModelAndView("index");
		}
		return modelAndView;
	}

	@RequestMapping("/editMemberForm")
	public ModelAndView editMemberForm(@RequestParam("memberId") int memberId) {
		ModelAndView modelAndView=null;
		boolean res1=SessionUtility.isClerkLoggedIn();
		if(res1) {
			Member member=this.clerkDao.getMemberById(memberId);
			System.out.println(member);
			modelAndView=new ModelAndView("editMemberForm");
			modelAndView.addObject("member", member);
			modelAndView.addObject("msg", "");
			List<Game> allGames=this.clerkDao.getAllGames();
			List<Game> membersCheckedGames=member.getGamesSelected();
			System.out.println(allGames);
			for(int i=0;i<membersCheckedGames.size();i++) {
				for(int j=0;j<allGames.size();j++) {
					if(allGames.get(j).getGameName().equals(membersCheckedGames.get(i).getGameName())) {
						allGames.remove(j);
					}
				}
			}


			System.out.println(allGames);
			modelAndView.addObject("allGames",allGames);
			modelAndView.addObject("plans",clerkDao.getAllPlans());
			
		}
		else {
			modelAndView=new ModelAndView("index");
		}
		return modelAndView;
	}
	@RequestMapping("/editMember")
	public ModelAndView editMember(@RequestParam("memberId") Integer memberId,@RequestParam("memberName") String memberName,@RequestParam("dateOfMembership") String dateOfMembership,@RequestParam("endOfMembership") String expiryOfMembership,@RequestParam("plans") String plans,@RequestParam("games") String[] games) {
		ModelAndView modelAndView;
		boolean res1=SessionUtility.isClerkLoggedIn();
		if(res1) {
			List<Game> gamesSelected=new LinkedList<>();
			List<Game> allGames=this.clerkDao.getAllGames();

			for(String id:games) {
				int gid=Integer.parseInt(id);
				for(Game game:allGames) {
					if(game.getGameId()==gid) {
						gamesSelected.add(game);
					}
				}
			}
			System.out.println(dateOfMembership+memberName+plans+expiryOfMembership+games.length);
			Member member=this.clerkDao.getMemberById(memberId);
			member.setMemberName(memberName);
			member.setGamesSelected(gamesSelected);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			String dateString = format.format( new Date()   );
			Date   dOfMembership = null,eOfMembership = null;

			try {
				dOfMembership= format.parse( dateOfMembership ); 
				eOfMembership=format.parse(expiryOfMembership);
			}catch (Exception e) {
				// TODO: handle exception
			}
			member.setDateOfMembership(dOfMembership);
			member.setExpiryOfMembership(eOfMembership);
			int planId=Integer.parseInt(plans.split("-")[0]);
			Plan 		planSelected=this.clerkDao.getAllPlans().stream().filter(plan->plan.getPlanId()==planId).collect(Collectors.toList()).get(0);
			member.setPlanSelected(planSelected);
			this.clerkDao.updateMember(member);
			List<Member> members=this.clerkDao.getAllMembers();
			if(members.size()>0) {
				modelAndView=new ModelAndView("viewMembers");
				modelAndView.addObject("members",members);
				modelAndView.addObject("plans", this.clerkDao.getAllPlans());
				modelAndView.addObject("games", this.clerkDao.getAllGames());
			}else {
				System.out.println("No member is available to display");
				modelAndView=new ModelAndView("ClerkHome");
			}
		}
		else {
			modelAndView=new ModelAndView("index");

		}

		return modelAndView;
	}

	@RequestMapping("/editClerkForm")
	public ModelAndView editPlanForm(@RequestParam("clerkId") int clerkId) {
		boolean res1=SessionUtility.isClerkLoggedIn();
		ModelAndView modelAndView=null;
		if(res1) {
			Clerk clerk = this.clerkDao.getClerkById(clerkId);
			System.out.println(clerk);
			modelAndView=new ModelAndView("editClerkForm");
			modelAndView.addObject("clerk", clerk);

		}else {
			modelAndView=new ModelAndView("index");
		}
		return modelAndView;
	}
	@RequestMapping("/editClerk")
	public ModelAndView editPlan(@RequestParam("clerkId") int clerkId,@RequestParam("clerkName") String clerkName,@RequestParam("clerkPassword") String clerkPassword) {

		ModelAndView modelAndView=null;
		boolean res1=SessionUtility.isClerkLoggedIn();
		if(res1) {
			Clerk clerk = new Clerk(clerkName, clerkPassword);
			clerk.setClerkId(clerkId);
			System.out.println(clerk);
			this.clerkDao.updateClerk(clerk);

			modelAndView = new ModelAndView("editClerkForm");
			modelAndView.addObject(clerk);
			modelAndView.addObject("msg","Clerk Updated Successfully");

		}else {
			modelAndView=new ModelAndView("index");
		}
		return modelAndView;
	}
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam("searchCategory")String searchCategory,@RequestParam("plansType")String plansType,@RequestParam("gameType")String gameType,@RequestParam("expiryDate")String expiryDate) {
		
		ModelAndView modelAndView=null;
		boolean res=SessionUtility.isClerkLoggedIn();
		if(res) {
			modelAndView=new ModelAndView("viewMembers");
			if(plansType.length()>0&&!plansType.equals("-1")) {
				Plan plan=this.clerkDao.getPlanById(Integer.parseInt(plansType));
				List<Member> members=this.clerkDao.viewPlanWiseMembers(plan);
				if(members.size()>0) {
					modelAndView=new ModelAndView("viewMembers");
					modelAndView.addObject("members",members);
				}else {
					System.out.println("No member is available to display");
					modelAndView=new ModelAndView("ClerkHome");
				}
				
			}else if(gameType.length()>0&&!gameType.equals("-1")){
				Game game=this.clerkDao.getGameById(Integer.parseInt(gameType));
				List<Member> members=this.clerkDao.viewGameWiseMembers(game);
				modelAndView.addObject("members",members);
			}
			
		}else {
			modelAndView=new ModelAndView("index");
		}
		System.out.println(searchCategory+" "+plansType+" "+gameType+" "+expiryDate);
		modelAndView.addObject("plans", this.clerkDao.getAllPlans());
		modelAndView.addObject("games", this.clerkDao.getAllGames());
		return modelAndView;
	}
}
