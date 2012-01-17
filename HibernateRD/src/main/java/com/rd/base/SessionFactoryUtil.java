package com.rd.base;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class SessionFactoryUtil {
	private final static SessionFactory sessionFactory=buildFactory();
	private static SessionFactory buildFactory(){
		return new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	private SessionFactoryUtil(){}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
