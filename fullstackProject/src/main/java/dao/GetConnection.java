package dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.CustomerData;

public class GetConnection{
//建立基本JPA框架連線
	public static EntityManager getJPAConnection() {
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("MyJavaMavenProject01");
		
		return factory.createEntityManager();
	}
	
//建立Hibernate連線	
	static Session getHibernateConnection() {
//		configure("hibernate.cfg.xml")--連線的設定可省略不寫，可以多寫連不同資料庫
		//SessionFactory factory = new Configuration().configure("可省略不寫").buildSessionFactory();
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		return factory.openSession();
		
	}
}
