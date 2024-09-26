# Automation Framework for PHP Travels Demo Site

This project is an automation framework designed to test the PHP Travels demo site using Selenium, TestNG, Cucumber, and RestAssured. It supports both desktop and mobile testing and includes retry logic for failed tests.

## Project Structure

```
src
|-- main
|   |-- java
|   |   |-- config
|   |   |   |-- DriverFactory.java
|   |   |-- pages
|   |   |   |-- DemoPage.java
|   |   |   |-- LoginPage.java
|-- test
|   |-- java
|   |   |-- stepdefinitions
|   |   |   |-- DemoSteps.java
|   |   |   |-- LoginSteps.java
|   |   |-- runners
|   |   |   |-- TestRunner.java
|   |   |-- utils
|   |   |   |-- ApiUtils.java
|   |-- resources
|       |-- features
|           |-- Demo.feature
|-- testng.xml
|-- pom.xml
|-- .gitlab-ci.yml
|-- Dockerfile
```

## Test Explanation

This framework performs the following tests on the PHP Travels demo site:

1. **Mode Selection**: Accepts input to run tests in either desktop or mobile mode.
2. **Login Functionality**:
    - Clicks on the login button and verifies the login page opens in a new tab.
    - Checks that the title of the login page is "Login".
    - Verifies the presence of email and password fields.
3. **Link Verification**:
    - Switches back to the main demo tab and verifies successful navigation.
    - Retrieves all links from the page and checks their validity by making API calls.
4. **Retry Logic**: Any failed test will automatically retry up to 3 times.

## Prerequisites

Before running the tests, ensure you have the following installed:

- **Java 11 or higher**
- **Maven**
- **Docker** (optional, for containerized testing)

## How to Run Tests

1. **Clone the repository**:

   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```

2. **Navigate to the project directory**:

   ```bash
   cd your-project-directory
   ```

3. **Install the dependencies**:

   ```bash
   mvn clean install
   ```

4. **Run the tests**:

   You can run the tests using Maven:

   ```bash
   mvn test -Dmode="mobile/desktop"
   ```

5. **View Test Reports**:

   After running the tests, you can find the HTML report at:

   ```
   target/cucumber-html-report/index.html
   ```

## How to Run Docker

This project can also be run in a Docker container for a consistent testing environment.

1. **Build the Docker image**:

   In the project root directory, create a `Dockerfile` if not already present, and add the following content:

   ```dockerfile
   FROM maven:3.8.4-openjdk-11 AS build
   WORKDIR /app
   COPY . .
   RUN mvn clean install

   FROM openjdk:11-jre
   WORKDIR /app
   COPY --from=build /app/target/*.jar app.jar
   ENTRYPOINT ["java", "-jar", "app.jar"]
   ```

   Build the Docker image:

   ```bash
   docker build -t php-travels-automation .
   ```

2. **Run the Docker container**:

   ```bash
   docker run --rm php-travels-automation
   ```

## Conclusion

This automation framework provides a comprehensive solution for testing the PHP Travels demo site. The use of Selenium for browser automation, TestNG for test management, Cucumber for BDD-style tests, and RestAssured for API validation ensures robust and maintainable test coverage.
