# FlightBook Automation Framework

## Overview

FlightBook is a Selenium-Java automation framework developed to test a flight booking demo application.

The framework automates end-to-end scenarios including:

* Flight search
* Flight selection
* Passenger form submission
* Booking confirmation
* Form validations

It follows the **Page Object Model (POM)** design pattern for better maintainability and scalability.

---

## Application Under Test

URL: https://blazedemo.com

---

## Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* WebDriverManager
* ExtentReports

---

## 📂 Project Structure

```text
src/main/java
  ├── base        → BaseTest, BasePage
  ├── pages       → Page classes (HomePage, FlightPage, PurchasePage, ConfirmationPage)
  ├── utils       → ConfigReader, WaitUtils

src/test/java
  ├── tests       → Test classes

src/main/resources
  ├── config.properties

reports/
screenshots/
```

---

## Configuration

Edit `config.properties`:

```properties
browser=chrome
baseUrl=https://blazedemo.com
timeout=10
headless=false
```

---

## How to Run Tests

### Using Maven

```bash
mvn clean test
```

### Using TestNG

* Right-click `testng.xml`
* Run as TestNG Suite

---

## Test Modules

### 🔹 Module 1 – Flight Search

* Select departure & destination
* Verify flight listing
* Validate results for same city

### 🔹 Module 2 – Flight Selection

* Select flight
* Verify navigation to purchase page
* Validate flight details and price

### 🔹 Module 3 – Purchase Form

* Fill passenger details
* Submit form
* Verify confirmation page & booking ID

### 🔹 Module 4 – Route Variations

* Test multiple route combinations
* Validate result count and page title

### 🔹 Module 5 – Form Validations

* Empty field validation
* Invalid credit card validation
* Mandatory field checks

---

## Key Features

* Page Object Model (POM)
* WebDriverManager integration
* Explicit waits (no Thread.sleep)
* Config-driven framework
* Screenshot capture on failure
* ExtentReports HTML reporting

---

## Reporting

* ExtentReports generates HTML report after execution
* Screenshots captured automatically on failure

---

## Best Practices Followed

* No hardcoded values
* Reusable methods
* Clean separation of concerns
* Data-driven testing support

---

## Author
Katakamsetty Lakshmi Manasa
