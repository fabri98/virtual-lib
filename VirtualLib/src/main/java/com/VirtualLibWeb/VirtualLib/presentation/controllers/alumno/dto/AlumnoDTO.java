package com.VirtualLibWeb.VirtualLib.presentation.controllers.alumno.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlumnoDTO {

    private Long legajo;

    private String nombre;

    private String apellido;

    private String telefono;

    private String email;
}
