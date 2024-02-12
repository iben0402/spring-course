package org.example;

import org.junit.Ignore;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

//This is a test with JUnit

public class AccountDetailsTest {
    static AccountDetails accountDetails;

    @BeforeAll
    static void initAll() {
        accountDetails = new AccountDetails("Anita", (double) 0114015333, 114532, 5000.0, "Savings");
        System.out.println("Setup");
    }
    @BeforeEach
    void init() {
        accountDetails.setBalance(5000.0);
        System.out.println("Account Balance: " + accountDetails.getBalance());
    }

    @Test
    void depositTest() {
        accountDetails.deposit(500);
        System.out.println("@Test block for deposit has been executed");
    }

    @Test
    void withdrawTest() {
        accountDetails.withdraw(1000);
        System.out.println("@Test block for withdraw has been executed");
    }

    @AfterEach
    void balance() {
        System.out.println("Account Balance: " + accountDetails.getBalance());
    }

    @AfterAll
    static void clearAll() {
        accountDetails = null;
        System.out.println("cleaning");
    }



    // disabled tests
    @Disabled
    @Test
    public void validateName() {
        assertTrue(accountDetails.getName().matches("^[a-zA-Z]*$"));
    }

    @Disabled
    @Test
    public void validateBalance() {
        assertTrue(accountDetails.getBalance() >= 0);
    }



}
