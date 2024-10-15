package com.example;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class methodImplementation {

    public static void insertEmployee(Employee emp) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(emp);
        tx.commit();
    }

    public static List<Employee> getEmployees(int salary) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        List<Employee> employees = null;

        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaquery = cb.createQuery(Employee.class);

            Root<Employee> root = criteriaquery.from(Employee.class);
            criteriaquery.select(root).where(cb.greaterThan(root.get("salary"), salary));

            employees = session.createQuery(criteriaquery).getResultList();
        } finally {
            session.close();
            sf.close();
        }

        return employees;
    }

    public static List<Employee> sortEmployee(String order, String field) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        List<Employee> employees = null;

        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaquery = cb.createQuery(Employee.class);

            Root<Employee> root = criteriaquery.from(Employee.class);
            Order sort;
            if (order.equals("asc")) {
                sort = cb.asc(root.get(field));
            } else {
                sort = cb.desc(root.get(field));
            }
            criteriaquery.select(root).orderBy(sort);

            employees = session.createQuery(criteriaquery).getResultList();
        } finally {
            session.close();
            sf.close();
        }

        return employees;
    }

    public static List<Employee> selectBased() {
        Configuration con = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        List<Employee> employees = null;

        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaquery = cb.createQuery(Employee.class);

            Root<Employee> root = criteriaquery.from(Employee.class);
            criteriaquery.select(root).where(cb.equal(root.get("employeeId"),18));

           employees = session.createQuery(criteriaquery).getResultList();

        } finally {
            session.close();
            sf.close();
        }

        return employees;
    }

    
    public static List<Employee> employeExperience() {
        Configuration con = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        List<Employee> employees = null;

        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery <Employee> cq = cb.createQuery(Employee.class);
            Root<Employee> root =  cq.from(Employee.class) ;
            
            cq.select(root).where(cb.greaterThan(root.get("experience"), 5));
            employees = session.createQuery(cq).getResultList();

        } finally {
            session.close();
            sf.close();
        }

        return employees;
    }
}
