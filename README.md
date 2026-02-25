# Data Driven Testing with Java, Selenium, TestNG & Excel

A complete **automation framework** for **data-driven testing** using **Selenium WebDriver**, **TestNG**, **Apache POI** (for Excel data), and **Page Object Model (POM)**.

This project demonstrates how to perform login automation with multiple test data from Excel sheet in a clean, maintainable, and scalable way.

![Java](https://img.shields.io/badge/Java-17-red?style=for-the-badge&logo=java&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-4.19.0-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-7.10.2-orange?style=for-the-badge&logo=testng&logoColor=white)
![Apache POI](https://img.shields.io/badge/Apache_POI-5.3.0-blue?style=for-the-badge&logo=apache&logoColor=white)

## ✨ Features

- Data-driven testing using **Excel** (username, password, expected result)
- **Page Object Model (POM)** for clean code separation
- **TestNG DataProvider** for efficient data feeding
- **Apache POI** for reading Excel data
- **Explicit waits** & robust element locators
- **Login success/failure verification** (URL + error message)
- Modular structure: pages, runners, resources, utils
- Easy to extend for more test cases/pages

## 📂 Project Structure
```
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pages/               # Page Objects
│   └── test/
│       ├── java/
│       │   ├── base/                # BaseTest (driver setup/teardown)
│       │   ├── pages/               # Page classes
│       │   ├── runners/             # Test runners (LoginTestRunner.java)
│       │   └── utils/               # Utilities (ExcelUtils.java)
│       └── resources/
│           └── test_data.xlsx       # Test data file
├── pom.xml                          # Maven dependencies
├── .gitignore
└── README.md
```

## 🚀 Quick Start

### 1. Prerequisites
- Java 17+
- Maven 3.6+
- Chrome browser (for Selenium)

### 2. Clone & Install
```bash
git clone https://github.com/yourusername/DataDrivenBYExcelWithJava_Selenium_TestNg.git
cd DataDrivenBYExcelWithJava_Selenium_TestNg
mvn clean install
```
## Run Tests
```
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=LoginTestRunner

# Run with suite (if you have testng.xml)
mvn test -DsuiteXmlFile=testng.xml
```
 ##  🛠️Tech Stack

- Java 17
- Selenium WebDriver 4.19.0
- TestNG 7.10.2
- Apache POI 5.3.0 (Excel handling)
- Maven (build tool)
- Page Object Model (design pattern)
- DataProvider (TestNG feature for data-driven)

 ##  🔧 How It Works

- ExcelUtils.java → Reads data from test_data.xlsx
- LoginPage.java → POM class for login actions
- LoginTestRunner.java → Test class with @DataProvider
- Test iterates over each row → performs login → verifies result

 ##  🤝 Contributing

- Fork the repo
- Create feature branch (git checkout -b feature/add-new-page)
- Commit changes (git commit -m 'Add new page object')
- Push to branch (git push origin feature/add-new-page)
- Open Pull Request

 ##  📄 License
- MIT License
