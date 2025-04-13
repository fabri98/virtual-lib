package com.VirtualLibWeb.VirtualLib.alumno.service.alumno_interface;

import java.util.List;

import com.VirtualLibWeb.VirtualLib.alumno.dto.AlumnoDTO;
import com.VirtualLibWeb.VirtualLib.alumno.entity.AlumnoEntity;

public interface IAlumnoService {
    void saveAlumno(AlumnoDTO alumnoDTO);
    List<AlumnoDTO> findAll();
    boolean existsByLegajo(Long legajo);
    AlumnoEntity findByLegajo(Long legajo);
    void delete(Long legajo);
    AlumnoEntity toEntity(AlumnoDTO alumnoDTO);
    AlumnoDTO toDTO(AlumnoEntity alumnoEntity);
    void update(AlumnoDTO alumnoDTO);
    boolean validarEmail(AlumnoDTO alumnoDTO);
    AlumnoEntity findByEmail(String email);
    boolean existsByEmail(String email);
   // List<AlumnoDTO> findByNombreContainingIgnoreCaseOrLegajoContainingIgnoreCase(String q);
}
