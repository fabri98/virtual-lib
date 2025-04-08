package com.VirtualLibWeb.VirtualLib.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.VirtualLibWeb.VirtualLib.persistence.entity.Libro;

import jakarta.transaction.Transactional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

       @Modifying
       @Transactional
       @Query("UPDATE Libro l SET l.titulo = :titulo, l.autor = :autor, l.editorial = :editorial, " +
                     "l.genero = :genero, l.anioPublicacion = :anioPublicacion, " +
                     "l.cantidadEjemplaresDisponibles = :cantidadEjemplaresDisponibles, " +
                     "l.isbn = :isbn WHERE l.id = :id")
       void updateLibro(@Param("id") Long id,
                     @Param("titulo") String titulo,
                     @Param("autor") String autor,
                     @Param("editorial") String editorial,
                     @Param("genero") String genero,
                     @Param("anioPublicacion") String anioPublicacion,
                     @Param("cantidadEjemplaresDisponibles") int cantidadEjemplaresDisponibles,
                     @Param("isbn") String isbn);
}
