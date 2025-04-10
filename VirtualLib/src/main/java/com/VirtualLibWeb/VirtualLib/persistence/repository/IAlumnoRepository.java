package com.VirtualLibWeb.VirtualLib.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VirtualLibWeb.VirtualLib.persistence.entity.AlumnoEntity;

@Repository
public interface IAlumnoRepository extends JpaRepository<AlumnoEntity, Long>{
    boolean existsByLegajo(Long legajo);
    AlumnoEntity findByLegajo(Long legajo);
}
