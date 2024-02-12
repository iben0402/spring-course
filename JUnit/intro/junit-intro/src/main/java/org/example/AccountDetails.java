package org.example;

public class AccountDetails {
    private  String name;
    private Double accountNumber;
    private Integer customerID;
    private Double balance;
    private String accountType;

    public AccountDetails(String name, Double accountNumber, Integer customerID, Double balance, String accountType) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.customerID = customerID;
        this.balance = balance;
        this.accountType = accountType;
    }

    public void deposit(double depositAmount) {
        balance = balance + depositAmount;
    }

    public boolean withdraw(double withdrawAmount) {
        if(withdrawAmount > balance) {
            System.out.println("Insufficient Funds");
            return false;
        } else {
            balance = balance -withdrawAmount;
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Double accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}

