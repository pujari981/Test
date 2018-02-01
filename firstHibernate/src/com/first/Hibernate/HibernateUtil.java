package com.first.Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public final class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	public static synchronized SessionFactory getSessionFactory()
	{
		/*if(sessionFactory==null)
		{
			Configuration configuration = new Configuration()
					                      .configure("hibernate.cfg.xml");

	        serviceRegistry = new StandardServiceRegistryBuilder()
	                          .applySettings( configuration.getProperties() )
	                          .build();

	        sessionFactory = configuration.buildSessionFactory( serviceRegistry );
		}*/
		if(sessionFactory==null)
		{
			serviceRegistry = new StandardServiceRegistryBuilder()
	                .configure("hibernate.cfg.xml")
	                .build();

	        sessionFactory = new Configuration().buildSessionFactory( serviceRegistry );
		}
		return sessionFactory;
		
	}
	
	
}
