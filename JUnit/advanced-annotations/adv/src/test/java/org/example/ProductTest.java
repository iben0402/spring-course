package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class ProductTest {

    static Product tv;

    @BeforeAll
    static void init() {
        tv = new Product("Sony", "Delta", 12345, 800.0, "Electronics");
    }

    @Test
    @DisplayName("Brand name check")
    @Timeout(5)
    void brandNameTest() throws InterruptedException {
        Thread.sleep(4000);
        assertEquals("Sony", tv.getBrandName(), "Brand Name Test");
    }

    @Test
    @DisplayName("Price Check")
    void priceTest() throws InterruptedException {
        Thread.sleep(3000);
        assertEquals(800.0, tv.getPrice());
    }
}
