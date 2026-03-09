
Readme es · MD
Copiar

# Orchard Backend

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.2-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)
![Docker](https://img.shields.io/badge/Docker-Compose-2496ED)
![Flyway](https://img.shields.io/badge/Flyway-Migraciones-red)
![Estado](https://img.shields.io/badge/estado-Sprint%202%20Completo-green)

Backend IoT estilo enterprise construido con Java + Spring Boot para monitorización y riego automático de jardín.

🇬🇧 Read in English: [README.md](README.md)

---

## ¿Qué es Orchard?

Orchard es un proyecto IoT personal que monitoriza y automatiza un jardín real de 120m² en Santiago de Compostela. Este repositorio contiene la **API backend** — la capa de servicios central que conecta los nodos sensores ESP32, una base de datos PostgreSQL y un futuro módulo de predicción ML.

El sistema recoge datos de microclima en tiempo real (temperatura, humedad, humedad del suelo, luz) desde nodos sensores físicos y los utiliza para tomar decisiones automáticas de riego.

---

## Arquitectura

```
Nodos ESP32 ──MQTT──► API Spring Boot ──► PostgreSQL
 (sensores)             (este repo)         (datos)
                             │
                       API REST ◄──── Postman / clientes
                             │
                   Módulo ML (Python/FastAPI)
                        (sprint futuro)
                             │
                   Decisiones de riego automático
```

**Arquitectura de tres capas:**
```
Controller  →  Service  →  Repository  →  PostgreSQL
(API REST)    (lógica de    (Spring Data
               negocio)        JPA)
```

---

## Estado actual — Sprint 2 Completo ✅

| Funcionalidad | Estado |
|---|---|
| Proyecto Spring Boot 3.4.2 | ✅ Hecho |
| Endpoint de salud `GET /api/health` | ✅ Hecho |
| PostgreSQL 16 en Docker Compose | ✅ Hecho |
| Migraciones Flyway | ✅ Hecho |
| Entidad JPA `SensorData` | ✅ Hecho |
| `POST /api/lecturas` — guardar lectura de sensor | ✅ Hecho |
| `GET /api/lecturas` — recuperar todas las lecturas | ✅ Hecho |
| Dockerfile multi-stage | ✅ Hecho |
| Stack completo dockerizado (app + BD) | ✅ Hecho |
| Integración MQTT (Mosquitto + ESP32) | 🔒 Sprint 3 |
| Dashboard Grafana | 🔒 Sprint 4 |
| Riego automático | 🔒 Sprint 5 |
| Módulo de predicción ML | 🔒 Sprint 6 |

---

## Stack tecnológico

| Tecnología | Versión | Propósito |
|---|---|---|
| Java | 17 | Lenguaje |
| Spring Boot | 3.4.2 | Framework |
| Spring Data JPA | 3.4.2 | ORM |
| PostgreSQL | 16 | Base de datos |
| Flyway | 10.x | Migraciones de BD |
| Docker / Docker Compose | — | Infraestructura |
| Maven Wrapper | — | Herramienta de build |

---

## API

| Método | Endpoint | Descripción | Body |
|---|---|---|---|
| `GET` | `/api/health` | Verificación de estado del servicio | — |
| `POST` | `/api/lecturas` | Guardar una lectura de sensor | JSON (ver abajo) |
| `GET` | `/api/lecturas` | Recuperar todas las lecturas | — |

**POST /api/lecturas — ejemplo de body:**
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

## Estructura del proyecto

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

## Cómo ejecutar

### Requisitos previos

- Java 17
- Docker Desktop
- IntelliJ IDEA (recomendado)
- DBeaver (opcional, para inspección de base de datos)
- Postman (opcional, para pruebas de API)

### 1. Iniciar PostgreSQL (Docker)

```bash
docker-compose up -d
```

> ⚠️ En Windows, si Docker tiene los puertos bloqueados por Hyper-V, ejecuta primero en PowerShell como administrador:
> ```powershell
> net stop winnat
> docker-compose up -d
> net start winnat
> ```

Verificar:
```bash
docker ps
# Debe mostrar: orchard-postgres   Up
```

### 2. Iniciar Spring Boot

Ejecuta `OrchardBackendJavaApplication` desde IntelliJ, o:

```bash
./mvnw spring-boot:run
```

### 3. Verificar

```bash
GET http://localhost:8080/api/health
# → "Hello, OK!"

POST http://localhost:8080/api/lecturas
# → 200 OK con entidad guardada

GET http://localhost:8080/api/lecturas
# → Array JSON con todas las lecturas
```

### 4. Stack completo con Docker

```bash
docker-compose up --build
```

Tanto la aplicación Spring Boot como PostgreSQL arrancarán juntos.

---

## Variables de entorno

La aplicación soporta ejecución tanto en Docker como en IntelliJ local mediante valores de fallback en variables de entorno:

```properties
# application.properties
spring.datasource.url=${DB_URL:jdbc:postgresql://localhost:5432/orchard_db}
spring.datasource.username=${DB_USER:orchard}
spring.datasource.password=${DB_PASSWORD:orchard}
```

---

## Roadmap

| Sprint | Objetivo | Estado |
|---|---|---|
| S0 | Configuración del entorno | ✅ Hecho |
| S1 | Fundamentos Java + modelo de dominio | ✅ Hecho |
| S2 | API REST + PostgreSQL + Docker | ✅ Hecho |
| S3 | MQTT + Mosquitto + integración ESP32 | 🔒 Pendiente |
| S4 | Dashboard Grafana | 🔒 Pendiente |
| S5 | Control de riego automático | 🔒 Pendiente |
| S6 | Módulo de predicción ML (Python/FastAPI) | 🔒 Pendiente |

---

## Decisiones técnicas clave

**¿Por qué Flyway?** Versionado del esquema de base de datos desde el primer día. Cada migración queda registrada, es reproducible y compatible tanto con Docker como con entornos locales.

**¿Por qué Dockerfile multi-stage?** Separa el entorno de compilación del entorno de ejecución. La imagen final contiene únicamente el JAR — sin Maven, sin código fuente, superficie de ataque mínima.

**¿Por qué el fallback de variables de entorno en `application.properties`?** Permite que el mismo código funcione en Docker (variables inyectadas por Compose) y en IntelliJ localmente (valores por defecto) sin modificar ningún fichero entre entornos.

---

## Autor

Carlos — Graduado en DAM + Bootcamp de Data Science  
Construyendo sistemas IoT reales como vehículo de aprendizaje para desarrollo backend enterprise.  
[GitHub](https://github.com/JCSB247)
