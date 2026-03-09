# Orchard Backend

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.2-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)
![Docker](https://img.shields.io/badge/Docker-Compose-2496ED)
![Flyway](https://img.shields.io/badge/Flyway-Migrations-red)
![Status](https://img.shields.io/badge/status-Sprint%202%20Complete-green)

Enterprise-style IoT backend built with Java + Spring Boot for garden monitoring and automated irrigation.

🇪🇸 Leer en español: [README_es.md](README_es.md)

---

## What is Orchard?

Orchard is a personal IoT project that monitors and automates a real 120m² garden in Santiago de Compostela. This repository contains the **backend API** — the core service layer connecting ESP32 sensor nodes, a PostgreSQL database, and a future ML prediction module.

The system collects real-time microclimate data (temperature, humidity, soil moisture, light) from physical sensor nodes and uses it to trigger automated irrigation decisions.

---

## Architecture

```
ESP32 nodes ──MQTT──► Spring Boot API ──► PostgreSQL
  (sensors)              (this repo)        (data)
                              │
                        REST API ◄──── Postman / clients
                              │
                    ML module (Python/FastAPI)
                         (future sprint)
                              │
                    Automated irrigation decisions
```

**Three-layer architecture:**
```
Controller  →  Service  →  Repository  →  PostgreSQL
(REST API)    (business     (Spring Data
               logic)          JPA)
```

---

## Current status — Sprint 2 Complete ✅

| Feature | Status |
|---|---|
| Spring Boot 3.4.2 project | ✅ Done |
| REST health endpoint `GET /api/health` | ✅ Done |
| PostgreSQL 16 in Docker Compose | ✅ Done |
| Flyway migrations | ✅ Done |
| `SensorData` JPA entity | ✅ Done |
| `POST /api/lecturas` — store sensor reading | ✅ Done |
| `GET /api/lecturas` — retrieve all readings | ✅ Done |
| Multi-stage Dockerfile | ✅ Done |
| Full stack dockerized (app + DB) | ✅ Done |
| MQTT integration (Mosquitto + ESP32) | 🔒 Sprint 3 |
| Grafana dashboard | 🔒 Sprint 4 |
| Automated irrigation | 🔒 Sprint 5 |
| ML prediction module | 🔒 Sprint 6 |

---

## Tech stack

| Technology | Version | Purpose |
|---|---|---|
| Java | 17 | Language |
| Spring Boot | 3.4.2 | Framework |
| Spring Data JPA | 3.4.2 | ORM |
| PostgreSQL | 16 | Database |
| Flyway | 10.x | DB migrations |
| Docker / Docker Compose | — | Infrastructure |
| Maven Wrapper | — | Build tool |

---

## API

| Method | Endpoint | Description | Body |
|---|---|---|---|
| `GET` | `/api/health` | Service health check | — |
| `POST` | `/api/lecturas` | Store a sensor reading | JSON (see below) |
| `GET` | `/api/lecturas` | Retrieve all readings | — |

**POST /api/lecturas — example body:**
```json
{
  "nodeId": "node-01",
  "temperature": 18.5,
  "humidity": 72.3,
  "soilMoisture": 45.0,
  "timestamp": "2026-03-09T10:30:00"
}
```

---

## Project structure

```
src/
└── main/
    ├── java/com/joan/orchard_backend_java/
    │   ├── controller/
    │   │   ├── HealthController.java
    │   │   └── SensorDataController.java
    │   ├── service/
    │   │   └── SensorDataService.java
    │   ├── repository/
    │   │   └── SensorDataRepository.java
    │   ├── model/
    │   │   └── SensorData.java
    │   └── OrchardBackendJavaApplication.java
    └── resources/
        ├── application.properties
        └── db/migration/
            └── V1__create_sensor_data.sql
```

---

## How to run

### Prerequisites

- Java 17
- Docker Desktop
- IntelliJ IDEA (recommended)
- DBeaver (optional, for database inspection)
- Postman (optional, for API testing)

### 1. Start PostgreSQL (Docker)

```bash
docker-compose up -d
```

> ⚠️ On Windows, if Docker ports are blocked by Hyper-V, run first in PowerShell as administrator:
> ```powershell
> net stop winnat
> docker-compose up -d
> net start winnat
> ```

Verify:
```bash
docker ps
# Should show: orchard-postgres   Up
```

### 2. Start Spring Boot

Run `OrchardBackendJavaApplication` from IntelliJ, or:

```bash
./mvnw spring-boot:run
```

### 3. Verify

```bash
GET http://localhost:8080/api/health
# → "Hello, OK!"

POST http://localhost:8080/api/lecturas
# → 200 OK with saved entity

GET http://localhost:8080/api/lecturas
# → JSON array of all readings
```

### 4. Full stack with Docker

```bash
docker-compose up --build
```

Both the Spring Boot app and PostgreSQL will start together.

---

## Environment variables

The app supports both Docker and local IntelliJ execution via environment variable fallback:

```properties
# application.properties
spring.datasource.url=${DB_URL:jdbc:postgresql://localhost:5432/orchard_db}
spring.datasource.username=${DB_USER:orchard}
spring.datasource.password=${DB_PASSWORD:orchard}
```

---

## Roadmap

| Sprint | Goal | Status |
|---|---|---|
| S0 | Environment setup | ✅ Done |
| S1 | Java fundamentals + domain model | ✅ Done |
| S2 | REST API + PostgreSQL + Docker | ✅ Done |
| S3 | MQTT + Mosquitto + ESP32 integration | 🔒 Pending |
| S4 | Grafana dashboard | 🔒 Pending |
| S5 | Automated irrigation control | 🔒 Pending |
| S6 | ML prediction module (Python/FastAPI) | 🔒 Pending |

---

## Key technical decisions

**Why Flyway?** Database schema versioning from day one. Every migration is tracked, reproducible, and compatible with both Docker and local environments.

**Why multi-stage Dockerfile?** Separates build environment from runtime. The final image contains only the JAR — no Maven, no source code, minimal attack surface.

**Why environment variable fallback in `application.properties`?** Allows the same codebase to run in Docker (variables injected by Compose) and in IntelliJ locally (fallback defaults) without any file changes between environments.

---

## Author

Carlos — DAM graduate + Data Science bootcamp  
Building real IoT systems as a learning vehicle for enterprise backend development.  
[GitHub](https://github.com/JCSB247)