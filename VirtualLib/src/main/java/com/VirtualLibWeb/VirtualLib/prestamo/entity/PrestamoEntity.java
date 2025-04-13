package com.VirtualLibWeb.VirtualLib.prestamo.entity;

import java.time.LocalDate;

import com.VirtualLibWeb.VirtualLib.alumno.entity.AlumnoEntity;
import com.VirtualLibWeb.VirtualLib.libro.entity.LibroEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prestamos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PrestamoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "isbn_libro" ,referencedColumnName = "isbn")
    private LibroEntity libro;

    @ManyToOne
    @JoinColumn(name = "legajo_alumno", referencedColumnName = "legajo")
    private AlumnoEntity alumno;

    @Column(name = "fecha_prestamo")
    private LocalDate fechaPrestamo;

    @Column(name = "fecha_devolucion")
    private LocalDate fechaDevolucion;

    @Column(name = "devuelto")
    private boolean devuelto;
}
