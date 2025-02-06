package com.relationships;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        Laptop l1 = new Laptop();
        l1.setLid(109);
        l1.setModel("pp");

        s1.setRollno(19);
        s1.setName("jj");
        s1.setMarks(60);
        //s1.setLaptop(l1) // One to one will create a new column in student table
        s1.getLaptop().add(l1);// One to many will create a student_laptop table with roll and lid
        l1.getStudent().add(s1); // many to many will creates both if not specified

        Configuration con = new Configuration().configure("hibernate.cfg.xml");
        con.addAnnotatedClass(Student.class);
        con.addAnnotatedClass(Laptop.class);
        ServiceRegistry sr =new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf = con.buildSessionFactory(sr);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(s1);
        session.save(l1);
        tx.commit();
        //System.out.println(s1);
        //System.out.println(l1);

    }
}
