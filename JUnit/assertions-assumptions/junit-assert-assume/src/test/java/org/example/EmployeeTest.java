package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.InvalidNameException;
import javax.naming.NamingException;
import java.time.Duration;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    static Employee firstEmployee;
    static Employee secondEmployee;
    static Employee thirdEmployee;
    static Employee fourthEmployee;

    @BeforeAll
    static void initEmployee() {
        ArrayList<String> projects1 = new ArrayList<String>();
        projects1.add("aaa");
        projects1.add("bbb");
        projects1.add("ccc");

        ArrayList<String> projects2 = new ArrayList<String>();
        projects2.add("ddd");
        projects2.add("eee");
        projects2.add("fff");

        ArrayList<String> projects3 = new ArrayList<String>();
        projects3.add("ddd");
        projects3.add("eee");
        projects3.add("fff");

        firstEmployee = new Employee("Iwona", "Bendig", 1001, 'F', "Developer", 50000.0, "Permament", projects1);
        secondEmployee = new Employee("Brian", "Alford", 1002, 'M', "Developer", 45000.0, "Contract", projects2);
        thirdEmployee = null;
        fourthEmployee = new Employee("Brian", "Alford123", 1002, 'M', "Developer", 45000.0, "Contract", projects3);
    }

    @BeforeEach
    void resetEmployees() {
        ArrayList<String> projects1 = new ArrayList<String>();
        projects1.add("aaa");
        projects1.add("bbb");
        projects1.add("ccc");

        ArrayList<String> projects2 = new ArrayList<String>();
        projects2.add("ddd");
        projects2.add("eee");
        projects2.add("fff");

        ArrayList<String> projects3 = new ArrayList<String>();
        projects3.add("ddd");
        projects3.add("eee");
        projects3.add("fff");

        firstEmployee = new Employee("Iwona", "Bendig", 1001, 'F', "Developer", 50000.0, "Permament", projects1);
        secondEmployee = new Employee("Brian", "Alford", 1002, 'M', "Developer", 45000.0, "Contract", projects2);
        thirdEmployee = null;
        fourthEmployee = new Employee("Brian", "Alford123", 1002, 'M', "Developer", 45000.0, "Contract", projects3);
    }

    @Test
    void salaryTest() {
        firstEmployee.adjustSalary(5000);
        assertEquals(55000, firstEmployee.getSalary());
    }

    @Test
    void roleTest() {
        assertTrue(firstEmployee.getRole().equals(secondEmployee.getRole()), "checks if both employees have the same role");
    }

    @Test
    void genderTest() {
        assertFalse(firstEmployee.getGender().equals(secondEmployee.getGender()), "checks if employees have different gender");
    }

    @Test
    void copyTest() {
        Employee firstShallowCopy =firstEmployee;
        assertSame(firstEmployee, firstShallowCopy);
    }

    @Test
    void copyTestNotSame() {
        Employee firstSeparateCopy = new Employee(firstEmployee.getFirstName(), firstEmployee.getLastName(), firstEmployee.getId(), firstEmployee.getGender(), firstEmployee.getRole(), firstEmployee.getSalary(), firstEmployee.getType(), firstEmployee.getProjects());
        assertNotSame(firstEmployee, firstSeparateCopy);
    }

    @Test
    void durationTest() {
        assertTimeout(Duration.ofSeconds(5), () -> {
            firstEmployee.adjustSalary(2000);
        });
    }

    @Test
    void nullTest() {
        assertNull(thirdEmployee);
    }

    @Test
    void exceptionTest() {
        assertThrows(NamingException.class, ()-> {
            fourthEmployee.validateLastName();
        });
    }

    @Test
    void employeeTest() {
        fourthEmployee.adjustSalary(4000);
        assertAll(
                "Test Employee",
                () -> assertEquals(49000.0, fourthEmployee.getSalary()),
                () -> assertNotNull(fourthEmployee.getFirstName()),
                () -> assertThrows(NamingException.class, () -> {
                    fourthEmployee.validateLastName();
                }, "Throws Exception test")
        );
    }

    @Test
    void projectsTest() {
        ArrayList<String> projects1 = new ArrayList<String>();
        projects1.add("aaa");
        projects1.add("bbb");
        projects1.add("ccc");

        assertIterableEquals(projects1, firstEmployee.getProjects());
    }


}
