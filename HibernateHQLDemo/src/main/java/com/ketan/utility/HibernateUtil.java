package com.ketan.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.ketan.DO.StudentDO;

public class HibernateUtil {
	
	private static SessionFactory factory;
	
	static {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml").addAnnotatedClass(StudentDO.class);
		StandardServiceRegistryBuilder serviceRegisteryBuilder = new StandardServiceRegistryBuilder();
		serviceRegisteryBuilder.applySettings(cfg.getProperties());
		ServiceRegistry registry = serviceRegisteryBuilder.build();
		factory = cfg.buildSessionFactory(registry);
	}
	
	public static Session getSession() {
		Session ses = null;
		if(factory != null) {
			ses = factory.openSession();
		}
		return ses;
	}
	
	public static void closeSession(Session ses)
	{
		if(ses != null) {
			ses.close();
		}
	}
	
	public static void closeSessionFactory() {
		if(factory != null) {
			factory.close();
		}
	}

}
