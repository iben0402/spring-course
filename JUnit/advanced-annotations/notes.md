# Advanced annotations
## Test name
```java
@Test
@DisplayName("Brand name check")
void brandNameTest() {
    assertEquals("Sony", tv.getBrandName(), "Brand Name Test");
}
```

## Disable a test
```java
@Disabled
@Test
...
```
## Enable/Disable test depending on OS
```java
@Test
@DisplayName("Brand name check")
@EnabledOnOs(OS.MAC) // @DisabledOnOs(OS.MAC)
void brandNameTest() {
    assertEquals("Sony", tv.getBrandName(), "Brand Name Test");
}
```
## Disable/Enable test based on JRE
```java
@EnabledOnJre(JRE.JAVA_17)
@DisabledOnJre(JRE.JAVA_9)
```
## Disable/Enable on system property
```java
@Test
@DisabledIfSystemProperty(named = "os.arch", matches = "x86_64")
void priceTest() {
    assertEquals(800.0, tv.getPrice());
}
```

## Disable/Enable on EnvironmentVariable
```java
@EnabledIfEnvironmentVariable(named = "PWD", matches = ".*junit.*")
```

## Disable/Enable on JreRange
```java
DisabledForJreRange(min = JRE.JAVA_14, max = JRE.JAVA_17)
```
it can be only one 
## Retention
```java
@Retention(RetentionPolicy.RUNTIME)

## Custom conditions
```java
@Retention(RetentionPolicy.RUNTIME)
@Test
@EnabledForJreRange(min = JRE.JAVA_9)
@EnabledOnOs(OS.WINDOWS)
@DisabledIfSystemProperty(named = "os.arch", matches = "x86_64")
public @interface MyCustomTestConditions {
}

@MyCustomTestConditions
@DisplayName("Price Check")
void priceTest() {
    assertEquals(800.0, tv.getPrice());
}
```

## Ordering tests
```java
@TestMethodOrder(MethodOrderer.MethodName.class)
public class ProductTest {
}
```

```java
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductTest {}

@Test
@Order(2)
public test() {}
```
## Concurrent Tests
1. add test->resources folder
2. add junit-platform.properties file
3. put ```junit.jupiter.execution.parallel.enabled= true``` inside of it
4. add class annotation ```@Execution(ExecutionMode.CONCURRENT)```

## Timeout of test
```java
@Timeout(3)
```
test will fail after 3 seconds