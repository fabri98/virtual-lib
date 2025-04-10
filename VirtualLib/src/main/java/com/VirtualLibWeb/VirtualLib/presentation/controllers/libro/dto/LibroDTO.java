package com.VirtualLibWeb.VirtualLib.presentation.controllers.libro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibroDTO {


    private String isbn;

    private String titulo;

    private String autor;

    private String editorial;

    private String anioPublicacion;

    private String genero;

    private int cantidadEjemplaresDisponibles;

    private int numeroDePaginas;
}
