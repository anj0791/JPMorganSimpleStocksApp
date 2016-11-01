# JPMorganSimpleStocksApp
This is a console based interactive application. It continuously displays a Stocks Dashboard of stocks and their various values. It prompts the user to enter trade details, records the trade and recalculates stock prices, index, etc. The application has a fixed set of stocks which are maintained in an in memory database (a Map). The in memory database is updated when a stock is traded. The application ends when user chooses to do so.
#Requirements
Provide working source code that will
a.	For a given stock, 
    i.	calculate the dividend yield
   ii.	calculate the P/E Ratio
  iii.	record a trade, with timestamp, quantity of shares, buy or sell indicator and price
   iv.	Calculate Stock Price based on trades recorded in past 15 minutes
b.	Calculate the GBCE All Share Index using the geometric mean of prices for all stocks

#Constraints & Notes
1.	Written in one of these languages:
    •	Java, C#, C++, Python
2.	No database or GUI is required, all data need only be held in memory
3.	Formulas and data provided are simplified representations for the purpose of this exercise

#High Level Technology stack used
1.	Java version: 1.8.0_71
2.	Apache Maven 3.3.9 
  Maven is preferred over Ant.  Maven is a software project management and comprehension tool. Based on the concept of a project    object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information. (https://maven.apache.org/).
3.	slf4j-log4j12  ----- version 1.7.21
  The Simple Logging Facade for Java (SLF4J) serves as a simple facade or abstraction for various logging frameworks (e.g. java.util.logging, logback, log4j) allowing the end user to plug in the desired logging framework at deployment time. (http://www.slf4j.org/)
4.	TestNG 6.8 --- for automated unit tests
  TestNG is a testing framework inspired from JUnit and NUnit but introducing some new functionalities that make it more powerful and easier to use. (http://testng.org/doc/index.html)
5.	Jacoco 0.7.7.201606060606 ---- for generating unit test coverage reports
  JaCoCo is a free code coverage library for Java (http://www.eclemma.org/jacoco/)
Detailed stack can be seen on the project information site, described in the section ‘Project information site’

#Pre-requite to run the application
  You need to have Java 8 and Maven 3.x installed to execute this application

#How to run the application and Tests
1. Running on Concole
  a. Running application
    Change to the target directory (/simple-stocks/target) and run the command "java -jar simple-stocks-0.0.1-SNAPSHOT-jar-with-dependencies.jar"
    This jar has all the dependencies packaged. The package can be created by running the command 'mvn package' and the project root directory
    b. Running the Tests
    Change to the project root directory and run the command 'mvn clean test'
    (Tests for this application are covering the core functionality. The utilities and methods that interact with console are not covered by unit tests)
2. Running from an IDE such as Eclipse
  a. Import the application code into an IDE such as Eclipse.
  b. You may run the application as a java application
  c. You may run the tests using Maven plugin

#Project Information Site
1.	Project information site can be found under /target/site directory (you may create the site youself by running ‘mvn site’ at the project directory). You may open index.html to start navigating. 
2. Jacoco code coverage site can be found under /target/site/jacoco directory. You may browse the site from index.html 
