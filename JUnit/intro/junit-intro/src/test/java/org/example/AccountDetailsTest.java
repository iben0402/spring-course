package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

//This is a test with JUnit

public class AccountDetailsTest {
    AccountDetails accountDetails = new AccountDetails("Anita", (double) 0114015333, 114532, 5000.0, "Savings");

    @Test
    public void validateName() {
        assertTrue(accountDetails.getName().matches("^[a-zA-Z]*$"));
    }

    @Test
    public void validateBalance() {
        assertTrue(accountDetails.getBalance() >= 0);
    }

}
