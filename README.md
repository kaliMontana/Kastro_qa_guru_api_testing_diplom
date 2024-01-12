# Kastro_qa_guru_api_testing_diplom
Local start:
gradle clean test -DtestTag=api -DLauncher=Local allureServe
Remote start:
gradle clean test -DtestTag=api -DLauncher=Remote

# Project to automate testing the Api service of youtube

## Content

* <a href="#link-technologies-and-tools">Technologies and tools</a>
* <a href="#link-implemented-tests">Implemented tests</a>
* <a href="#link-starting-test">Starting test </a>
## Technologies and tools

<p align="center">
<img width="6%" src="images/logos/Java.svg">
<img width="6%" src="images/logos/Intelij_IDEA.svg">
<img width="6%" src="images/logos/Gradle.svg">
<img width="6%" src="images/logos/JUnit5.svg">
<img width="6%" src="images/logos/Rest_assured.png">
<img width="6%" src="images/logos/Jenkins.svg">
<img width="6%" src="images/logos/Selenide.svg">
<img width="6%" src="images/logos/Selenoid.svg">
<img width="6%" src="images/logos/GitHub.svg">
<img width="6%" src="images/logos/Allure_Report.svg">
<img width="6%" src="images/logos/Telegram.svg">
</p>

In this project, autotests are written in Java using Rest Assured for api requests and Selenide for UI.

JUnit 5 is used as a unit testing library.

Gradle is used to build the project automatically.

Rest Assured is used to do request to server

Selenide is used for interaction with UI.

Selenoid launches browsers in Docker containers.

Allure Report generates a test run report.

Jenkins is running tests.

After the run is completed, notifications are sent using the bot in Telegram.

## Implemented tests
- [x] Checking that the video information in the UI is the same as the information obtained through the request API

## Starting test
<details>
<summary>Starting test from Idea console</summary>

### Starting tests Locally

* ```gradle clean test -DtestTag=${TAGTEST} -DLauncher=Local allureServe```
* ```gradle clean test -DtestTag=api -DLauncher=Local allureServe```

### Starting tests remotely in Selenoid
* ```gradle clean test -DtestTag=${TAGTEST} -DLauncher=Remote allureServe```
* ```gradle clean test -DtestTag=api -DLauncher=Remote```
</details>

#### After passing the tests, the result is displayed in Allure Report

## <img width="6%" title="Allure" src="images/logo/Allure_Report.svg"> Example of Allure Report

## Allure report for each UI test includes a screenshot, log, html page and a video of the test being passing

<p><img src="images/screenshots/allure_report.png" alt="allure report"/></p>