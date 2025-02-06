package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class basic {
    public static void main(String[] args) {
        Employee e = new Employee();
        Ename nm = new Ename();
        nm.setFNAME("Lakshmi");
        nm.setLNAME("Kumar");
        nm.setMNAME("Raj");
        e.setEMPNO(113);
        e.setENAME(nm);
        e.setWORKDEPT("MECH");
        e.setPHONENO(9232445454L);
        System.out.println(e);

        Configuration con = new Configuration().configure("hibernate.cfg.xml");
        con.addAnnotatedClass(Employee.class);
        ServiceRegistry sr =new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf = con.buildSessionFactory(sr);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(e);
        //e =(Employee) session.get(Employee.class,112);
        tx.commit();
        System.out.println(e);


    }
}
