package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // Create new product instances
        product pro2 = new product("Britania", 2.5, "Cookies", 598, 50);
        product pro3 = new product("Cadbury", 1.2, "Chocolates", 90, 100);
        product pro4 = new product("DVD Player", 2.3, "XYZ", 1000, 10);

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(product.class);

        try (SessionFactory sf = con.buildSessionFactory(); Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();

            saveOrUpdateProduct(session, pro2);
            saveOrUpdateProduct(session, pro3);
            saveOrUpdateProduct(session, pro4);
            System.out.println(tx.isActive());

            tx.commit();
            System.out.println(tx.isActive());
        }

        System.out.println("Products saved or updated successfully!");
    }

    private static void saveOrUpdateProduct(Session session, product pro) {
        product existingProduct = session.get(product.class, pro.getId());

        if (existingProduct == null) {
            session.save(pro);
        } else {
            existingProduct.setBrand(pro.getBrand());
            existingProduct.setName(pro.getName());
            existingProduct.setPrice(pro.getPrice());
            existingProduct.setTotalQuantity(pro.getTotalQuantity());
        }
    }
}
