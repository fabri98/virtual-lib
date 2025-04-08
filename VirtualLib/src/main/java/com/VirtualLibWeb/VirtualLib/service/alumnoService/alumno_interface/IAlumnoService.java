package com.VirtualLibWeb.VirtualLib.service.alumnoService.alumno_interface;

import com.VirtualLibWeb.VirtualLib.persistence.entity.AlumnoEntity;

public interface IAlumnoService {
    void saveAlumno(AlumnoEntity alumnoEntity);
    boolean existsByLegajo(Long legajo);
}
