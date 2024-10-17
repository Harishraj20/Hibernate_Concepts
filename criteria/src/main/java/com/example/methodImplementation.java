package com.example;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
            criteriaquery.select(root).where(cb.equal(root.get("employeeId"), 18));

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
            CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
            Root<Employee> root = cq.from(Employee.class);

            cq.select(root).where(cb.greaterThan(root.get("experience"), 5));
            employees = session.createQuery(cq).getResultList();

        } finally {
            session.close();
            sf.close();
        }

        return employees;
    }

    public static List<Object[]> employeeRange() {
        Configuration con = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        List<Object[]> employees;

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Employee> root = cq.from(Employee.class);

        cq.multiselect(root.get("name"), root.get("employeeId"), root.get("role"));

        employees = session.createQuery(cq).getResultList();
        session.close();
        return employees;
    }

    public static List<Object[]> groupByExperience() {
        Configuration con = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        List<Object[]> employees = null;

        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
            Root<Employee> root = cq.from(Employee.class);

            cq.multiselect(root.get("experience"), cb.count(root)).groupBy(root.get("experience"));
            Query<Object[]> query = session.createQuery(cq);
            employees = query.getResultList();
        } finally {
            session.close();
            sf.close();
        }

        return employees;
    }

    public static List<Employee> inOperation(int num1, int num2) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        List<Employee> employees;

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> root = cq.from(Employee.class);
        cq.select(root).where(root.get("salary").in(num1, num2));

        employees = session.createQuery(cq).getResultList();

        return employees;
    }

    public static List<Employee> betweenOperator() {
        Configuration con = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        List<Employee> employees;

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        Predicate predicate = cb.between(root.get("salary"), 60000, 65000);

        cq.select(root).where(predicate);

        employees = session.createQuery(cq).getResultList();

        return employees;
    }

    public static List<Employee> andOrOperation() {

        Configuration con = new Configuration().configure("hibernate.cfg.xml");

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        List<Employee> employees = null;
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> root = cq.from(Employee.class);
        Predicate predicate = cb.greaterThan(root.get("salary"), 65000);
        Predicate predicate1 = cb.greaterThan(root.get("experience"), 3);

        Predicate andOperate = cb.and(predicate, predicate1);

        cq.select(root).where(andOperate);

        employees = session.createQuery(cq).getResultList();
        return employees;
    }

    public static List<Object[]> getNames() {

        Configuration con = new Configuration().configure("hibernate.cfg.xml");

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        List<Object[]> employees = null;
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Employee> root = cq.from(Employee.class);
        Predicate predicate = cb.greaterThan(root.get("salary"), 65000);
        Predicate predicate1 = cb.greaterThan(root.get("experience"), 3);

        Predicate andOperate = cb.and(predicate, predicate1);

        cq.multiselect(root.get("name"), root.get("experience")).where(andOperate);

        employees = session.createQuery(cq).getResultList();
        return employees;

    }

    public static List<Object[]> likeOperator(String nameparam) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Employee> root = cq.from(Employee.class);

        Predicate predicate = cb.like(root.get("name"), "%" + nameparam + "%");

        cq.multiselect(root.get("name"), root.get("experience")).where(predicate);

        List<Object[]> results = session.createQuery(cq).getResultList();
        session.close();
        return results;
    }

    public static List<Object[]> salaryGreaterThanAverageSalary() {
        Configuration con = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = null;
        List<Object[]> results = null;

        try {
            session = sf.openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();

            CriteriaQuery<Double> avgSalaryQuery = cb.createQuery(Double.class);
            Root<Employee> avgRoot = avgSalaryQuery.from(Employee.class);
            avgSalaryQuery.select(cb.avg(avgRoot.get("salary")));
            Double avgVal = session.createQuery(avgSalaryQuery).getSingleResult();

            System.out.println(avgVal);

            CriteriaQuery<Object[]> employeeQuery = cb.createQuery(Object[].class);
            Root<Employee> employeeRoot = employeeQuery.from(Employee.class);
            Predicate salaryPredicate = cb.greaterThan(employeeRoot.get("salary"), avgVal);
            employeeQuery.multiselect(employeeRoot.get("name"), employeeRoot.get("experience"))
                    .where(salaryPredicate);

            results = session.createQuery(employeeQuery).getResultList();

            CriteriaQuery<Long> employeeCountQuery = cb.createQuery(Long.class);
            Root<Employee> countRoot = employeeCountQuery.from(Employee.class);
            employeeCountQuery.select(cb.count(countRoot)).where(salaryPredicate);
            Long count = session.createQuery(employeeCountQuery).getSingleResult();

            System.out.println("Count of Employees with Salary Greater than Average: " + count);

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return results;
    }

    public static List<Employee> expGreaterThanAvg() {
        Configuration con = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = null;
        List<Employee> employees;

        try {
            session = sf.openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();

            // Fetching avg of experience
            CriteriaQuery<Double> cq = cb.createQuery(Double.class);
            Root<Employee> empRoot = cq.from(Employee.class);

            cq.select(cb.avg(empRoot.get("experience")));
            Double val = session.createQuery(cq).getSingleResult();
            System.out.println("The average experience of all the employee is: " + val);

            // Fetching employee details whose experienc is greter than average of the
            // experience of the all employees

            CriteriaQuery<Employee> cqe = cb.createQuery(Employee.class);

            Root<Employee> rootemp = cqe.from(Employee.class);
            Predicate gt = cb.greaterThan(rootemp.get("experience"), val);

            cqe.select(rootemp).where(gt);

            employees = session.createQuery(cqe).getResultList();

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return employees;
    }

    public static List<Object[]> groupByRole() {
        Configuration con = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = null;
        List<Object[]> employees = null;

        try {
            session = sf.openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();

            CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
            Root<Employee> root = cq.from(Employee.class);

            cq.multiselect(root.get("role"), cb.count(root))
                    .groupBy(root.get("role"))
                    .having(cb.greaterThan(cb.count(root), Long.valueOf(1)));
            employees = session.createQuery(cq).getResultList();

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return employees;
    }

    public static List<Employee> getEmployeeBySalary() {
        Configuration con = new Configuration().configure("hibernate.cfg.xml");

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        List<Employee> employees = null;
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> root = cq.from(Employee.class);
        Predicate predicate = cb.equal(root.get("salary"), 75000);

        cq.select(root).where(predicate);

        employees = session.createQuery(cq).getResultList();
        return employees;
    }

    public static List<Employee> getEmployeeByDate(LocalDateTime date) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml");

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);

        criteriaQuery.select(root)
                .where(criteriaBuilder.lessThan(root.get("createdAt"), date));

        return session.createQuery(criteriaQuery).getResultList();
    }

}
