package com.example;

import java.util.List;

public class Student {
    private int stud_id;
    private String stud_name;
    
    private List<Library> library;

    public Student(List<Library> library, String stud_name) {
        this.library = library;
        this.stud_name = stud_name;
    }

    public int getStud_id() {
        return stud_id;
    }

    public void setStud_id(int stud_id) {
        this.stud_id = stud_id;
    }

    public String getStud_name() {
        return stud_name;
    }

    public void setStud_name(String stud_name) {
        this.stud_name = stud_name;
    }

    public List<Library> getLibrary() {
        return library;
    }

    public void setLibrary(List<Library> library) {
        this.library = library;
    }
    

}
