package com.practices;

public class Customers {

    private long account_Number;
    private String customerName;
    private int balance;


    private Banks bank;
    //Default Constructor
     public Customers(){

     }

    //Paramterized Constructor
    public Customers(int balance, Banks bank, String customerName) {
        this.balance = balance;
        this.bank = bank;
        this.customerName = customerName;
    }

    //Getters and Setters
  
    public long getAccount_Number() {
        return account_Number;
    }
    public void setAccount_Number(long account_Number) {
        this.account_Number = account_Number;
    }
    public String getCustomerName() {
        return customerName;
    }  
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public Banks getBank() {
        return bank;
    }
    public void setBank(Banks bank) {
        this.bank = bank;
    }

}
