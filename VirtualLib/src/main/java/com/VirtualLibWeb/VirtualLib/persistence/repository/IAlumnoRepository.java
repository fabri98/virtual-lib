package com.VirtualLibWeb.VirtualLib.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.VirtualLibWeb.VirtualLib.persistence.entity.AlumnoEntity;

import jakarta.transaction.Transactional;

@Repository
public interface IAlumnoRepository extends JpaRepository<AlumnoEntity, Long> {
    boolean existsByLegajo(Long legajo);

    AlumnoEntity findByLegajo(Long legajo);

    @Modifying
    @Transactional
    @Query("UPDATE AlumnoEntity a SET a.legajo = :legajo, a.nombre = :nombre, a.apellido = :apellido, " +
            "a.telefono = :telefono, a.email = :email WHERE a.id = :id")
    void update(@Param("id") Long id,
            @Param("legajo") Long legajo,
            @Param("nombre") String nombre,
            @Param("apellido") String apellido,
            @Param("telefono") String telefono,
            @Param("email") String email);
}
