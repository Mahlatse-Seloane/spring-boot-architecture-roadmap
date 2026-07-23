# Evolution of a Spring Boot Application: From Basics to Enterprise

Welcome to my Spring Boot learning roadmap repository! 🚀

Instead of building half-finished, completely unrelated projects, I decided to take a simple application - an **Employee Management System** - and iteratively rebuild it across multiple stages. Each phase introduces new advanced engineering concepts only when a structural problem inside the codebase needs to be solved.

This repository serves to help me better understand backend development, where each phase marks a step forward in mastering production-grade Spring Boot architecture. The project goes from basic "it just works" code to a clean, well-structured application. By comparing the phases side by side, I can see exactly how and why modern design patterns help solve real-world problems.

---

## 🗺️ Project Roadmap & Progress

### 🔹 [Phase 1: Basic CRUD Operations](https://github.com/Mahlatse-Seloane/spring-boot-architecture-roadmap/tree/main/Employee%20Management%20System%20-%20CRUD%20Operations)
* **Objective:** Establish core REST API endpoints and data transfer mechanics, while mastering the web request-response cycle, data serialization, and REST protocol standards.
* **Key Features:** Implemented standard HTTP verbs (`GET`, `POST`, `PUT`, `DELETE`), DTO (Data Transfer Object) mapping patterns, and explicit `ResponseEntity` status management.

### 🔹 [Phase 2: Introduction of the Database Layer (Repository Pattern)](https://github.com/Mahlatse-Seloane/spring-boot-architecture-roadmap/tree/main/Employee%20Management%20System%20-%20In%20Memory%20Database)
* **Objective:** Transition from temporary, volatile in-memory collections to robust relational database persistence.
* **Key Features:** Integrated Spring Data JPA and replaced the manual collections with an abstract `EmployeeRepository` interface, laying the groundwork for true database persistence.

### 🔹 [Phase 3: Transition to Layered Architecture](https://github.com/Mahlatse-Seloane/spring-boot-architecture-roadmap/tree/main/Employee%20Management%20System%20-%20Layered%20Architecture)
* **Objective:** Separate web infrastructure from business rules to achieve strict **Separation of Concerns**.
* **Key Features:** Decoupled code the monolithic controller into distinct 3-Tier architecture (Controllers, Services, Repositories) via Dependency Injection.

---
## 🛠️ Tech Stack & Skills Covered

* **Framework:** Spring Boot (Spring Web, Spring Data JPA, Spring Security)
* **Language:** Java (Streams, functional interfaces, Optionals)
* **Concepts:** RESTful API Design, Repository Pattern, 3-Tier Layered Architecture, Data Encapsulation (DTOs)
