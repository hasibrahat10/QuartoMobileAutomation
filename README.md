# QuartoLab - A SAAS Based Android Application
[![](https://img.shields.io/badge/Java-1.8.0-brightgreen)]() [![](https://img.shields.io/badge/Maven-3.8.1-brightgreen)]()  [![](https://img.shields.io/badge/Cucumber-3.1.2-brightgreen)]() [![](https://img.shields.io/badge/IntelliJ%20IDEA-2019.3-brightgreen)]()

### Description

This is a Software Application testing automation project based on Java. 
Apache Maven is used to building and run the
project and Cucumber-Gherkin is used for writing test scenarios and reporting. 
Web Apps: https://quartolab.com/ & 
Available in PlayStore(https://play.google.com/store/apps/details?id=com.redlime.quarto&hl=en)
and App store

### Setup Project

First of all, you need to clone the project from Github. Use the following command

```commandline
git clone https://github.com/hasibrahat10/QuartoMobileAutomation.git
```

### Add More Features and Scenarios

- Go to project features package `src/test/java/features`
- Create a new file `Login.feature`
- Add a new scenario in the file
- Example

```gherkin
    @login
    Feature: Login Quarto

    @test-1
    Scenario: I want to login with valid user info
      Then I have entered the user login info
      And I tap on login button
      And I observed the text "Good Morning"
```


- Go to project stepDefinitions package `src/test/java/steps`
- Create a new file `LoginSteps.java`
- Add necessary feature steps in the file
- Example:

```java
    public class LoginSteps{
    @Then("^I have entered the user login info$")
    public void i_have_entered_the_user_login_info() {
    }
    @Then("^I tap on login button$")
    public void i_tap_on_login_button() {
    }
    @And("^I observed the text \"([^\"]*)\"$")
    public void iObservedTheText(String expectedText) {
    }
}
```

- Write code inside the steps method

### Before Run

- Open `FileHelper.java` file from `src/test/java/helper/FileHelper.java`
- Check the screenshot and dynamic directory path variable
- If needed to develop different method for the further uses
- Example:

```java
    public class FileHelper{
    public static String USER_DIR = System.getProperty("user.dir");
    public static final String SCREENSHOT_DIR = USER_DIR + "/target/screenshot/";
    public static String DATA_FOLDER = USER_DIR + "/data/";
    
}
```


- Open `testRun.java` file from `src/test/java/testRunner/testRun.java`
- Add the tests tag those tests will execute
- To run multiple tag same time use comma among the tags
- To skip a test tag use `~` before the tag as `~@test-1`
- Example:


 ```java
        @CucumberOptions(
                features = {"src/test/java/com/features"},
                glue = {"com/steps"},
                tags = {"@login-valid, @contact-us, ~@login-failed"},
                plugin = {"pretty", "html:test-output"}
        )

        @RunWith(Cucumber.class)
        public class CucumberRunner {
        
        }
```


### Local run

- Go to testRunner package and open this `testRun.java` file
- Right-click on the file
- Select `Run 'testRunner'` option
- Then click on it
- It will run all the test that mention in the tags (`tags = {"@login-valid, @contact-us, ~@login-failed"}`)

##### Maven run

- Apache Maven should install on your local machine
- Open terminal
- Go to root directory
- Run command `mvn clean install `
- Run a single test `mvn install -Dcucumber.options="--tags @login-valid"`

### Reports and Logs

- Project reports are generated inside the directory `test-output/index.html`
- Cucumber html reports `test-output/index.html`
- Then Click `index.html` right shift on the mouse
- Open in a browser

### Directory Structure

``` bash
.
├── drivers
│   └── chromedriver_win32
├── images
|   ├──qdev.PNG
|   ├──test.jpg
|   ├──testimages.jpg
│   └── www.PNG
├── src
│   └── test
│       ├── java
│       │    ├── features
│       │    │   ├── Login.feature
│       │    │   ├── PublishDocument.feature
│       │    │   ├── Add More Featutre
│       │    │   └── Add More Featutre
│       │    ├── helper
│       │    │   ├── FileHelper.java
│       │    │   ├── Add More Helper
│       │    │   ├── Add More Helper
│       │    ├── pages
│       │    │   ├── LoginPage.java
|       |    |   ├── PublishDocumentPage.java
│       │    ├── stepDefinitions
│       │    │   ├── LoginSteps.java
│       │    │   ├── Hooks.java
│       │    │   ├── PublishDocumentSteps.java
│       │    │   └── TestSetupPaage
│       │    ├── testRunner
│       │    │   └── TestRunner.java
├── videos
|   ├──vide1.mp4           
├── pom.xml
└── README.md
```

#### Questions

If you have trouble getting set up, or if you have any questions, please don't hesitate to reach out to me. I'm happy to
help!

[![](https://img.shields.io/badge/Email--Address%3A-hasancse10%40gmail.com-blue)]()