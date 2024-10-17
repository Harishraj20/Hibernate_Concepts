package com.example;

import java.time.LocalDateTime;

public class Employee {
    private String name;
    private int employeeId;
    private int experience;
    private String role;
    private int salary;

    private LocalDateTime createdAt;  

    public Employee() {

    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Employee(String name, int experience, String role, int salary) {
        this.name = name;
        this.experience = experience;
        this.role = role;
        this.salary = salary;
        this.createdAt = LocalDateTime.now();
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
        return "Employee [name = " + name + ", employeeId = " + employeeId + ", experience = " + experience + ", role = " + role
                + ", salary = " + salary + ", createdAt = " + createdAt + "]";
    }


}
