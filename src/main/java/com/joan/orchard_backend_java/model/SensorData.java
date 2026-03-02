package com.joan.orchard_backend_java.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entidad JPA que representa una lectura de sensor del huerto.
 *
 * @Entity  → le dice a Spring que esta clase es una tabla en PostgreSQL.
 *            Sin esta anotación, Spring ignora la clase completamente.
 *
 * @Table   → define el nombre exacto de la tabla en la base de datos.
 *            Sin esto, Hibernate usaría el nombre de la clase en snake_case.
 *
 * Cada instancia de SensorData = una fila en la tabla sensor_data.
 *
 * Mapeo clase → tabla:
 *   SensorData       →  sensor_data (tabla)
 *   id               →  id          (PK, autoincremental)
 *   sensorId         →  sensor_id   (Hibernate convierte camelCase a snake_case)
 *   valor            →  valor
 *   unidad           →  unidad
 *   timestamp        →  timestamp
 */
@Entity
@Table(name="sensor_data")
public class SensorData {
    /**
     * @Id → marca este campo como clave primaria (PRIMARY KEY).
     *       Identifica cada fila de forma única.
     *
     * @GeneratedValue(IDENTITY) → el valor lo genera PostgreSQL automáticamente
     *       (1, 2, 3...). No tienes que pasarlo al crear un objeto SensorData.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Identificador del sensor. Ej: "esp32-exterior-01" */
    private String sensorId;

    /** Valor medido por el sensor. Ej: 65.3 (humedad), 22.5 (temperatura) */
    private Double valor;

    /** Unidad de medida. Ej: "%", "°C", "mm" */
    private String unidad;

    /** Momento exacto en que se tomó la lectura */
    private LocalDateTime timestamp;

    // GETTERS Y SETTERS
    // Spring (Jackson) necesita getters para serializar a JSON en la API REST.
    // Spring (JPA) necesita setters para reconstruir objetos desde la base de datos
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getSensorId() {
        return sensorId;
    }
    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getUnidad() {
        return unidad;
    }
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    //CONSTRUCTOR
    /**
     * Constructor completo — usado para crear lecturas manualmente en el código.
     * JPA también necesita un constructor vacío (sin parámetros) para poder
     * reconstruir objetos desde la base de datos. Añadir si Spring se queja.
     */
    public SensorData(Long id, String sensorId, Double valor, String unidad, LocalDateTime timestamp) {
        this.id = id;
        this.sensorId = sensorId;
        this.valor = valor;
        this.unidad = unidad;
        this.timestamp = timestamp;
    }
    /**
     * Constructor vacío — OBLIGATORIO para JPA/Hibernate.
     * Hibernate lo necesita para reconstruir objetos desde la base de datos
     * sin pasar parámetros. Sin este constructor Spring lanzaría un error.
     */
    public SensorData() {}
}
