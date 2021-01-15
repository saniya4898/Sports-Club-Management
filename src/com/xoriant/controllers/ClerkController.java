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
		Clerk clerk;
		HttpSession session=SessionUtility.openSession();
		clerk=(Clerk)session.getAttribute("clerk");
		if(clerk!=null)
			session.removeAttribute("clerk");

		return new ModelAndView("index");
		
	}
	@RequestMapping("/createMemberForm")
	public ModelAndView createMemberForm() {
		ModelAndView modelAndView;
		modelAndView= new ModelAndView("createMemberForm");
		modelAndView.addObject("plans", this.clerkDao.getAllPlans());
		modelAndView.addObject("games", this.clerkDao.getAllGames());
		return modelAndView;
	}

	@RequestMapping("/createMember")
	public ModelAndView createMember(@RequestParam("memberName") String memberName,@RequestParam("dateOfMembership") String dateOfMembership,@RequestParam("endOfMembership") String expiryOfMembership,@RequestParam("plans") String plans,@RequestParam("games") String[] games) {
		ModelAndView modelAndView;
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
			System.out.println("Member created");
		else
			System.out.println("Member not created");
		modelAndView= new ModelAndView("ClerkHome");
		return modelAndView;

	}

	@RequestMapping("/viewMembers")
	public ModelAndView getAllMembers() {
		ModelAndView modelAndView=null;
		List<Member> members=this.clerkDao.getAllMembers();
		if(members.size()>0) {
			modelAndView=new ModelAndView("viewMembers");
			modelAndView.addObject("members",members);
			modelAndView.addObject("plans", this.clerkDao.getAllPlans());
			modelAndView.addObject("games", this.clerkDao.getAllGames());
		}else {
			System.out.println("No member is available to display");
			modelAndView=new ModelAndView("clerkHome");
		}
		return modelAndView;
	}
	@RequestMapping("/deleteMember")
	public ModelAndView deleteMember(@RequestParam("memberId")int id) {
		boolean res=this.clerkDao.deleteMember(id);
		ModelAndView modelAndView=null;
		List<Member> members=this.clerkDao.getAllMembers();
		if(members.size()>0) {
			modelAndView=new ModelAndView("viewMembers");
			modelAndView.addObject("members",members);
		}else {
			System.out.println("No member is available to display");
			modelAndView=new ModelAndView("ClerkHome");
		}
		return modelAndView;
	}

	@RequestMapping("/editMemberForm")
	public ModelAndView editMemberForm(@RequestParam("memberId") int memberId) {
		ModelAndView modelAndView=null;
		Member member=this.clerkDao.getMemberById(memberId);
		System.out.println(member);
		modelAndView=new ModelAndView("editMemberForm");
		modelAndView.addObject("member", member);
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
		return modelAndView;
	}
	@RequestMapping("/editMember")
	public ModelAndView editMember(@RequestParam("memberId") Integer memberId,@RequestParam("memberName") String memberName,@RequestParam("dateOfMembership") String dateOfMembership,@RequestParam("endOfMembership") String expiryOfMembership,@RequestParam("plans") String plans,@RequestParam("games") String[] games) {
		ModelAndView modelAndView;
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
		}else {
			System.out.println("No member is available to display");
			modelAndView=new ModelAndView("clerkHome");
		}
		return modelAndView;

	}
}
