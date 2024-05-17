# To-do list
This is a simple task management (To-Do List) application built with Spring Boot and MongoDB, following the principles of Clean Architecture. The application is configured to run in Docker containers using Docker Compose.

# Prerequisites
Before getting started, make sure you have the following installed in your development environment:

* Java JDK 17
* Maven
* Docker
  
# Installation and Execution
1. Clone the repository:
```bash
git clone https://github.com/your-user/to-do-list.git
```
Or download and extract the project manually.

2. Navigate to the project directory:
```bash
cd to-do-list
```
3. Run the project using Maven:
```bash
mvn spring-boot:run
```
The application will start and be accessible at http://localhost:8080.

# Endpoints
The application exposes the following endpoints:

* POST /api/tasks - Creates a new task.
* GET /api/tasks - Returns all tasks.
* GET /api/tasks/{id} - Returns a specific task by ID.
* PUT /api/tasks/{id} - Updates an existing task by ID.
* PATCH /api/tasks/{id}/status - Updates the status of a task by ID.
* DELETE /api/tasks/{id} - Delete a task by ID.

# Configuration
The application's settings can be found in the application.properties file. Make sure to configure the properties related to Redis and the database according to your environment.
```yml
spring:
  application:
    name: to-do-list
  data:
    mongodb:
      username: root
      password: secret
      database: tasks-db
      port: 27017
      host: mongodb
  jpa:
    database: none
    show-sql: false

```

# Contributing
If you wish to contribute to this project, follow these steps:

1. Fork the project.
2. Create a branch for your feature: git checkout -b feature-new-feature.
3. Make your changes and commit them: git commit -m 'Add a new feature'.
4. Push to the branch: git push origin feature-new-feature.
5. Submit a pull request.
