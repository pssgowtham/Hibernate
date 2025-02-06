package com.cacheing;

import com.hibernate.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Col c = new Col();
//        c.setId(3);
//        c.setName("Sneha");
//        c.setDept("ECE");
//        c.setAddress("Chennai");

        Configuration con = new Configuration().configure("hibernate.cfg.xml");
        con.addAnnotatedClass(Col.class);
        ServiceRegistry sr =new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf = con.buildSessionFactory(sr);
        Session session1 = sf.openSession();
        Transaction tx1 = session1.beginTransaction();
        Col c1 = session1.get(Col.class, 1);  // Fetch from DB and store in cache
        System.out.println("First Session: " + c1);
        tx1.commit();
        session1.close();

        // Second Session (Should Fetch from Cache)
        Session session2 = sf.openSession();
        Transaction tx2 = session2.beginTransaction();
        Query q = session2.createQuery("from Col");
        List<Col> lis = q.list();
        for (Col c2 : lis) {
            System.out.println(c2);
        }

        tx2.commit();
        session2.close();
        sf.close();


    }
}
