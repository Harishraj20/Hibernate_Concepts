package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Execute {
    public static void main(String[] args) {

        product prods = new product("camel", 1.2, "NoteBook", 1200, 75);

        Configuration conf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(product.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();


        session.save(prods);

        product existsInTable = session.get(product.class, prods.getId());


        tx.commit(); //Closes Transaction
        
        System.out.println(tx.isActive());
        System.out.println("Id: "+existsInTable.getId());
        System.out.println("Name: "+existsInTable.getName());
        System.out.println("Brand: "+existsInTable.getBrand());
        System.out.println("Quantity "+ existsInTable.getTotalQuantity());
        System.out.println("Price: "+existsInTable.getPrice());
        System.out.println("Discount Percentage: "+ existsInTable.getDiscountPercent());

    }

}
