# Orchard Backend

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.2-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)
![Docker](https://img.shields.io/badge/Docker-Compose-2496ED)
![Python](https://img.shields.io/badge/Python-futuro%20ML-lightgrey)
![Estado](https://img.shields.io/badge/estado-Sprint%202-orange)

Servicio backend de estilo empresarial construido con Java + Spring Boot  
para sistemas de IoT, automatización y datos.

🇬🇧 Read in English: [README.md](README.md)

# Orchard Backend — Java + Spring Boot

Servicios backend para **Orchard**, un proyecto IoT personal que monitoriza y automatiza un huerto real en Santiago de Compostela.

Este repositorio contiene la API backend construida con **Java y Spring Boot**, diseñada como la capa central de servicios que conecta sensores ESP32, PostgreSQL y un futuro módulo de predicción ML.

---

## Estado actual — Sprint 2 en curso

- ✅ Spring Boot 3.4.2 inicializado
- ✅ Endpoint REST: `GET /api/health`
- ✅ PostgreSQL 16 corriendo en Docker Compose
- ✅ DBeaver conectado — base de datos `orchard_db` lista
- ⏳ `@Entity SensorData` + API REST en progreso

---

## Requisitos

- Java 17
- Docker Desktop
- DBeaver (opcional, para inspección de la base de datos)
- IntelliJ IDEA Community (recomendado)

---

## Cómo arrancar

### 1. Iniciar PostgreSQL (Docker)

> ⚠️ En Windows, Hyper-V puede bloquear los puertos de Docker. Ejecuta esto primero en PowerShell como administrador:

```powershell
net stop winnat
docker-compose up -d
net start winnat
```

Verifica que el contenedor está corriendo:
```bash
docker ps
# Debe mostrar: orchard-postgres   Up
```

### 2. Iniciar Spring Boot

Ejecuta `OrchardBackendJavaApplication` desde IntelliJ, o:

```bash
$env:JAVA_HOME = "ruta\a\tu\jdk-17"
.\mvnw spring-boot:run
```

### 3. Verificar

```
GET http://localhost:8080/api/health
→ "Hello, OK!"
```

---

## API

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/health` | Health check del servicio |

Más endpoints en el Sprint 2.

---

## Stack tecnológico

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| Java | 17 | Lenguaje |
| Spring Boot | 3.4.2 | Framework |
| Spring Data JPA | 3.4.2 | ORM |
| PostgreSQL | 16 | Base de datos |
| Flyway | 10.x | Migraciones de BD |
| Docker Compose | — | Infraestructura local |
| Maven Wrapper | — | Build tool |

---

## Estructura del proyecto

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

## Visión del proyecto

Orchard es un sistema de monitorización y riego automatizado para un huerto exterior de 120m². Arquitectura completa:

```
Sensores ESP32 → MQTT → Spring Boot → PostgreSQL → Dashboard Grafana
                                    ↓
                        Modelo ML de predicción (Python/FastAPI)
                                    ↓
                        Decisiones de riego automatizado
```

---

## Roadmap

| Sprint | Objetivo | Estado |
|--------|----------|--------|
| S0 | Configuración del entorno | ✅ Cerrado |
| S1 | Java básico + modelo de dominio | ✅ Cerrado — 23 Feb 2026 |
| S2 | REST API + PostgreSQL | ⏳ En curso |
| S3 | MQTT + sensor ESP32 en el huerto | 🔒 |
| S4 | Dashboard Grafana | 🔒 |
| S5 | Riego automatizado | 🔒 |
| S6 | Modelo ML de predicción | 🔒 |

---

## Autor

Joan  
Backend (Java) + background en datos  
Transición hacia desarrollo backend empresarial
