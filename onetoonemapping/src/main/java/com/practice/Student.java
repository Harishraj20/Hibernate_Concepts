package com.practice;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name ="Student_db")
public class Student {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;


    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "dptId")
    private Details details;

    //Default no parameter constructor
    public Student(){

    }

    
    public Student(String name, Details details) {
        this.name = name;
        this.details = details;
    }


    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Details getDetails() {
        return details;
    }
    public void setDetails(Details details) {
        this.details = details;
    }
}
