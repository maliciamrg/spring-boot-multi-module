# Spring Boot Multi-Module Maven Project with DDD
Spring Boot &amp; Multi-Module Maven Project following DDD Methodology.

Ref: https://dzone.com/articles/ddd-spring-boot-multi-module-maven-project

- Child Module application is where your @SpringBootApplication, the Main class, will reside.
- The controller houses the controller classes that provide REST end-points or similar stuff. This is also the module that houses all the DTOs that will be exposed to the outside world as JSON output from the REST end-points.
- The domain is where your aggregate, entities, value-objects live along with Service and Repository Interfaces.
- Service is where your Service implementations live.
- The repository is where your Repository implementations live.

#Deploying Spring Boot Microservice to Docker

Ref : https://www.javainuse.com/devOps/docker/docker-jar

Add metrics monitoring
- http://localhost:8080/actuator
- http://localhost:8080/actuator/health
- http://localhost:8080/actuator/prometheus

# Modules
In a modularized Spring Boot application with separate modules for controller, domain, repository, and service layers, you would typically organize the dependencies in a way that promotes a clean and maintainable architecture. Here's a suggested dependency flow:

- Domain Module:

The domain module should define the core entities and business logic of your application.
It should not have any dependencies on other modules.

- Repository Module:

The repository module depends on the domain module since it deals with data access and persistence for the entities defined in the domain.
It should include Spring Data JPA or any other data access technology you're using.
The repository module should not have dependencies on the service or controller modules.

- Service Module:

The service module depends on both the domain and repository modules.
It contains the business logic and services that orchestrate interactions between the domain entities and the data access layer.
The service module should not have dependencies on the controller module.

- Controller Module:

The controller module depends on the service module.
It defines the API endpoints and handles HTTP requests.
The controller module should not have dependencies on the repository module.

Here's a simplified representation of the dependencies:

```
domain
↓
repository ← domain
↓
service ← domain, repository
↓
controller ← service
```

This way, each layer only depends on the layers below it, promoting a clear separation of concerns and making it easier to maintain and test each module independently. Additionally, this modular structure allows you to replace or modify one layer without affecting the others.