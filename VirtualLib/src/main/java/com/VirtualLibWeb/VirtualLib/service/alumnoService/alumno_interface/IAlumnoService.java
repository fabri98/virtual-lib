package com.VirtualLibWeb.VirtualLib.service.alumnoService.alumno_interface;

import java.util.List;

import com.VirtualLibWeb.VirtualLib.persistence.entity.AlumnoEntity;
import com.VirtualLibWeb.VirtualLib.presentation.controllers.alumno.dto.AlumnoDTO;

public interface IAlumnoService {
    void saveAlumno(AlumnoDTO alumnoDTO);
    List<AlumnoEntity> findAll();
    boolean existsByLegajo(Long legajo);
    AlumnoEntity findByLegajo(Long legajo);
    void delete(Long legajo);
    AlumnoEntity toEntity(AlumnoDTO alumnoDTO);
    AlumnoDTO toDTO(AlumnoEntity alumnoEntity);
    void update(AlumnoEntity alumnoEntity);
}
