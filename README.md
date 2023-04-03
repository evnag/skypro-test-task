# About

This Java Spring test project is dedicated to creating a server application for a sock warehouse. The application accepts http requests from the interface, processes them and provides a response. The main functions of the application include accounting for the arrival and vacation of socks.

The application is based on the Spring(Boot) Framework.
PostgreSQL is used to store system data.
Liquibase is used for versioning the database schema.
Database schema: https://github.com/evnag/skypro-test-task/wiki

The storekeeper has the ability to:
- take into account the incomes and outcomes of socks;
- get a list of all incomes and outcomes;
- get a list of all incomes and outcomes on a specific date;
- find out the total number of socks of a certain color and composition at a given time.

## Technologies used:
- Java 11
- Spring Boot/Web
- PostgreSQL
- Liquibase
- Swagger

## How to use
Build project with:
- mvn install -DskipTests

From the root of the project, run the command: 
- docker-compose up -d

The external interface of the application is presented by Swagger and is available at:
- http://localhost:8080/swagger-ui/index.html
