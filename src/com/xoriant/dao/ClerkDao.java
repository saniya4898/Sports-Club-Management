package com.xoriant.dao;

import java.util.List;

import com.xoriant.beans.Admin;
import com.xoriant.beans.Clerk;
import com.xoriant.beans.Game;
import com.xoriant.beans.Member;
import com.xoriant.beans.Plan;

public interface ClerkDao {
	public Clerk login(String username , String Password);
	public int createMember(Member member);
	public void updateMember(Member member);
	public boolean deleteMember(Integer memberId);
	public void updateClerk(Clerk clerk);
	public List<Member> viewPlanWiseMembers(Plan plan);
	public List<Member> viewGameWiseMembers(Game game);
	public void renewMembership(Integer memberId);
	public List<Game> getAllGames();
	public List<Plan> getAllPlans();
	public List<Member> getAllMembers();
	public Member getMemberById(int memberId);
	
}
