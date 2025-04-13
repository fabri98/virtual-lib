package com.VirtualLibWeb.VirtualLib.libro.dto;

import com.VirtualLibWeb.VirtualLib.utils.validacion.ValidacionMensaje;

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
public class LibroDTO {

    @NotBlank(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Size(min = 13, max = 13, message = ValidacionMensaje.ISBN_INVALIDO)
    @Pattern(regexp = "\\d+", message = ValidacionMensaje.ISBN_INVALIDO)
    private String isbn;

    @NotBlank(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Size(min = 1, max = 100)
    private String titulo;

    @NotBlank(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Size(min = 1, max = 100)
    private String autor;

    @NotBlank(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Size(min = 1, max = 100)
    private String editorial;

    @NotBlank(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Size(min = 1, max = 100)
    private String anioPublicacion;

    @NotBlank(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Size(min = 1, max = 50)
    private String genero;

    @NotNull(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Min(1)
    private int cantidadEjemplaresDisponibles;

    @NotNull(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Min(1)
    private int numeroDePaginas;
}
