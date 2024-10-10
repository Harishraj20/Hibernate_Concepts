package com.example;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// Main.java
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(null, "Pavithra");
        Student s2 = new Student(null, "Vishal");
        Student s3 = new Student(null, "priyanka");
        Student s4 = new Student(null, "Ramesh");
        Student s5 = new Student(null, "Karthick");

        List<Student> sl1 = new ArrayList<>();
        List<Student> sl2 = new ArrayList<>();

        sl1.add(s1);
        sl1.add(s2);
        sl1.add(s3);
        sl2.add(s4);
        sl2.add(s5);

        Library l1 = new Library("ECE", sl1);
        Library l2 = new Library("CSE", sl2);

        for (Student student : sl1) {

            List<Library> libraries = new ArrayList<>();
            libraries.add(l1);
            libraries.add(l2);
            student.setLibrary(libraries);

        }
        for (Student student : sl2) {
            student.setLibrary(List.of(l2));
        }

        Configuration config = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Library.class);

        try (SessionFactory sessionFactory = config.buildSessionFactory();
                Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(l1);
            session.save(l2);
            session.save(s1);
            session.save(s2);
            session.save(s3);
            session.save(s4);
            session.save(s5);

            transaction.commit();
            sessionFactory.close();
            session.close();
        }

        System.out.println("Data saved successfully!");
    }
}
