package com.many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Students s1 = new Students(null, "Harish");
        Students s2 = new Students(null, "Prakash");
        Students s3 = new Students(null, "Pradeep");
        Students s4 = new Students(null, "Archana");
        Students s5 = new Students(null, "Kavya");
        Students s6 = new Students(null, "Sundhar");
        Students s7 = new Students(null, "Vimal");
        Students s8 = new Students(null, "Arun");
        Students s9 = new Students(null, "Sneha");
        Students s10 = new Students(null, "kiran");

        List<Students> StudentList1 = new ArrayList<>();
        List<Students> StudentList2 = new ArrayList<>();
        List<Students> StudentList3 = new ArrayList<>();
        StudentList1.add(s1);
        StudentList1.add(s2);
        StudentList1.add(s3);
        StudentList2.add(s4);
        StudentList2.add(s5);
        StudentList2.add(s6);
        StudentList3.add(s7);
        StudentList3.add(s8);
        StudentList3.add(s9);
        StudentList3.add(s10);

        Departments d1 = new Departments("CSE", StudentList1);
        Departments d2 = new Departments("Mechanical", StudentList2);
        Departments d3 = new Departments("IT", StudentList3);

        for (Students student : StudentList1) {
            student.setDepartment(d1);
        }
        for (Students student : StudentList2) {
            student.setDepartment(d2);
        }
        for (Students student : StudentList3) {
            student.setDepartment(d3);
        }
        Configuration con;
        con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Departments.class)
                .addAnnotatedClass(Students.class);
        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(d1);
        session.save(d2);
        session.save(d3);
        for (Students s: StudentList1){
            session.save(s);
        }
        for (Students s: StudentList2){
            session.save(s);
        }
        for (Students s: StudentList3){
            session.save(s);
        }
     

        tx.commit();
        session.close();
        sf.close();
        System.out.println("successful");

    }
}