package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {

        Data dt = new Data();
        dt.setUid(6);
        dt.setUname("Lakshmi");
        dt.setUdept("CE");

        System.out.println(dt);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Data.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();
        session.save(dt);
        tx.commit();

    }
}