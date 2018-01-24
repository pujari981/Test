package com.first.Hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {

	private static Scanner scanner;

	public static void main(String[] args) {
		  //creating configuration object  
	    Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	      
	    //creating seession factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	      
	    //creating session object  
	    Session session=factory.openSession();
	    scanner = new Scanner(System.in);
	    System.out.println("Enter First Name");
	    String fName=scanner.next();
	    System.out.println("Enter Last Name");
	    String lName= scanner.next();
	    System.out.println("Enter Account Bal");
	    float accbal = scanner.nextFloat();
	      
	    Employee e1=new Employee();  
	    //e1.setId(2);  
	    e1.setFirstName(fName);  
	    e1.setLastName(lName);
	    e1.setAccBalance(accbal);
	   
	    //creating transaction object  
	    Transaction t=session.beginTransaction();  
	    Integer s1 = (Integer)session.save(e1);//persisting the object 
	    System.out.println(s1);
	    t.commit();//transaction is committed
	    Object o = session.load(Employee.class,1);
	    System.out.println(o);
	    Employee emp = (Employee)o;
	    System.out.println(emp);
	    System.out.println(emp.getFirstName());
	    
	    
	   /* session = factory.openSession();
	    
	    scanner = new Scanner(System.in);
	    System.out.println("Enter First Name");
	    String fiName=scanner.next();
	    System.out.println("Enter Last Name");
	    String laName= scanner.next();
	    System.out.println("Enter Account Bal");
	    float accbal1 = scanner.nextFloat();
	    Employee e2=new Employee();
	    e2.setFirstName(fiName);  
	    e2.setLastName(laName);
	    e2.setAccBalance(accbal1);
	    t = session.beginTransaction();
	    session.persist(e2);
	    t.commit();
	    Object o1 = session.get(Employee.class,1);
	    System.out.println(o1);
	    Employee emp1 = (Employee)o1;
	    System.out.println(emp1);
	    System.out.println(emp1.getAccBalance());*/
	    session.close();  
	    //factory.close();
	    System.out.println("successfully saved"); 

	}

}

