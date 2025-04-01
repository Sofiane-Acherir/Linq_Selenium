# linq-project

## Overview
Linq-project is an automated testing framework for web applications, built using **Selenium WebDriver**, **TestNG**, and **Maven**. It is designed to provide robust and efficient testing capabilities with integrated reporting and logging mechanisms.

## Prerequisites
Before running the project, ensure you have the following installed:

- **Java 17** or later
- **Maven** (latest version recommended)
- **Git**
- **Google Chrome** / **Firefox** / **Edge** (for browser testing)
- **IntelliJ IDEA** / **VS Code** (for development, optional)

## Installation
Clone the repository and navigate to the project directory:

```sh
$ git clone https://github.com/Sofiane-Acherir/Linq_selenium.git
$ cd linq-project
```

Install dependencies:

```sh
$ mvn clean install
```

## Project Structure
```
linq-project/
│-- src/
│   ├── main/java/
│   │   ├── Base/                   # Base classes (BasePage, WebDriver setup)
│   │   ├── Pages/                  # Page Object Model classes
│   │   ├── Utils/                  # Utility classes (Reporting, Listeners, etc.)
│   │   ├── Deliverables/            # Documentation files
│   ├── test/java/
│   │   ├── test_home_page_logo/    # Test cases for homepage logo
│   ├── test/resources/             # TestNG runner XML files
│-- target/                         # Compiled output and test reports
│-- .gitignore                      # Git ignore file
│-- pom.xml                         # Maven configuration
│-- README.md                       # Project documentation
```

## Running Tests
You can execute test cases using Maven:

```sh
$ mvn test
```

For running a specific TestNG suite:

```sh
$ mvn test -DsuiteXmlFile=src/test/resources/LinqTestNGRunner.xml
```

## CI/CD with GitHub Actions
This project uses **GitHub Actions** for CI/CD. The workflow file (`.github/workflows/maven.yml`) automates the build and test execution on every push or pull request to the `main` branch.

## Reports & Logs
- **Extent Reports**: Located in `target/test-output`
- **Screenshots**: Captured on test failures and saved in `target/screenshots`
- **Test Recordings**: Video recordings of tests are saved in `target/test-recordings`

## Contributing
Contributions are welcome! Please follow these steps:
1. Fork the repository
2. Create a new branch (`feature-branch`)
3. Commit your changes
4. Push the branch and create a pull request

## License
This project is licensed under the MIT License. Feel free to use and modify it as needed.

---
### 🚀 Happy Testing! 🚀


