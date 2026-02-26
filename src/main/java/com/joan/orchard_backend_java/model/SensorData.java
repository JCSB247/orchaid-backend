package com.joan.orchard_backend_java.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="sensor_data")
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sensorId;
    private Double valor;
    private String unidad;
    private LocalDateTime timestamp;

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

    public SensorData(Long id, String sensorId, Double valor, String unidad, LocalDateTime timestamp) {
        this.id = id;
        this.sensorId = sensorId;
        this.valor = valor;
        this.unidad = unidad;
        this.timestamp = timestamp;


    }
}
