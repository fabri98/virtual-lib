package com.VirtualLibWeb.VirtualLib.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "libros")
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;
    @Column(name = "autor", nullable = false, length = 100)
    private String autor;
    @Column(name = "editorial", nullable = false, length = 100)
    private String editorial;
    @Column(name = "isbn", nullable = false, length = 20, unique = true)
    private String isbn;
    @Column(name = "anio_publicacion", nullable = false, length = 4)
    private String anioPublicacion;
    @Column(name = "genero", nullable = false, length = 50)
    private String genero;
    @Column(name = "cantidad_ejemplares_disponibles", nullable = false)
    private int cantidadEjemplaresDisponibles;
    @Column(name = "cantidad_ejemplares_total", nullable = false)
    private int numeroDePaginas = 1;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getAutor() {
        return autor;
    }


    public void setAutor(String autor) {
        this.autor = autor;
    }


    public String getEditorial() {
        return editorial;
    }


    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }


    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public String getAnioPublicacion() {
        return anioPublicacion;
    }


    public void setAnioPublicacion(String anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }


    public String getGenero() {
        return genero;
    }


    public void setGenero(String genero) {
        this.genero = genero;
    }


    public int getCantidadEjemplaresDisponibles() {
        return cantidadEjemplaresDisponibles;
    }


    public void setCantidadEjemplaresDisponibles(int cantidadEjemplaresDisponibles) {
        this.cantidadEjemplaresDisponibles = cantidadEjemplaresDisponibles;
    }


    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }


    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }


    @Override
    public String toString() {
        return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", isbn="
                + isbn + ", anioPublicacion=" + anioPublicacion + ", genero=" + genero
                + ", cantidadEjemplaresDisponibles=" + cantidadEjemplaresDisponibles + ", numeroDePaginas="
                + numeroDePaginas + "]";
    }

    

    

}
