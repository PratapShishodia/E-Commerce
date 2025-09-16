# E-Commerce Microservices Project

This is a learning project to explore **Java microservices**, **distributed system patterns**, and **cloud features**.  
The goal is to practice concepts such as:
- Java concurrency & multithreading
- Microservices patterns (API Gateway, Circuit Breaker, Saga, etc.)
- Event-driven communication with **Kafka** and message queues
- AWS services like EC2, S3, and Lambda

---

## Services (Planned)

- **API Gateway** – single entry point, routing and auth
- **Auth Service** – user login & JWT token generation
- **Catalog Service** – product listing & metadata
- **Inventory Service** – track and reserve stock
- **Cart Service** – manage user carts
- **Order Service** – place and track orders (Saga orchestrator)
- **Payment Service** – simulate external payments
- **Notification Service** – emails / SMS / async notifications
- **Fulfillment Service** – shipping & delivery simulation
- **Kafka** – event bus for inter-service communication

---

## Tech Stack

- **Java 17+**
- **Spring Boot / Spring Cloud**
- **Postgres/MongoDB** (per service DB)
- **Kafka** (for events and async messaging)
- **Docker & Docker Compose** (for local dev)
- **AWS (optional)**: EC2, S3, Lambda, CloudWatch

---

## Getting Started (Local Dev)

1. Clone this repository:
   ```bash
   git clone <your-repo-url>
   cd ecommerce-microservices

Will add Other Steps in Future