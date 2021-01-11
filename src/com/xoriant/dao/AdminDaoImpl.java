package com.xoriant.dao;

import com.xoriant.beans.Admin;
import com.xoriant.beans.Clerk;
import com.xoriant.beans.Game;
import com.xoriant.beans.Plan;

public class AdminDaoImpl implements AdminDao{

	@Override
	public int createClerkAccount(Clerk clerk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteClerkAccount(Integer clerkId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addGame(Game game) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteGame(Integer gameId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addMembershipPlan(Plan plan) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateMembershipPlan(Plan plan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteMembershipPlan(Integer planId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin login(String username, String Password) {
		Admin admin=null;
		
		return admin;
	}

}
