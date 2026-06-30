# Spring Boot Architecture Roadmap

> **Development Status: Active Architecture Study**
> This repository documents a progressive backend roadmap designed to master production-grade Spring Boot architecture. The application is built incrementally, introducing advanced engineering concepts only when a structural problem needs to be solved.

---

## 🚀 The Progressive Roadmap Architecture

### 🔹 Milestone: HTTP & Concurrency Boundary
* **Focus:** Mastering the web request-response cycle, data serialization, and REST protocol standards.
* **Core Concepts:** Functionally pure object mapping, `ResponseEntity` status management, and thread-safe in-memory operations (`CopyOnWriteArrayList`, `AtomicLong`) to guarantee data integrity within Spring's multi-threaded Singleton controller environment.

### 🔹 Milestone: Layered Service Architecture & Safety
* **Focus:** Separating infrastructure from business rules to achieve strict Separation of Concerns.
* **Core Concepts:** Decoupling code into distinct 3-Tier layers (Controllers, Services, Repositories) via Dependency Injection, implementing centralized Jakarta input validation, and constructing a Global Exception Handler (`@ControllerAdvice`) safety net.

### 🔹 Milestone: Relational Persistence Engines
* **Focus:** Transitioning from temporary in-memory collections to robust database persistence without breaking existing application layers.
* **Core Concepts:** Object-Relational Mapping (ORM) via Spring Data JPA, dual-engine database configurations (H2 for development testing and PostgreSQL for production environments), and versioned database schema migration controls.
