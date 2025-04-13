package com.VirtualLibWeb.VirtualLib.alumno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.VirtualLibWeb.VirtualLib.alumno.entity.AlumnoEntity;

import jakarta.transaction.Transactional;

@Repository
public interface IAlumnoRepository extends JpaRepository<AlumnoEntity, Long> {
        boolean existsByLegajo(Long legajo);
        boolean existsByEmail(String email);

        AlumnoEntity findByLegajo(Long legajo);
        AlumnoEntity findByEmail(String email);
        //List<AlumnoEntity> findByNombreContainingIgnoreCaseOrLegajoContainingIgnoreCase(String nombre, String legajo);

        @Modifying
        @Transactional
        @Query("UPDATE AlumnoEntity a SET a.nombre = :nombre, a.apellido = :apellido, " +
                        "a.telefono = :telefono, a.email = :email WHERE a.legajo = :legajo")
        void update(
                        @Param("legajo") Long legajo,
                        @Param("nombre") String nombre,
                        @Param("apellido") String apellido,
                        @Param("telefono") String telefono,
                        @Param("email") String email);


}
