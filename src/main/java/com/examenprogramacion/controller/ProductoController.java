package com.examenprogramacion.controller;

import com.examenprogramacion.exception.EntityNotFoundException;
import com.examenprogramacion.model.Producto;
import com.examenprogramacion.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.examenprogramacion.exception.EntityNotFoundException;

@Tag (name = "Producto", description = "Operaciones relacionadas con la gestión de Productos")



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/productos")
public class ProductoController {







    private final ProductoService service;

    public ProductoController(ProductoService service, ProductoService service1) {
        this.service = service1;
    }


    @GetMapping

    public List<Producto> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Long id) {
        Producto producto = service.obtenerPorId(id)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con id: " + id));
        return ResponseEntity.ok(producto);
    }


    @PostMapping
    public ResponseEntity<Optional<Producto>> crearProducto(@RequestBody Producto producto) {
        Optional<Producto> nuevoProducto = service.crearProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto detallesProducto) {
        Producto productoActualizado = service.actualizarProducto(id, detallesProducto);
        return ResponseEntity.ok(productoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        service.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Producto> actualizarParcialProducto(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Producto productoActualizado = service.actualizarParcialProducto(id, updates);
        return ResponseEntity.ok(productoActualizado);
    }
}

