package com.example;

import java.util.List;

public class executeCriteria {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            Employee emp = new Employee("Employee" + i, i, (i % 10) + 1, "Software Developer", 50000 + (i * 1000));
                        methodImplementation.insertEmployee(emp);
        }
        System.out.println("Employee saved successfully");

        List <Employee> employees = methodImplementation.getEmployees(65000);

        for(Employee emp : employees){
            System.out.println(emp);
        }

        List <Employee> employeesort = methodImplementation.sortEmployee("asc","salary");

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
    
            System.out.println("Name: " + name + ", ID: " + employeeId + ", Role: " + role);
        }



        List<Object[]> groupedInfo = methodImplementation.groupByExperience();

        for (Object[] info : groupedInfo) {
            int experience = (int) info[0];
            long count = (long) info[1]; 

            System.out.println("Experience: " + experience + ", Count: " + count);
        }

        List <Employee> employee_in = methodImplementation.betweenOperator();
        System.out.println("Employee with Experience greater than 5 is: ");
        for(Employee emp : employee_in){
            System.out.println(emp);
         }
    }

}
