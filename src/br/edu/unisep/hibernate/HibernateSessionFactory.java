package br.edu.unisep.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

	private static SessionFactory sessionFactory;

	static {

		Configuration config = new Configuration();

		config.configure();

		StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
		srb.applySettings(config.getProperties());

		StandardServiceRegistry reg = srb.build();

		sessionFactory = config.buildSessionFactory(reg);
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}
}