# Orchard Backend

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.2-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)
![Docker](https://img.shields.io/badge/Docker-Compose-2496ED)
![Python](https://img.shields.io/badge/Python-future%20ML-lightgrey)
![Status](https://img.shields.io/badge/status-Sprint%202-orange)

Enterprise-style backend service built with Java + Spring Boot  
for IoT, automation and data systems.

🇪🇸 Leer en español: [README.es.md](README.es.md)

# Orchard Backend — Java + Spring Boot

Backend services for **Orchard**, a personal IoT project that monitors and automates a real garden in Santiago de Compostela.

This repository contains the backend API built with **Java and Spring Boot**, designed as the core service layer connecting ESP32 sensors, PostgreSQL and a future ML prediction module.

---

## Current status — Sprint 2 in progress

- ✅ Spring Boot 3.4.2 project initialized
- ✅ REST endpoint: `GET /api/health`
- ✅ PostgreSQL 16 running in Docker Compose
- ✅ DBeaver connected — `orchard_db` database ready
- ⏳ `@Entity SensorData` + REST API in progress

---

## Requirements

- Java 17
- Docker Desktop
- DBeaver (optional, for database inspection)
- IntelliJ IDEA Community (recommended)

---

## How to run

### 1. Start PostgreSQL (Docker)

> ⚠️ On Windows, Hyper-V may block Docker ports. Run this first in PowerShell as administrator:

```powershell
net stop winnat
docker-compose up -d
net start winnat
```

Verify the container is running:
```bash
docker ps
# Should show: orchard-postgres   Up
```

### 2. Start Spring Boot

Run `OrchardBackendJavaApplication` from IntelliJ, or:

```bash
$env:JAVA_HOME = "path\to\your\jdk-17"
.\mvnw spring-boot:run
```

### 3. Verify

```
GET http://localhost:8080/api/health
→ "Hello, OK!"
```

---

## API

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/health` | Service health check |

More endpoints coming in Sprint 2.

---

## Tech stack

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 17 | Language |
| Spring Boot | 3.4.2 | Framework |
| Spring Data JPA | 3.4.2 | ORM |
| PostgreSQL | 16 | Database |
| Flyway | 10.x | DB migrations |
| Docker Compose | — | Local infrastructure |
| Maven Wrapper | — | Build tool |

---

## Project structure

```
src/
└── main/
    ├── java/com/joan/orchard_backend_java/
    │   ├── controller/
    │   │   └── HealthController.java
    │   └── OrchardBackendJavaApplication.java
    └── resources/
        └── application.properties
```

---

## Project vision

Orchard is a garden monitoring and automated irrigation system for a 120m² outdoor garden. The full architecture:

```
ESP32 sensors → MQTT → Spring Boot → PostgreSQL → Grafana dashboard
                                   ↓
                            ML prediction model (Python/FastAPI)
                                   ↓
                          Automated irrigation decisions
```

---

## Roadmap

| Sprint | Goal | Status |
|--------|------|--------|
| S0 | Environment setup | ✅ Done |
| S1 | Java fundamentals + domain model | ✅ Done — 23 Feb 2026 |
| S2 | REST API + PostgreSQL | ⏳ In progress |
| S3 | MQTT + ESP32 sensor in the garden | 🔒 |
| S4 | Grafana dashboard | 🔒 |
| S5 | Automated irrigation | 🔒 |
| S6 | ML prediction model | 🔒 |

---

## Author

Joan  
Backend (Java) + Data background  
Transitioning into enterprise backend development
