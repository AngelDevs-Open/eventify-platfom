# Getting Started 

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.0/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.5.0/maven-plugin/build-image.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.5.0/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.5.0/reference/using/devtools.html)
* [Validation](https://docs.spring.io/spring-boot/3.5.0/reference/io/validation.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.5.0/reference/web/servlet.html)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the
parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.


# Planning Bounded Context

The **Planning Bounded Context** is responsible for managing and planning social events within the Eventify platform. This context handles the complete lifecycle of social events, from creation to completion.

## Overview

The Planning bounded context manages social events and their associated quotations. It currently includes Social Events management and Quotes.

### Main Responsibilities:

- Complete lifecycle management of social events
- Event status control (Active, Pending, Cancelled, Completed)
- Association of events with their organizers
- Temporal and location planning of events
- Integration with the quotation system

## Architecture

This context follows **Domain Driven Design (DDD)** and **Clean Architecture** principles, implementing the **CQRS (Command Query Responsibility Segregation)** pattern to separate write and read operations.

The architecture is organized into four main layers:

- **Domain Layer**: Contains business logic, aggregates, value objects, commands, and queries
- **Application Layer**: Implements use cases through application services
- **Infrastructure Layer**: Handles data persistence and external communication
- **Interface Layer**: Exposes functionalities through REST APIs

## Aggregates

### SocialEvent

`SocialEvent` is the main aggregate root of this bounded context. It represents a social event in the system and encapsulates all business logic related to event planning.

**Main Attributes:**

- Unique event identifier
- Descriptive event title
- Scheduled date for execution
- Location where it will take place
- Organizer client name
- Current event status

**Associated Value Objects:**

- `SocialEventTitle`: Encapsulates the event title with corresponding validations
- `SocialEventDate`: Manages the event date with business rules (cannot be in the past)
- `Place`: Represents the event location
- `CustomerName`: Organizer client name with validations
- `SocialEventStatus`: Current event status
- `StatusType`: Enumeration defining possible event states

## Use Cases

### Command Operations (Write)

The system implements the following commands to modify event state:

- **Create Social Event**: Allows registering a new event in the system with all its characteristics
- **Update Event**: Modification of existing event details
- **Delete Event**: Complete removal of an event from the system
- **Delete Multiple Events**: Batch operation to remove several events
- **Update Status**: Specific change of an event's status

### Query Operations (Read)

For information retrieval, the system offers the following queries:

- **Get All Events**: Complete listing of events in the system
- **Search by Status**: Event filtering according to their current status
- **Search by Title**: Event location by complete or partial title
- **Search by Organizer**: Retrieval of events associated with a specific client

## REST API

The bounded context exposes its functionalities through two main REST controllers:

### SocialEventsController

Main controller that handles basic CRUD operations on social events. Provides endpoints to create, read, update, and delete events, as well as specialized searches by status and title.

### CustomerSocialEventsController

Controller specialized in event management from the organizer client's perspective. Allows querying all events associated with a specific client.

## Persistence Configuration

The context uses **Spring Data JPA** with **MySQL** as the main database. The configuration implements the **Repository pattern** for data access, using Spring Data naming conventions to automatically generate queries.

### Naming Strategy

A naming strategy is used that converts embedded value object property names to appropriate database column names, following the `snake_case` pattern.

## Event States

The system manages four main states for social events:

- **ACTIVE**: Confirmed event scheduled to take place
- **TO_CONFIRM**: Event pending confirmation from the client
- **CANCELLED**: Event cancelled for any reason
- **COMPLETED**: Event successfully completed

## Integration with Other Bounded Contexts

This bounded context is designed to integrate seamlessly with other system contexts, particularly with the **Quotes** system that handles quotations associated with social events. The modular architecture allows different developers to work on different aggregates within the same context without interference.

## Test Data

The system includes a set of test data that loads automatically to facilitate development and testing. This data includes events of different types such as:

- Baptisms
- Birthdays
- Weddings
- Baby showers
- Graduations

Each with different states and organizers.


