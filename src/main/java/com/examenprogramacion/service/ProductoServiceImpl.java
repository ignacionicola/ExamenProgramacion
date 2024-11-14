package com.examenprogramacion.service;

import com.examenprogramacion.model.Producto;
import com.examenprogramacion.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor


public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repository;

    @Override
    public Optional<Producto> crearProducto(Producto producto) {
        Producto productoParaGuardar = Producto.builder()
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precio(producto.getPrecio())
                .categoria(producto.getCategoria())
                .cantidadEnStock(producto.getCantidadEnStock())
                .activo(true)
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();
        return Optional.of(repository.save(productoParaGuardar));
    }

    @Override
    public Producto obtenerProducto(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));

    }

    @Override
    public List<Producto> obtenerTodos() {
        return repository.findAll();
    }


    @Override
    public Optional<Producto> obtenerPorId(Long id) {
        return repository.findById(id);
    }


    @Override
    public Producto actualizarProducto(Long id, Producto detallesProducto) {
        Producto producto = obtenerProducto(id);
        producto.setNombre(detallesProducto.getNombre());
        producto.setDescripcion(detallesProducto.getDescripcion());
        producto.setPrecio(detallesProducto.getPrecio());
        producto.setCategoria(detallesProducto.getCategoria());
        producto.setCantidadEnStock(detallesProducto.getCantidadEnStock());
        producto.setActivo(detallesProducto.getActivo());
        producto.setUpdatedAt(ZonedDateTime.now());
        return repository.save(producto);
    }

    @Override
    public ResponseEntity<Object> eliminarProducto(Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public Producto actualizarParcialProducto(Long id, Map<String, Object> updates) {
        return null;

    }


}

