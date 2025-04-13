package com.VirtualLibWeb.VirtualLib.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "libros")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LibroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "isbn", nullable = false, length = 13, unique = true)
    private String isbn;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;
    
    @Column(name = "autor", nullable = false, length = 100)
    private String autor;
    
    @Column(name = "editorial", nullable = false, length = 100)
    private String editorial;
    
    @Column(name = "anio_publicacion", nullable = false, length = 4)
    private String anioPublicacion;
    
    @Column(name = "genero", nullable = false, length = 50)
    private String genero;
    
    @Column(name = "cantidad_ejemplares_disponibles", nullable = false)
    private int cantidadEjemplaresDisponibles;
    
    @Column(name = "numero_de_paginas", nullable = false)
    private int numeroDePaginas;


}
