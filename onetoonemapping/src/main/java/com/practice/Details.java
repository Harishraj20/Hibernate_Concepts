package com.practice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name ="details_db")
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dptId;
    private String dptName;
    private int Studrank;
    private String location;

    @OneToOne(mappedBy="details")

    private Student student;

    public Details(){

    }

    public Details(String dptName, String location, int Studrank) {
        this.dptName = dptName;
        this.location = location;
        this.Studrank = Studrank;
    }

    public int getDptId() {
        return dptId;
    }

    public void setDptId(int dptId) {
        this.dptId = dptId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getDptName() {
        return dptName;
    }
    public void setDptName(String dptName) {
        this.dptName = dptName;
    }

    public int getRank() {
        return Studrank;
    }
    public void setRank(int Studrank) {
        this.Studrank = Studrank;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
