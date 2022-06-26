# Getting Started

### Reference Documentation
How To Build

* Clone or unzip the project in the local drive
* Import the project in the IDE Eclipse or Intellij
* Do Maven update of the project 
* Do Maven Build using the command **mvn clean install**.

### How to Run
The following guides illustrate how to run the project and access swagger url:

* Once the build is success Go to CreditCardProcessApplication.java class and run as Java Application , This starts the spring boot embedded tomcat application server or we can use maven command **mvn spring-boot:run**

* The server runs on the default port 8080 , If port already in use you can change the port number in **application.properties** file in src/main/resources

* Once the server is up and running we can access the swagger url as follows :-
**http://localhost:8080/service/swagger-ui/index.html**

* To access the H2 database url use the below url :-
**http://localhost:8080/service/h2-console/**

### How to Test EndPoint 

* To Test Save API i.e. **http://localhost:8080/service/card-details** use the sample json request :-

{
  "name": "Avinash",
  "cardNumber": "68798099879778897",
  "balance": 0,
  "limit": 1000
}

* To Test the Fetch Api use the below url :-
**http://localhost:8080/service/fetch-cards**





