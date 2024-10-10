package com.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class execute {
    public static void main(String[] args) {

        personInfo p1 = new personInfo(20, "ravi", 1, "shankar", "ravi.shankar@gmail.com");
        personInfo p2 = new personInfo(20, "krish", 2, "Morthy", "krishna.morthy@gmail.com");
        personInfo p3 = new personInfo(20, "vijaya", 3, "sundhari", "vijaya.sundari@gmail.com");
        personInfo p4 = new personInfo(19, "priya", 4, "Dharshini", "priya.darshini@gmail.com");
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(personInfo.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();
        insertQuery(session, p1);
        insertQuery(session, p2);
        insertQuery(session, p3);
        insertQuery(session, p4);
        deleteQuery(session, p3);
        tx.commit();

        System.out.println("Operation successful!");
    }

    public static void saveOrUpdate(Session session, personInfo person) {
        personInfo personExists = session.get(personInfo.class, person.getMailId());
        if (personExists == null) {
            session.save(person);
            System.out.println("person saved");
        } else {
            personExists.setAge(person.getAge());
            personExists.setFname(person.getFname());
            personExists.setLname(person.getLname());
            personExists.setMailId(person.getMailId());
            System.out.println("person updated");
        }
    }

    public static void updateQuery(Session session, String oldEmail, String newEmail) {
        String hql = "UPDATE personInfo SET mailId = :newEmail WHERE mailId = :oldEmail";
        Query query = session.createQuery(hql);
        query.setParameter("oldEmail", oldEmail);
        query.setParameter("newEmail", newEmail);
        query.executeUpdate();
    }

    public static void insertQuery(Session session, personInfo person) {
        personInfo personExists = session.get(personInfo.class, person.getMailId());
        if (personExists == null) {
            session.save(person);
            System.out.println("person saved");
        } else {
            System.out.println("Already Exists");
        }
    }

    public static void deleteQuery(Session session, personInfo person) {
        String deleteQuery = "DELETE from personInfo where mailId = :emailId";
        Query query = session.createQuery(deleteQuery);
        query.setParameter("emailId", person.getMailId());
        query.executeUpdate();
        System.out.println("person deleted Successfully");
    }

}
