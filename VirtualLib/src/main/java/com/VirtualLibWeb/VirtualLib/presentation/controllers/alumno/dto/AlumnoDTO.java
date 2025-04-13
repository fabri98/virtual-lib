package com.VirtualLibWeb.VirtualLib.presentation.controllers.alumno.dto;

import com.VirtualLibWeb.VirtualLib.utils.validacion.ValidacionMensaje;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlumnoDTO {

    @NotNull(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Min(value = 10000, message = ValidacionMensaje.LEGAJO_INVALIDO)
    @Max(value = 99999, message = ValidacionMensaje.LEGAJO_INVALIDO)
    private Long legajo;

    @NotBlank(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Size(min = 2, max = 50)
    private String nombre;

    @NotBlank(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Size(min = 2, max = 50)
    private String apellido;

    @NotBlank(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Pattern(regexp = "^\\+54\\d{10}$", message = ValidacionMensaje.FORMATO_TELEFONO_INVALIDO)
    private String telefono;

    @NotBlank(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Email(message = ValidacionMensaje.FORMATO_EMAIL_INVALIDO)
    private String email;
}
