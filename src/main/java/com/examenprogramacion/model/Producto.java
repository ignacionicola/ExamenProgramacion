package com.examenprogramacion.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.ZonedDateTime;

@Entity
@Data
@Table(name = "producto")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private double precio;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "cantidad_en_stock") // Eliminé el espacio extra
    private Integer cantidadEnStock;

    @Column(name = "activo")
    private Boolean activo;

    @CreatedDate
    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;


}
