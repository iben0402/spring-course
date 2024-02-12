# Introduction to the JUnit Framework
## Testing with JUnit
An open-source unit testing framework for the Java programming language that greatly simplifies a developer's ability to write and execute repeatable tests
- Automates testing by allowing test cases to be defined programmatically
- Includes several interfaces to verify that a unit behaves in the desired manner
- Is ideal for developers who practice test-driven development

### Features
- Built-in test engine to discover and execute tests
- A variety of methods to execute code and verify output (eg. assert statements)
- Several annotations to identify tests, set conditions for execution, etc.
- Interfaces to simplify parametrization of tests
- Numerous methods to structure test executions
- Its own console launcher to run tests and process the results
- Integration with build-automation tools, such as Apache Maven and Gradle
- Interfaces to process parameters, run tests concurrently, etc.

## Example JUnit test
```java
@Test
public void validateBalance() {
    assertTrue(accountDetails.getBalance() >= 0);
}
```
**assertTrue** - method provided by JUnit. This method is used to check whether a certain condition is true. If it is, the test passes. If it's not, the test fails.

**@Test** - this annotation indicates that the method below should be treated as a test case.

## BeforeEach and AfterEach annotations
- **@BeforeEach** - This annotation is used to specify that the method should be executed before each test in the current test class. It's typically used for setup routines that are needed for every test.
```java
@BeforeEach
public void setup() {
    // setup code here
}
```
- **@AfterEach** - This annotation is used to specify that the method should be executed after each test in the current test class. It's typically used for cleanup routines that are needed after every test.
```java
@AfterEach
public void cleanup() {
    // cleanup code here
}
```

## BeforeAll and AfterAll annotations
- **@BeforeAll** - This annotation is used to specify that the method should be executed once before all tests in the current test class. It's typically used for setup routines that are needed only once, not before each test.
```java
@BeforeAll
public static void setupAll() {
    // setup code here
}
```
- **@AfterAll** - This annotation is used to specify that the method should be executed once after all tests in the current test class have been run. It's typically used for cleanup routines that are needed only once, not after each test.
```java
@AfterAll
public static void cleanupAll() {
    // cleanup code here
}
```