package com.VirtualLibWeb.VirtualLib.persistence.entity;

import com.VirtualLibWeb.VirtualLib.utils.ValidacionMensaje;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "libros")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LibroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "isbn", nullable = false, length = 20, unique = true)
    @NotBlank(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    private String isbn;

    @Column(name = "titulo", nullable = false, length = 100)
    @NotBlank(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Size(min = 1, max = 100)
    private String titulo;
    
    @Column(name = "autor", nullable = false, length = 100)
    @NotBlank(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Size(min = 1, max = 100)
    private String autor;
    
    @Column(name = "editorial", nullable = false, length = 100)
    @NotBlank(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Size(min = 1, max = 100)
    private String editorial;
    
    @Column(name = "anio_publicacion", nullable = false, length = 4)
    @NotBlank(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Size(min = 1, max = 100)
    private String anioPublicacion;
    
    @Column(name = "genero", nullable = false, length = 50)
    @NotBlank(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Size(min = 1, max = 50)
    private String genero;
    
    @Column(name = "cantidad_ejemplares_disponibles", nullable = false)
    @NotNull(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    private int cantidadEjemplaresDisponibles;
    
    @Column(name = "cantidad_ejemplares_total", nullable = false)
    @NotNull(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    private int numeroDePaginas = 1;


}
