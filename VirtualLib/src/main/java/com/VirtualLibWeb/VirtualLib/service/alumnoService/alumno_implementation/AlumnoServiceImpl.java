package com.VirtualLibWeb.VirtualLib.service.alumnoService.alumno_implementation;

import org.springframework.stereotype.Service;

import com.VirtualLibWeb.VirtualLib.persistence.entity.AlumnoEntity;
import com.VirtualLibWeb.VirtualLib.persistence.repository.IAlumnoRepository;
import com.VirtualLibWeb.VirtualLib.service.alumnoService.alumno_interface.IAlumnoService;

@Service
public class AlumnoServiceImpl implements IAlumnoService{

    private final IAlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(IAlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public void saveAlumno(AlumnoEntity alumnoEntity) {
        alumnoRepository.save(alumnoEntity);
    }

    @Override
    public boolean existsByLegajo(Long legajo) {
        return alumnoRepository.existsByLegajo(legajo);
    }

}
