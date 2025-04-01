# Test Setup for LinqApp Automation

## 🛠️ Chosen Tool: Selenium (Java)

### 🔹 Why Selenium?
- **Cross-browser support**: Works with Chrome, Firefox, Edge, etc.
- **Flexible automation**: Can handle UI, functional, and regression testing.
- **Supports languages**: Java.
- **Can be integrated with TestNG, JUnit, and CI/CD tools like GitHub Actions.**

---

## ⚙️ Setup Instructions

### 1️⃣ **Prerequisites**
Ensure you have the following installed:
- **Java (JDK 17)** → [Download Here](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- **Maven** → [Download Here](https://maven.apache.org/install.html)
- **Chrome WebDriver** (or other browser drivers) → [Download Here](https://chromedriver.chromium.org/downloads)
- **IDE**: IntelliJ IDEA 

---

### 2️⃣ **Project Setup**
#### **Step 1: Create a Maven Project**
Step 1: Create a Maven Project
Step 2: Add Required Dependencies
step 3: 📂 Project Structure
linq-tests
│── src
│   ├── main
│   │   ├── java
│   │   │   ├── BasePage
│   │   │   │   ├── Base.java
│   │   │   ├── Pages
│   │   │   │   ├── WelcomePage.java
│   │   │   ├── Utils
│   │   │   │   ├── TestIRetryAnalyzer
│   │   │   │   │   ├── MyRetry.java
│   │   │   │   ├── screenrecorder_screenshot
│   │   │   │   │   ├── ScreenRecorderUtil.java
│   │   │   │   │   ├── ScreenshotUtil.java
│   ├── test
│   │   ├── java
│   │   │   ├── test_home_page_logo
│   │   │   │   ├── TestHomePageLogo.java

step 4: Test Class: TestHomePageLogo
This test class verifies:
-Homepage Logo Visibility
-Homepage Title
-Background Color Validation (with retry and screenshot capturing)
-Email Feature Validation
step 5: Key Features in the Tests
✅ Uses TestNG for structured test execution
✅ Includes retry logic (MyRetry.class) for flaky tests
✅ Captures screenshots on failure using ScreenshotUtil
✅ Uses ScreenRecorderUtil to record test execution

step 5: How to Run the Tests?
1-Open a terminal inside your project directory.
2-Run the following Maven command:
mvn test
Alternatively, you can execute specific tests via testNGRunnerListener.xml or directly from your IDE.

step 5: 
Integrate with CI/CD (GitHub Actions)


