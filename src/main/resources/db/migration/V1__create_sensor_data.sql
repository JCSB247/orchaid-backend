CREATE TABLE sensor_data (
    id BIGSERIAL PRIMARY KEY,
    sensor_id VARCHAR(50),
    valor DOUBLE PRECISION,
    unidad VARCHAR(20),
    timestamp TIMESTAMP
    );