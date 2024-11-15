
-- data.sql
-- Insert data into the users table

INSERT IGNORE INTO producto (nombre, descripcion, precio, categoria, cantidad_en_stock, activo, created_at, updated_at)
 VALUES
('Laptop', 'Laptop de alta gama', 1500.00, 'Electrónica', 50, true, '2024-01-01T10:00:00Z', '2024-01-01T10:00:00Z'),
('Smartphone', 'Teléfono inteligente con cámara avanzada', 800.00, 'Electrónica', 150, true, '2024-01-02T11:00:00Z', '2024-01-02T11:00:00Z');
