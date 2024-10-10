package com.example;
import java.util.List;

public class Library {
    private int lib_id;
    private String lib_name;
    private List <Student> student;

    public Library(){

    }
    public Library(String lib_name, List<Student> student) {
        this.lib_name = lib_name;
        this.student = student;
    }

    public int getLib_id() {
        return lib_id;
    }

    public void setLib_id(int lib_id) {
        this.lib_id = lib_id;
    }

    public String getLib_name() {
        return lib_name;
    }

    public void setLib_name(String lib_name) {
        this.lib_name = lib_name;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

}
