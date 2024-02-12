package org.example;

// this is a test without a JUnit
public class AccountDetailsTestWithoutJunit {
    AccountDetails accountDetails = new AccountDetails("Anit4", (double) 0114015333, 114532, 5000.0, "Savings");

    void validateName() {
        if(accountDetails.getName().matches("^[a-zA-Z]*$")){
            System.out.println("Test passed : name is valid");
        } else {
            System.out.println("Test failed : name is invalid");
        }
    }

    public static void main(String[] args) {
        AccountDetailsTestWithoutJunit accountDetailsTest = new AccountDetailsTestWithoutJunit();
        accountDetailsTest.validateName();
    }
}
