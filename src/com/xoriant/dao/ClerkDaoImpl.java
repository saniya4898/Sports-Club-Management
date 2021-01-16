package com.xoriant.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.xoriant.beans.Admin;
import com.xoriant.beans.Clerk;
import com.xoriant.beans.Game;
import com.xoriant.beans.Member;
import com.xoriant.beans.Plan;
import com.xoriant.util.HibernateConnect;

public class ClerkDaoImpl implements ClerkDao {
	@Autowired
	private HibernateConnect hibernateConnect;

	public HibernateConnect getHibernateConnect() {
		return hibernateConnect;
	}

	public void setHibernateConnect(HibernateConnect hibernateConnect) {
		this.hibernateConnect = hibernateConnect;
	}

	@Override
	public int createMember(Member member) {
		int mid=-1;
		Session session=this.hibernateConnect.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		mid=(int)session.save(member);
		transaction.commit();
		session.close();
		return mid;
	}

	@Override
	public void updateMember(Member member) {
		int mid=-1;
		Session session=this.hibernateConnect.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		session.update(member);
		transaction.commit();
		session.close();
		

	}

	@Override
	public boolean deleteMember(Integer memberId) {
		Session session=this.hibernateConnect.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		String hql = "FROM Member A WHERE A.memberId = :memberId";
		Query<Member> query = session.createQuery(hql);
		query.setParameter("memberId", memberId);
		List<Member> members = query.getResultList();		
		if(members.size()<0)
			return false;
		session.delete(members.get(0));
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	public void updateClerk(Clerk clerk) {
		Session session=this.hibernateConnect.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		session.update(clerk);
		transaction.commit();
		session.close();

	}

	@Override
	public List<Member> viewPlanWiseMembers(Plan plan) {
		return this.getAllMembers().stream().filter(member->member.getPlanSelected().getPlanId()==plan.getPlanId()).collect(Collectors.toList());
	}

	@Override
	public List<Member> viewGameWiseMembers(Game game) {
		List<Member> members=new LinkedList<Member>();
		for(Member mem:this.getAllMembers()) {
			boolean f=false;
			List<Game> games=mem.getGamesSelected();
			for(int i=0;i<games.size();i++) {
				if(game.getGameId()==games.get(i).getGameId()) {
					f=true;
					break;
				}
					
			}
			if(f)
				members.add(mem);
		}
		return members;
	}

	@Override
	public void renewMembership(Integer memberId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Clerk login(String username, String password) {
		Clerk clerk=null;
		Session session=this.hibernateConnect.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		String hql = "FROM Clerk C WHERE C.clerkName = :username AND clerkPassword=:password";

		Query<Clerk> query = session.createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("password", password);
		List<Clerk> clerks = query.getResultList();		
		transaction.commit();
		session.close();
		if(clerks.size()>0) {
			clerk=clerks.get(0);
		}
		return clerk;
	}
	@Override
	public List<Game> getAllGames() {
		return this.hibernateConnect.getSessionFactory().openSession().createQuery("FROM Game").getResultList();
	}
	@Override
	public List<Plan> getAllPlans() {
		return this.hibernateConnect.getSessionFactory().openSession().createQuery("FROM Plan").getResultList();
	}

	@Override
	public List<Member> getAllMembers() {
		return this.hibernateConnect.getSessionFactory().openSession().createQuery("FROM Member").getResultList();
	}

	@Override
	public Member getMemberById(int memberId) {
		Session session=this.hibernateConnect.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		String hql = "FROM Member A WHERE A.memberId = :memberId";
		Query<Member> query = session.createQuery(hql);
		query.setParameter("memberId",memberId);
		List<Member> members = query.getResultList();
		System.out.println(members);
		return members.get(0);
	}

	@Override
	public Clerk getClerkById(int clerkId) {
		Session session=this.hibernateConnect.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		String hql = "FROM Clerk A WHERE A.clerkId = :clerkId";
		Query<Clerk> query = session.createQuery(hql);
		query.setParameter("clerkId",clerkId);
		List<Clerk> clerks = query.getResultList();
		System.out.println(clerks);
		return clerks.get(0);

	}

	@Override
	public Plan getPlanById(int planId) {
		return this.getAllPlans().stream().filter(plan->plan.getPlanId()==planId).collect(Collectors.toList()).get(0);
	}

	@Override
	public Game getGameById(int gameId) {
		return this.getAllGames().stream().filter(game->game.getGameId()==gameId).collect(Collectors.toList()).get(0);
	}

}
