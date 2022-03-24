### Wikipedia Search Automation Tests


#### ****About****

The goal of this project is to test wikipedia's search page content using cucumber BDD framework

#### **Prerequisites**

- Java 1.8+
- Maven 3.3.3+ installed and available on your PATH 
- Chrome/Firefox browser installed

#### **Instructions**

Clone the repo:

`$ git clone https://github.com/mshafea/wikipedia-search-tests.git`

Run the tests from the command line with:

`$ mvn test verify`

By default, tests are run on chrome browser on headless mode

To change the browser,you can do it by updating the variable in "data.properties" file (e.g firefox) 

#### **Test Reports**

Generated test reports after executing the tests can be accessed under target/cucumber-html-reports folder