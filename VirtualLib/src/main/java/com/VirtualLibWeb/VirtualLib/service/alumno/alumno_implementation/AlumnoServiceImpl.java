package com.VirtualLibWeb.VirtualLib.service.alumno.alumno_implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.VirtualLibWeb.VirtualLib.persistence.entity.AlumnoEntity;
import com.VirtualLibWeb.VirtualLib.persistence.repository.IAlumnoRepository;
import com.VirtualLibWeb.VirtualLib.presentation.controllers.alumno.dto.AlumnoDTO;
import com.VirtualLibWeb.VirtualLib.service.alumno.alumno_interface.IAlumnoService;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

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

        AlumnoDTO alumnoDTO = AlumnoDTO.builder()
                .legajo(alumnoEntity.getLegajo())
                .nombre(alumnoEntity.getNombre())
                .apellido(alumnoEntity.getApellido())
                .telefono(alumnoEntity.getTelefono())
                .email(alumnoEntity.getEmail())
                .build();

        return alumnoDTO;
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
    public List<AlumnoDTO> findAll() {
        List<AlumnoEntity> alumnosEntity = alumnoRepository.findAll();
        List<AlumnoDTO> alumnosDTOs = new ArrayList<>();
        alumnosEntity.forEach(alumnoEntity -> {
            alumnosDTOs.add(toDTO(alumnoEntity));
        });
        return alumnosDTOs;
    }

    @Override
    public void delete(Long legajo) {
        alumnoRepository.delete(findByLegajo(legajo));
    }

    @Override
    public AlumnoEntity findByLegajo(Long legajo) {

        return alumnoRepository.findByLegajo(legajo);
    }

    @Override
    public void update(AlumnoDTO alumnoDTO) {
        alumnoRepository.update(alumnoDTO.getLegajo(), alumnoDTO.getNombre(),
                alumnoDTO.getApellido(), alumnoDTO.getTelefono(),
                alumnoDTO.getEmail());
    }

    @Override // falta corregir. NOTA: posiblemente hay que buscar por email en lugar de por legajo
    public boolean validarEmail(AlumnoDTO alumnoDTO) {

        if (existsByEmail(alumnoDTO.getEmail())) {
            AlumnoDTO alumnoBuscado = toDTO(findByEmail(alumnoDTO.getEmail()));

            if (!alumnoBuscado.getLegajo().equals(alumnoDTO.getLegajo())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public AlumnoEntity findByEmail(String email) {
        return alumnoRepository.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return alumnoRepository.existsByEmail(email);
    }

    // busca alumnos por nombre o legajo
    // @Override
    // public List<AlumnoDTO> findByNombreContainingIgnoreCaseOrLegajoContainingIgnoreCase(String q) {
    //     List<AlumnoEntity> alumnosEntity = alumnoRepository.findByNombreContainingIgnoreCaseOrLegajoContainingIgnoreCase(q, q);

    //     List<AlumnoDTO> alumnosDTO = new ArrayList<>();

    //     alumnosEntity.forEach(alumnoEntity ->{
    //         alumnosDTO.add(toDTO(alumnoEntity));
    //     });
    //     return alumnosDTO;
    // }


}
