package com.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Details d1 = new Details("CSE", "Bangalore", 5);
        Student s1 = new Student("Arjun Rao", d1);

        Details d2 = new Details("ME", "Hyderabad", 3);
        Student s2 = new Student("Anita Singh", d2);

        Details d3 = new Details("EEE", "Mumbai", 8);
        Student s3 = new Student("Ravi Kumar", d3);

        Details d4 = new Details("IT", "Delhi", 2);
        Student s4 = new Student("Priya Verma", d4);

        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Details.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        saveorupdate(session, s1, d1);
        saveorupdate(session, s2, d2);
        saveorupdate(session, s3, d3);
        tx.commit();

        session.close();
        sf.close();

        System.out.println("successful");
    }

    public static void saveorupdate(Session session, Student s, Details d) {

        Student existingStudent = session.get(Student.class, s.getId());
        Details existingDetails = session.get(Details.class, d.getDptId());

        if (existingStudent == null && existingDetails == null) {
            session.save(s);
            session.save(d);
            System.out.println("Both Details & Student saved");
        } else if (existingStudent != null && existingDetails == null) {
            existingStudent.setDetails(d);
            session.update(existingStudent);
            session.save(d);
            System.out.println("Details saved & Student updated");
        } else if (existingStudent != null && existingDetails != null) {
            existingStudent.setDetails(existingDetails);
            session.update(existingStudent);
            System.out.println("Both Details & Student updated");
        }
    }

}
