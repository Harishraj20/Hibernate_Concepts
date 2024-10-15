package com.example;

public class Employee {
    private String name;
    private int employeeId;
    private int experience;
    private String role;
    private int salary;

    public Employee() {

    }

    public Employee(String name, int employeeId, int experience, String role, int salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.experience = experience;
        this.role = role;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [Name = " + name + ", EmployeeId = " + employeeId + ", Experience = " + experience + ", Role = " + role
                + ", Salary = " + salary + "]";
    }

}
