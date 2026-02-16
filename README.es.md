# Orchaid Backend (MVP) — Java + Spring Boot

Servicios backend para **Orchaid**, un proyecto personal a largo plazo enfocado en **IoT, datos y automatización**.

Este repositorio contiene el primer MVP de la API backend desarrollada con **Java y Spring Boot**, concebida como la capa central de servicios del sistema.

Python seguirá siendo la herramienta principal para el procesamiento de datos y los módulos de Machine Learning, que se integrarán posteriormente en la arquitectura.

---

## Estado actual

- Proyecto Spring Boot inicializado
- Endpoint REST disponible: `/api/health`
- Servidor local ejecutándose en el puerto 8080
- Estructura base del backend en progreso

---

## API

- `GET /api/health` → estado del servicio (`ok`)

---

## Stack tecnológico

- Java
- Spring Boot
- Maven Wrapper (`mvnw`)
- Arquitectura REST

---

## Visión del proyecto

Orchaid pretende convertirse en un sistema integrado para:

- Recolección de datos IoT
- Lógica de automatización
- Orquestación de servicios backend
- Integración futura con pipelines de Machine Learning

El backend actuará como la capa central que conecte sensores, módulos de procesamiento de datos e interfaces externas.

---

## Próximos pasos (roadmap)

- Implementar arquitectura por capas:
  - controller
  - service
  - repository
  - model

- Añadir recursos de dominio:
  - Usuario
  - Dispositivos
  - Datos de sensores

- Capa de persistencia:
  - JPA / Hibernate
  - H2 (desarrollo)
  - PostgreSQL (producción)

- Integraciones:
  - Servicios de ML en Python
  - Ingesta de datos IoT

---

## Autor

Joan  
Backend (Java) + background en datos  
Transición hacia desarrollo backend empresarial