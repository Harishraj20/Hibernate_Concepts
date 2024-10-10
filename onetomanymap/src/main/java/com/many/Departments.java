package com.many;

import java.util.List;

public class Departments {

    private int dptId;
    private String name;

    private List<Students> student;

    public Departments(){

    }
    public Departments(String name, List<Students> student) {
        this.name = name;
        this.student = student;
    }

    public int getDptId() {
        return dptId;
    }

    public void setDptId(int dptId) {
        this.dptId = dptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Students> getStudent() {
        return student;
    }

    public void setStudent(List<Students> student) {
        this.student = student;
    }

}
