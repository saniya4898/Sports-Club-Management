package com.xoriant.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateConnect {
	private StandardServiceRegistry standardServiceRegistry ;
	private Metadata meta ;
	private SessionFactory factory ;

	public HibernateConnect() {
		this.standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		this.meta = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		this.factory = meta.getSessionFactoryBuilder().build();
	}
	public SessionFactory getSessionFactory() {
		return this.factory;
	}
}
