package com.practices;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Customers customer1 = new Customers(10000, null, "Alice");
        Customers customer2 = new Customers(20000, null, "Bob");
        Customers customer3 = new Customers(100000, null, "Harish");
        Customers customer4 = new Customers(25800, null, "Ravi"); 
         Customers customer5 = new Customers(70600, null, "Keerthi");
        Customers customer6 = new Customers(2078000, null, "Priya");


        List<Customers> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);
        


Banks bank1 = new Banks("HDFC0001234", "HDFC Bank", customerList);

List<Customers> customerList2 = new ArrayList<>(); 

customerList2.add(customer3);
customerList2.add(customer4);

Banks bank2 = new Banks("SBIN0005678", "State Bank of India", customerList2);

List<Customers> customerList3 = new ArrayList<>(); 

customerList3.add(customer3);
customerList3.add(customer4);
Banks bank3 = new Banks("ICIC0009876", "ICICI Bank", customerList3);


        customer1.setBank(bank1);
        customer2.setBank(bank1);
        customer3.setBank(bank2);
        customer4.setBank(bank2);
        customer5.setBank(bank3);
        customer6.setBank(bank3);

        Configuration con;
        con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customers.class).addAnnotatedClass(Banks.class);
        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(bank1);
        session.save(customer1);
        session.save(customer2);
        session.save(bank2);
        session.save(customer3);
        session.save(customer4);
        session.save(bank3);
        session.save(customer5);
        session.save(customer6);
       


        tx.commit();
        session.close();
        sf.close();
        System.out.println("successful");

    }
}
