
## Web Automation Framework

A robust Web Automation Framework built with Java, leveraging TestNG for test management and execution. The framework is integrated with LambdaTest to enable cloud-based cross-browser testing with seamless parallel execution support. Designed to improve scalability, efficiency, and maintainability of automated tests.


## Authors

- [@Tanmay](https://github.com/agashetanmay)
Email ID : agashetanmay@gmail.com

## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/agashetanmay)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/)



## 🚀 About Me
Hi, My name is Tanmay Agashe and i have a 5 years of experience in automation testing using technologies like selenium webdriver, rest assuard.
my major experties in java programming language.


## Prerequisites

- Install **Java** (JDK 8 or higher) and make sure JAVA is installed and JAVA_HOME env variable is set.
- Install **Maven** and ensure it is added to system path.
- Setup a LambdaTest account (get username & access key)

## Key Features

- Java + TestNG for structured test development and execution.

- LambdaTest Integration for cloud-based, cross-browser, and cross-platform testing.

- Parallel Execution Support for faster test runs.

- Scalable Design for adding new test cases and browser configurations easily.

- Reporting & Logging with TestNG reports along with extent report and customizable log output.

- CI/CD Ready → Can be integrated into Jenkins, GitHub Actions, or other CI/CD pipelines.

## Tech Stack
- Programming Language: Java
- Testing Framework: TestNG
- Cloud Testing Platform: LambdaTest
- Build Tool: Maven
- Version Control: Git
- CI-CD Tool : Jenkins and github action



## Installation

- Clone the repository:
git clone https://github.com/yourusername/WebAutomationFramework.git
cd WebAutomationFramework

## Running Tests

Run test on chrome browser on local machine:

mvn test -DbrowserName=chrome -DisHeadless=false -DisLambdaTest=false -DtestSuiteFile=test.xml -X

## Reporting

- after execution a detail execution extent report generated at ./report.html

- Logs are available in the /logs/automation.log directory.

- Integration with LambdaTest provides detailed execution logs, video recordings, and screenshots.

## Integrated the project Github Actions

This automation framework is integrated with GitHub Actions.
The tests will be executed at 11:30PM IST every single day.

The reports will be archived in the gh-pages branch.
You can view the HTML reports at:

👉 https://agashetanmay.github.io/Web-Automation-framework/report.html


    
