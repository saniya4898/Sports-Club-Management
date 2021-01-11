package com.xoriant.dao;

import java.util.List;

import com.xoriant.beans.Clerk;
import com.xoriant.beans.Game;
import com.xoriant.beans.Member;
import com.xoriant.beans.Plan;

public class ClerkDaoImpl implements ClerkDao {

	@Override
	public int createMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateMember(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteMember(Integer memberId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateClerk(Clerk clerk) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Member> viewPlanWiseMembers(Plan plan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> viewGameWiseMembers(Game game) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void renewMembership(Integer memberId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Clerk login(String username, String Password) {
		// TODO Auto-generated method stub
		return null;
	}

}
