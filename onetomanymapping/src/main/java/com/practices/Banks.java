package com.practices;

import java.util.List;

public class Banks {

    // @Id
    private String bank_IFSC;
    private String bank_name;

    // @OneToMany(mappedBy = "bank")
    private List <Customers> customers;

    //Default Constructor
    public Banks(){

    }

    public Banks(String bank_IFSC, String bank_name, List<Customers> customers) {
        this.bank_IFSC = bank_IFSC;
        this.bank_name = bank_name;
        this.customers = customers;
    }

    //Getters and Setters 

    public String getBank_name() {
        return bank_name;
    }
    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }
    public String getBank_IFSC() {
        return bank_IFSC;
    }
    public void setBank_IFSC(String bank_IFSC) {
        this.bank_IFSC = bank_IFSC;
    }

    public List<Customers> getCustomers() {
        return customers;
    }
    public void setCustomers(List<Customers> customers) {
        this.customers = customers;
    }

    






}
