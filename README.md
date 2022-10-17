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

