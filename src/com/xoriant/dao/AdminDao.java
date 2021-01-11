package com.xoriant.dao;

import com.xoriant.beans.Admin;
import com.xoriant.beans.Clerk;
import com.xoriant.beans.Game;
import com.xoriant.beans.Plan;

public interface AdminDao {
	public Admin login(String username , String Password);
	public int createClerkAccount(Clerk clerk);
	public boolean deleteClerkAccount(Integer clerkId);
	public int addGame(Game game);
	public boolean deleteGame(Integer gameId);
	public int addMembershipPlan(Plan plan);
	public void updateMembershipPlan(Plan plan);
	public boolean deleteMembershipPlan(Integer planId);
	
}
