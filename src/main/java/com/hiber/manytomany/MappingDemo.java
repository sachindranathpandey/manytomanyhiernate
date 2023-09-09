package com.hiber.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Emp e1=new Emp();
		e1.setEid(34);
		e1.setName("Ram");
		
		Emp e2=new Emp();
		e2.setEid(35);
		e2.setName("Shyam");
		
		Project p1=new Project();
		p1.setPid(12121);
		p1.setProjectName("Library Managment System");
		
		Project p2=new Project();
		p2.setPid(14214);
		p2.setProjectName("Chatbot");
		
		List<Emp> 	list1= new ArrayList<Emp>();
		List<Project> 	list2= new ArrayList<Project>();
		
		list1.add(e1);
		list1.add(e2);
		
		list2.add(p1);
		list2.add(p2);
		
		
		e1.setProjects(list2);
		p2.setEmps(list1);
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
			session.save(e1);
			session.save(e2);
			session.save(p1);
			session.save(p2);
		transaction.commit();
		session.close();
	}

}
