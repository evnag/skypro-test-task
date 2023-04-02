# About

This Java Spring test project is dedicated to creating a server application for a sock warehouse. The application accepts http requests from the interface, processes them and provides a response. The main functions of the application include accounting for the arrival and vacation of socks.

The external interface of the application is presented by Swagger and is available at http://localhost:8080/swagger-ui/index.html#

The application is based on the Spring(Boot) Framework;
PostgreSQL is used to store system data. Database schema:
Liquibase is used for versioning the database schema

The storekeeper has the ability to:
- take into account the incomes and outcomes of socks;
- find out the total number of socks of a certain color and composition at a given time.

## Technologies used:
- Java 11
- Spring Boot/Web
- PostgreSQL
- Liquibase
- Swagger
