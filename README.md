# Orchaid Backend

Enterprise-style backend service built with Java + Spring Boot  
for IoT, automation and data systems.

🇪🇸 Leer en español: [README.es.md](README.es.md)

# Orchaid Backend (MVP) — Java + Spring Boot

Backend services for **Orchaid**, a long-term personal project focused on **IoT, data and automation systems**.

This repository contains the first MVP of the backend API built with **Java and Spring Boot**, designed as the core service layer of the system.

Python remains the main tool for data processing and Machine Learning modules, which will be integrated later into the architecture.

---

## Current status

- Spring Boot project initialized
- REST endpoint available: `/api/health`
- Local server running on port 8080
- Base backend structure in progress

---

## API

- `GET /api/health` → service status (`ok`)

---

## Tech stack

- Java
- Spring Boot
- Maven Wrapper (`mvnw`)
- REST API architecture

---

## Project vision

Orchaid aims to become an integrated system for:

- IoT data collection
- Automation logic
- Backend service orchestration
- Future integration with Machine Learning pipelines

The backend will act as the central layer connecting sensors, data processing modules and external interfaces.

---

## Next steps (roadmap)

- Implement layered architecture:
  - controller
  - service
  - repository
  - model

- Add domain resources:
  - User
  - Devices
  - Sensor data

- Persistence layer:
  - JPA / Hibernate
  - H2 (dev)
  - PostgreSQL (production-ready)

- Integration:
  - Python ML services
  - IoT data ingestion

---

## Author

Joan  
Backend (Java) + Data background  
Transitioning into enterprise backend development

