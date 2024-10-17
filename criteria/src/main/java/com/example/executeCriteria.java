package com.example;

import java.time.LocalDateTime;
import java.util.*;


public class executeCriteria {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ravindhar", "Praveen", "Charubala",
        "Krish", "Nirmal",
        "Venkat", "Grace", "Harshitha", "Rakesh", "Janani",
        "Arjun", "Bala", "Charan", "Divya", "Eswar",
        "Farhan", "Gopal", "Hari", "Indira", "Jai",
        "Kevin", "Keshav", "Nithya", "Ranjith", "Pradeep",
        "priyanka", "Priya", "Ram", "Siva", "Tharun", "Uma");
        List<String> roles;
        roles = Arrays.asList("Software Developer", "Project Manager",
                "QA Engineer", "Data Analyst",
                "DevOps Engineer", "System Architect",
                "UI/UX Designer", "Database Administrator",
                "Business Analyst", "Network Engineer");

        Random random = new Random();

        for (int i = 0; i < 20; i++) {
        String name = names.get(i);
        String role = roles.get(random.nextInt(roles.size()));

        int experience = random.nextInt(15) + 1;

        int salary = 50000 + (experience * 5000);

        Employee emp = new Employee(name, experience, role, salary);

        methodImplementation.insertEmployee(emp);
        }

        System.out.println("Employees saved successfully");

        List <Employee> employees = methodImplementation.getEmployees(65000);

        for(Employee emp : employees){
        System.out.println(emp);
        }

        List <Employee> employeesort =
        methodImplementation.sortEmployee("asc","salary");

        for(Employee emp : employeesort){
        System.out.println(emp);
        }

        List <Employee> employeesal = methodImplementation.selectBased();
        System.out.println("Employee with ID = 18 is: ");
        for(Employee emp : employeesal){
        System.out.println(emp);
        }

        List <Employee> employee_exp = methodImplementation.employeExperience();
        System.out.println("Employee with Experience greater than 5 is: ");
        for(Employee emp : employee_exp){
        System.out.println(emp.getName());
        }

        List<Object[]> employeeData = methodImplementation.employeeRange();
        System.out.println("List of Names of the employee role:");

        for (Object[] empData : employeeData) {
        String name = (String) empData[0];
        Integer employeeId = (Integer) empData[1];
        String role = (String) empData[2];

        System.out.println("Name: " + name + ", ID: " + employeeId + ", Role: " +
        role);
        }

        List<Object[]> groupedInfo = methodImplementation.groupByExperience();

        for (Object[] info : groupedInfo) {
        int experience = (int) info[0];
        long count = (long) info[1];

        System.out.println("Experience: " + experience + ", Count: " + count);
        }

        List <Employee> employee_in = methodImplementation.expGreaterThanAvg();
        System.out.println("Employee with Experience greater than Average experience is: ");
        for(Employee emp : employee_in){
        System.out.println(emp);
        }

        List<Employee> empor = methodImplementation.andOrOperation();
        for (Employee emp : empor) {
        System.out.println(emp);
        }

        LocalDateTime date = LocalDateTime.of(2024, 10, 22, 0, 0); 
        List<Employee> emps = methodImplementation.getEmployeeByDate(date);

        for(Employee em : emps){
            System.out.println(em);
        }


    }

}
