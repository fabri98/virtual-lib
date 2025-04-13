package com.VirtualLibWeb.VirtualLib.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.VirtualLibWeb.VirtualLib.persistence.entity.LibroEntity;

import jakarta.transaction.Transactional;

@Repository
public interface ILibroRepository extends JpaRepository<LibroEntity, Long> {

       @Modifying
       @Transactional
       @Query("UPDATE LibroEntity l SET l.titulo = :titulo, l.autor = :autor, l.editorial = :editorial, " +
                     "l.genero = :genero, l.anioPublicacion = :anioPublicacion, " +
                     "l.cantidadEjemplaresDisponibles = :cantidadEjemplaresDisponibles WHERE l.isbn = :isbn")
       void updateLibro(
                     @Param("isbn") String isbn,
                     @Param("titulo") String titulo,
                     @Param("autor") String autor,
                     @Param("editorial") String editorial,
                     @Param("genero") String genero,
                     @Param("anioPublicacion") String anioPublicacion,
                     @Param("cantidadEjemplaresDisponibles") int cantidadEjemplaresDisponibles,
                     @Param("numeroDePaginas") int numero_de_paginas);

       boolean existsByIsbn(String isbn); // query method

       LibroEntity findByIsbn(String isbn);
}
