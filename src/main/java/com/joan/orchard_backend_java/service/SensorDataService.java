package com.joan.orchard_backend_java.service;

import com.joan.orchard_backend_java.model.SensorData;
import com.joan.orchard_backend_java.repository.SensorDataRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Capa de servicio para SensorData.
 *
 * @Service → le dice a Spring que esta clase contiene lógica de negocio.
 *            Spring la registra como un bean y la inyecta donde se necesite.
 *
 * Responsabilidad: actúa como intermediario entre el Controller y el Repository.
 *   Controller → recibe la petición HTTP
 *   Service    → aplica lógica de negocio (validaciones, transformaciones, etc.)
 *   Repository → accede a la base de datos
 *
 * Ahora mismo la lógica es simple (solo guarda y lista).
 * En el futuro aquí irían validaciones como:
 *   - ¿El valor está en rango válido?
 *   - ¿El sensorId existe en el sistema?
 *   - ¿Hay alertas que lanzar?
 */

@Service
public class SensorDataService {
    /**
     * Inyección de dependencias por constructor.
     * Spring detecta que SensorDataService necesita un SensorDataRepository
     * y lo inyecta automáticamente al arrancar.
     * Es la forma recomendada frente a @Autowired.
     */
    private final SensorDataRepository repository;

    public SensorDataService(SensorDataRepository repository){
        this.repository = repository;
    }
    /**
     * Guarda una lectura de sensor en la base de datos.
     * Llama a repository.save() que ejecuta un INSERT en sensor_data.
     * Devuelve el objeto guardado con el id generado por PostgreSQL.
     */
    public SensorData save(SensorData sensorData){
        return repository.save(sensorData);
    }
    /**
     * Obtiene todas las lecturas de la base de datos.
     * Llama a repository.findAll() que ejecuta un SELECT * FROM sensor_data.
     */
    public List<SensorData> getAll() {
        return repository.findAll();
    }

}
