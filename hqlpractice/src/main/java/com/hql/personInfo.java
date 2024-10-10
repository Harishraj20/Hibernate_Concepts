package com.hql;

public class personInfo {

    private String fname;
    private String lname;
    private int id;
    private int age;
    private String mailId;
    
    public personInfo(){

    }


    public personInfo(int age, String fname, int id, String lname, String mailId) {
        this.age = age;
        this.fname = fname;
        this.id = id;
        this.lname = lname;
        this.mailId = mailId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }
    







}
