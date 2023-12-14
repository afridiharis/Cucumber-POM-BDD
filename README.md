# Cucumber-POM-BDD

Proof of Concept for purple.ai

Java hybrid maven framework designed with Cucumber and POM design pattern with TestNG/JUnit parallel test execution

## Folder structure:
- `src/main/java`: Java Page Object Model (POM) source code, along with utilities
- `src/test/java`: Test source code with step definitions
- `src/test/resources`: Feature files with sample scenarios of purple.ai
- config: Configuration files for browser and cucumber
- `com.qa.util`: Utility classes for waits and config reading

**Libraries and tools**:
- Cucumber: Behavior-driven development library
- Selenium WebDriver: Browser automation
- Page Object Model (POM) design pattern
- Logging, Assertions, and Test Runners in `JUnit` and Parallel execution in `TestNG` and `surefire` maven plugin

## Setup

- **Install Maven dependencies**: 
```console
mvn clean install
```

## To Run tests:

1. ### **Using TestNG parallel test runner**: ###
_This is for running all the scenarios at the same time_
`mvn test` or `mvn verify`

2. ### **Using JUnit test runner**: ###
_This is for individual scenarios run, run the file as JUnit Configuration_ 

`/src/test/java/testrunners/JUnitTestRunner.java`
