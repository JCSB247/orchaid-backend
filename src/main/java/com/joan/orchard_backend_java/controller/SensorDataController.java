package com.joan.orchard_backend_java.controller;

import com.joan.orchard_backend_java.model.SensorData;
import com.joan.orchard_backend_java.service.SensorDataService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.util.List;

/**
 * Capa de controlador para SensorData.
 *
 * @RestController → combina @Controller + @ResponseBody.
 *                   Le dice a Spring que esta clase maneja peticiones HTTP
 *                   y que las respuestas se serializan automáticamente a JSON.
 *
 * @RequestMapping → define la ruta base para todos los endpoints de esta clase.
 *                   Todos los métodos de este controller empiezan por /api/lecturas.
 *
 * Responsabilidad: recibir peticiones HTTP, delegar al Service y devolver respuesta.
 * El Controller NO contiene lógica de negocio — solo recibe y responde.
 */
@RestController
@RequestMapping("/api/lecturas")
public class SensorDataController {
    /**
     * Inyección del Service por constructor.
     * El Controller no habla directamente con el Repository —
     * siempre pasa por el Service.
     */
    private final SensorDataService service;
    public SensorDataController(SensorDataService service){
        this.service = service;
    }
    /**
     * POST /api/lecturas
     *
     * @RequestBody     → Spring deserializa el JSON del body a un objeto SensorData.
     * @ResponseStatus  → devuelve HTTP 201 Created en vez del 200 OK por defecto.
     *
     * Flujo:
     *   Postman POST /api/lecturas { json } → Controller → Service → Repository → PostgreSQL
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SensorData crear(@RequestBody SensorData sensorData){
        return service.save(sensorData);
    }
    /**
     * GET /api/lecturas
     *
     * Devuelve todas las lecturas de la base de datos en formato JSON.
     *
     * Flujo:
     *   Postman GET /api/lecturas → Controller → Service → Repository → PostgreSQL → JSON
     */
    @GetMapping
    public List<SensorData> obtenerTodas(){
        return service.getAll();
    }
}
