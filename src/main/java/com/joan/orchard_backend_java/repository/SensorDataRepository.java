package com.joan.orchard_backend_java.repository;

import com.joan.orchard_backend_java.model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad SensorData.
 *
 * Al extender JpaRepository, Spring genera automáticamente estos métodos:
 *   - save(sensorData)      → INSERT o UPDATE en sensor_data
 *   - findAll()             → SELECT * FROM sensor_data
 *   - findById(id)          → SELECT * WHERE id = ?
 *   - deleteById(id)        → DELETE WHERE id = ?
 *   - count()               → COUNT(*)
 *
 * No hace falta escribir SQL ni implementar ningún método.
 * Spring crea la implementación real en memoria al arrancar.
 *
 * Parámetros de JpaRepository:
 *   - SensorData → entidad/tabla con la que trabaja
 *   - Long       → tipo del campo @Id en SensorData
 */

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
    // Aquí se pueden añadir queries personalizadas en el futuro
    // Ejemplo: List<SensorData> findBySensorId(String sensorId);
}
