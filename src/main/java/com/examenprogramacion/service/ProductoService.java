package com.examenprogramacion.service;

import com.examenprogramacion.model.Producto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductoService {
    Optional<Producto> crearProducto(Producto producto);
    Producto obtenerProducto(Long id);
    List<Producto> obtenerTodos();
    Optional<Producto> obtenerPorId(Long id);
    Producto actualizarProducto(Long id, Producto detallesProducto);
    ResponseEntity<Object> eliminarProducto(Long id);
    Producto actualizarParcialProducto(Long id, Map<String, Object> updates);

}
