package com.VirtualLibWeb.VirtualLib.service.alumnoService.alumno_implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.VirtualLibWeb.VirtualLib.persistence.entity.AlumnoEntity;
import com.VirtualLibWeb.VirtualLib.persistence.repository.IAlumnoRepository;
import com.VirtualLibWeb.VirtualLib.presentation.controllers.alumno.dto.AlumnoDTO;
import com.VirtualLibWeb.VirtualLib.service.alumnoService.alumno_interface.IAlumnoService;

@Service
public class AlumnoServiceImpl implements IAlumnoService{

    private final IAlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(IAlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public AlumnoEntity toEntity(AlumnoDTO alumnoDTO) {
        AlumnoEntity alumnoEntity = AlumnoEntity.builder()
        .legajo(alumnoDTO.getLegajo())
        .nombre(alumnoDTO.getNombre())
        .apellido(alumnoDTO.getApellido())
        .telefono(alumnoDTO.getTelefono())
        .email(alumnoDTO.getEmail())
        .build();

        return alumnoEntity;
    }

    @Override
    public AlumnoDTO toDTO(AlumnoEntity alumnoEntity) {
        
        AlumnoDTO alumnoDTO = AlumnoDTO.builder().build();

        return null;
    }

    @Override
    public void saveAlumno(AlumnoDTO alumnoDTO) {
        alumnoRepository.save(toEntity(alumnoDTO));
    }

    @Override
    public boolean existsByLegajo(Long legajo) {
        return alumnoRepository.existsByLegajo(legajo);
    }

    @Override
    public List<AlumnoEntity> findAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public void delete(Long legajo) {
        alumnoRepository.delete(findByLegajo(legajo));
    }

    @Override
    public AlumnoEntity findByLegajo(Long legajo) {
        return alumnoRepository.findByLegajo(legajo);
    }


}
