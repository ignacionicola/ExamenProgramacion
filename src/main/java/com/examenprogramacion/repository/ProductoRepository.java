package com.examenprogramacion.repository;

import com.examenprogramacion.model.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface ProductoRepository extends JpaRepository<Producto, Long> {






}
