package com.many;

public class Students {
    private int id;
    private String studentName;
    private Departments department;

    public Students(){
        
    }

    public Students(Departments department, String studentName) {
        this.department = department;
        this.studentName = studentName;
    }

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

}
