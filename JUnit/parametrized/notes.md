# Parametrized JUnit Tests

## Repeated tests
```java
@RepeatedTest(5)
@DisplayName("Salary Update")
void salaryUpdateTest() {
    double salaryIncrement = 2000.0;
    employee.adjustSalary(salaryIncrement);
    salary += salaryIncrement;

    assertEquals(salary, employee.getSalary(), "Test salary updates");
}
```

## Parametrized test
```java
@ParameterizedTest
@DisplayName("Salary update 2")
@ValueSource(doubles = {500, 1000, 1300, 2400, 3500, 4000, 6000})
void salaryUpdateTestParams(double salaryIncrement) {
    employee.adjustSalary(salaryIncrement);
    salary += salaryIncrement;
    assertEquals(salary, employee.getSalary());
}
```

## null parameter 
```java
@ParameterizedTest
@DisplayName("Null name check")
@NullSource
```

## Empty parameter 
```java
@ParameterizedTest
@DisplayName("Null name check")
@EmptySource
```
## Empty and null 
two runs
```java
@ParameterizedTest
@DisplayName("Empty and null name check")
@NullAndEmptySource
```

## CSV source
```java
@ParameterizedTest
@DisplayName("Csv")
@CsvSource({"Brian, Alford", "Amy, Cruz", "Raj, Chawanda"})
void nameTestcsv(String fname, String lname) {...}
```

## CSV file source
```java
@ParameterizedTest
@DisplayName("Csv File")
@CsvFileSource(resources = "/empnames.csv", numLinesToSkip = 1)
```

## Method source
```java
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
```