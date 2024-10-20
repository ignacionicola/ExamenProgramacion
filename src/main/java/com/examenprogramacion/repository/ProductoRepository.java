package com.examenprogramacion.repository;

import com.examenprogramacion.model.Producto;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
