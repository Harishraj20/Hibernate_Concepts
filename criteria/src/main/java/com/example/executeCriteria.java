package com.example;

import java.util.List;

public class executeCriteria {
    public static void main(String[] args) {
        // for (int i = 1; i <= 20; i++) {
        //     Employee emp = new Employee("Employee" + i, i, (i % 10) + 1, "Software Developer", 50000 + (i * 1000));
        //                 methodImplementation.insertEmployee(emp);
        // }
        // System.out.println("Employee saved successfully");

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


    }































}
