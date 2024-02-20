package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import javax.naming.InvalidNameException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    static Employee employee;
    static double salary;

    @BeforeAll
    static void initEmployee() {
        salary = 45000.0;
        employee = new Employee("Brian", "Alford", 1011, 'M', "Tester", salary, "Contract");
    }

    @RepeatedTest(5)
    @DisplayName("Salary Update")
    void salaryUpdateTest() {
        double salaryIncrement = 2000.0;
        employee.adjustSalary(salaryIncrement);
        salary += salaryIncrement;

        assertEquals(salary, employee.getSalary(), "Test salary updates");
    }

    @ParameterizedTest
    @DisplayName("Salary update 2")
    @ValueSource(doubles = {500, 1000, 1300, 2400, 3500, 4000, 6000})
    void salaryUpdateTestParams(double salaryIncrement) {
        employee.adjustSalary(salaryIncrement);
        salary += salaryIncrement;
        assertEquals(salary, employee.getSalary());
    }

    @ParameterizedTest
    @DisplayName("Null name check")
    @NullSource
    void nameTestNull(String name) {
        Employee newEmployee = new Employee(name, name, 1011, 'M', "Tester", 50000.0, "Contract");
        assertNull(newEmployee.getFirstName());
        assertNull(newEmployee.getLastName());
    }

    @ParameterizedTest
    @DisplayName("Empty name check")
    @EmptySource
    void nameTestEmpty(String name) {
        Employee newEmployee = new Employee(name, name, 1011, 'M', "Tester", 50000.0, "Contract");
        assertEquals("", newEmployee.getFirstName());
        assertEquals("", newEmployee.getLastName());
    }

    @ParameterizedTest
    @DisplayName("Empty and null name check")
    @NullAndEmptySource
    void nameTestEmptyAndNull(String name) {
        Employee newEmployee = new Employee(name, "name", 1011, 'M', "Tester", 50000.0, "Contract");
        assertTrue(newEmployee.getFirstName() == null || newEmployee.getFirstName().isEmpty());
    }

    @ParameterizedTest
    @DisplayName("Csv")
    @CsvSource({"Brian, Alford", "Amy, Cruz", "Raj, Chawanda"})
    void nameTestCsv(String fname, String lname) {
        Employee newEmployee = new Employee(fname.trim(), lname.trim(), 1011, 'M', "Tester", 50000.0, "Contract");
        assertEquals(newEmployee.getFirstName(), fname.trim());
        assertEquals(newEmployee.getLastName(), lname.trim());
    }

    @ParameterizedTest
    @DisplayName("Csv File")
    @CsvFileSource(resources = "/empnames.csv", numLinesToSkip = 1)
    void nameTestCsvFile(String fname, String lname) {
        Employee newEmployee = new Employee(fname.trim(), lname.trim(), 1011, 'M', "Tester", 50000.0, "Contract");
        assertEquals(newEmployee.getFirstName(), fname.trim());
        assertEquals(newEmployee.getLastName(), lname.trim());
    }

    static Stream<String> getLastNames() {
        return Stream.of("Al4d", "B3nson", "$smith", "@Alford");
    }

    @ParameterizedTest
    @MethodSource("getLastNames")
    @DisplayName("Method Source")
    void nameTest(String lname) {
        Employee newEmployee = new Employee("Brian", lname, 1011, 'M', "Tester", 50000.0, "Contract");
        assertThrows(InvalidNameException.class, () -> {newEmployee.validateLastName();});
    }
}
