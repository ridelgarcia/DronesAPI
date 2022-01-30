# Spring Boot "Drones API" Example Project

This is a sample Java / Maven / Spring Boot (version 1.5.6) application that can be used as a starter for creating a microservice complete with built-in health check, metrics and much more. I hope it helps you.

## How to Run 

This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the ```java -jar``` command.

* Clone this repository 
* Make sure you are using JDK 17.0.2 and Maven 3.8.3
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by this method:
```
       
        mvn spring-boot:run 
```
* Check the stdout to make sure no exceptions are thrown

Once the application runs you should see something like this

```
2022-01-29 10:42:01.475 DEBUG Tauro --- [   scheduling-1] o.s.o.j.JpaTransactionManager            : Initiating transaction commit
2022-01-29 10:42:01.475 DEBUG Tauro --- [   scheduling-1] o.s.o.j.JpaTransactionManager            : Committing JPA transaction on EntityManager [SessionImpl(1021347900<open>)]
2022-01-29 10:42:01.476 DEBUG Tauro --- [   scheduling-1] o.h.e.t.i.TransactionImpl                : committing
2022-01-29 10:42:01.477 DEBUG Tauro --- [   scheduling-1] o.s.j.d.DataSourceUtils                  : Resetting read-only flag of JDBC Connection [HikariProxyConnection@1856536019 wrapping conn0: url=jdbc:h2:mem:dronesdb user=SA]
2022-01-29 10:42:01.477 DEBUG Tauro --- [   scheduling-1] o.s.o.j.JpaTransactionManager            : Closing JPA EntityManager [SessionImpl(1021347900<open>)] after transaction
```
## Swagger API Documentation

You can access the API documentation by typing in a web browser:

http://localhost:8080/swagger-ui.html

## About the Service

The service is just a simple drones review REST service. It uses an in-memory database (H2) to store the data.  If your database connection properties work, you can call some REST endpoints defined in ```com.drones.dronesapi.dronesapi.Controller.DroneController``` on **port 8080**. (see below)


Here is what this little application demonstrates: 

* Full integration with the latest **Spring** Framework: inversion of control, dependency injection, etc.

* Writing a RESTful service using annotation: supports both XML and JSON request / response; simply use desired ``Accept`` header in your request
* Exception mapping from application exceptions to the right HTTP response with exception details in the body
* *Spring Data* Integration with JPA/Hibernate with just a few lines of configuration and familiar annotations. 
* Automatic CRUD functionality against the data source using Spring *Repository* pattern


Here are some endpoints you can call:

### Create a drone

```
PUT /drone/addDrone
Accept: application/json
Content-Type: application/json

{
    "id":0,
    "serialNumber":"E34FF0C",
    "model":{
        "id":1,
        "droneModel":"Lightweight"
    },
    "weightLimit":500,
    "batteryCapacity":75,
    "state":{
        "id":1,
        "droneState":"IDLE"
    }
}

RESPONSE: HTTP 200 

```

### Retrieve a list of drones

```
GET /drone/getAll
Accept: application/json
Content-Type: application/json

Response: HTTP 200
Content: object 
```

### Update a drone
```
POST /drone/modifyDrone
Accept: application/json
Content-Type: application/json

{
    "id":1,
    "serialNumber":"E34FF0C2F",
    "model":{
        "id":1,
        "droneModel":"Lightweight"
    },
    "weightLimit":500,
    "batteryCapacity":75,
    "state":{
        "id":1,
        "droneState":"IDLE"
    }
}

Response: HTTP 200
Content: 
 
{
    "id":1,
    "serialNumber":"E34FF0C2F",
    "model":{
        "id":1,
        "droneModel":"Lightweight"
    },
    "weightLimit":500,
    "batteryCapacity":75,
    "state":{
        "id":1,
        "droneState":"IDLE"
    }
}

```

# About Spring Boot

Spring Boot is an "opinionated" application bootstrapping framework that makes it easy to create new RESTful services (among other types of applications). It provides many of the usual Spring facilities that can be configured easily usually without any XML. In addition to easy set up of Spring Controllers, Spring Data, etc. Spring Boot comes with the Actuator module that gives the application the following endpoints helpful in monitoring and operating the service:


### To view your H2 in-memory datbase

The 'dronesdb' profile runs on H2 in-memory database. To view and query the database you can browse to http://localhost:8080/h2-ui. Default username is 'sa' with a blank password. Make sure you disable this in your production profiles. For more, see https://goo.gl/U8m62X

# Questions and Comments: rmora900121@gmail.com