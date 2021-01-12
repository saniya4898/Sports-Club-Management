package com.xoriant.dao;

import java.util.List;

import javax.persistence.TypedQuery;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.xoriant.beans.Admin;
import com.xoriant.beans.Clerk;
import com.xoriant.beans.Game;
import com.xoriant.beans.Plan;
import com.xoriant.util.HibernateConnect;

public class AdminDaoImpl implements AdminDao{
	@Autowired
	private HibernateConnect hibernateConnect;
	public HibernateConnect getHibernateConnect() {
		return hibernateConnect;
	}
	public void setHibernateConnect(HibernateConnect hibernateConnect) {
		this.hibernateConnect = hibernateConnect;
	}

	@Override
	public int createClerkAccount(Clerk clerk) {
		Session session=this.hibernateConnect.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		int cid=-1;
		cid=(int)session.save(clerk);
		transaction.commit();
		session.close();
		return cid;
	}


	@Override
	public boolean deleteClerkAccount(Integer clerkId) {
		Session session=this.hibernateConnect.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		String hql = "FROM Clerk A WHERE A.clerkId = :clerkId";
		Query<Clerk> query = session.createQuery(hql);
		query.setParameter("clerkId", clerkId);
		List<Clerk> clerks = query.getResultList();		
		if(clerks.size()<0)
			return false;
		session.delete(clerks.get(0));
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	public int addGame(Game game) {
		Session session=this.hibernateConnect.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		int gid=-1;
		gid=(int)session.save(game);
		transaction.commit();
		session.close();
		return gid;
	}

	@Override
	public boolean deleteGame(Integer gameId) {
		Session session=this.hibernateConnect.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		String hql = "FROM Game A WHERE A.gameId = :gameId";
		Query<Game> query = session.createQuery(hql);
		query.setParameter("gameId",gameId);
		List<Game> games = query.getResultList();		
		if(games.size()<0)
			return false;
		session.delete(games.get(0));
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	public int addMembershipPlan(Plan plan) {
		Session session=this.hibernateConnect.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		int pid=-1;
		pid=(int)session.save(plan);
		transaction.commit();
		session.close();
		return pid;
	}

	@Override
	public void updateMembershipPlan(Plan plan) {
		Session session=this.hibernateConnect.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		session.update(plan);
		transaction.commit();
		session.close();
	}

	@Override
	public boolean deleteMembershipPlan(Integer planId) {
		Session session=this.hibernateConnect.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		String hql = "FROM Plan A WHERE A.planId = :planId";
		Query<Plan> query = session.createQuery(hql);
		query.setParameter("planId",planId);
		List<Plan> plans = query.getResultList();		
		if(plans.size()<0)
			return false;
		session.delete(plans.get(0));
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	public Admin login(String username, String password) {
		Admin admin=null;
		Session session=this.hibernateConnect.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		String hql = "FROM Admin A WHERE A.adminName = :username AND adminPassword=:password";

		Query<Admin> query = session.createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("password", password);
		List<Admin> admins = query.getResultList();		
		transaction.commit();
		session.close();
		if(admins.size()>0) {
			admin=admins.get(0);
		}
		return admin;
	}
	@Override
	public List<Clerk> getAllClerks() {
		return this.hibernateConnect.getSessionFactory().openSession().createQuery("FROM Clerk").getResultList();
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
	public Plan getPlanById(int planId) {
		Session session=this.hibernateConnect.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		String hql = "FROM Plan A WHERE A.planId = :planId";
		Query<Plan> query = session.createQuery(hql);
		query.setParameter("planId",planId);
		List<Plan> plans = query.getResultList();
		System.out.println(plans);
		return plans.get(0);
	}

}
