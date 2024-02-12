# Assertions & Assumptions in JUnit
## ASSERTIONS
### AssertEquals() method
```java
@Test
void assertTest() {
    employee.adjustSalary(5000);
    assertEquals(5000, employee.getSalary());
}
```
### AssertTrue() method
```java
@Test
void roleTest() {
    assertTrue(firstEmployee.getRole().equals(secondEmployee.getRole()), "checks if both employees have the same role");
}
```

### AssertFalse() method
```java
@Test
void genderTest() {
    assertFalse(firstEmployee.getGender().equals(secondEmployee.getGender()), "checks if employees have different gender");
}
```

### AssertSame() method
```java
@Test
void copyTest() {
    Employee firstShallowCopy =firstEmployee;
    Employee firstSeparateCopy = new Employee(firstEmployee.getFirstName(), firstEmployee.getLastName(), firstEmployee.getId(), firstEmployee.getGender(), firstEmployee.getRole(), firstEmployee.getSalary(), firstEmployee.getType());
    assertSame(firstEmployee.getRole(), firstSeparateCopy.getRole()); //pass
    assertSame(firstEmployee, firstSeparateCopy); //fail
    assertSame(firstEmployee, firstShallowCopy); //pass
}
```
There is also AssertNotSame method

### Testing for Timeouts
```java
@Test
void durationTest() {
    assertTimeout(Duration.ofSeconds(5), () -> {
        firstEmployee.adjustSalary(2000);
    });
}
```
tests if the code is run within 5 seconds.

### Testing for null
```java
@Test
void nullTest() {
    assertNull(thirdEmployee);
}
```
AssertNotNull is also a method.

### Checking for exceptions
```java
@Test
void exceptionTest() {
    assertThrows(RuntimeException.class, ()-> {
        fourthEmployee.validateLastName();
    });
}
```
- validate last name throws a runtime exception on invalid last name
- We can check for a parent exception 

### AssertAll
```java
@Test
void testEmployee() {
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
```
groups asserts

### Comparing lists
```java
@Test
void projectsTest() {
    ArrayList<String> projects1 = new ArrayList<String>();
    projects1.add("aaa");
    projects1.add("bbb");
    projects1.add("ccc");

    assertIterableEquals(projects1, firstEmployee.getProjects());
}
```
## ASSUMPTIONS
### hour assumption
```java
@Test
void assumptionTest() {
    System.out.println("Current hour: " + gc.get(Calendar.HOUR_OF_DAY));
    Assumptions.assumeTrue(gc.get(Calendar.HOUR_OF_DAY) <20);

    employee.adjustSalary(5000);
    assertEquals(85000, employee.getSalary());
    
    System.out.println("The assumption was satisfied and the test was run");
}
```
- if the hour of the day is before 20 the test will run, if its not - it will be ignored
- we have **assumeTrue**, **assumeFalse**, **assumingThat** methods.
```java
@Test
void assumingThatTest() {
    System.out.println("Current hour: " + gc .get (Calendar.HOUR_OF_DAY));
    
    Assumptions. assumingThat (gc.get(Calendar.HOUR_OF_DAY) < 20,
            () -> {employee.adjustSalary(5000) ;
                assertEquals (85000, employee.getSalary());
                System.out.println("\nThe assumption was satisfied and the test was run.");});
}
```