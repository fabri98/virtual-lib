package com.VirtualLibWeb.VirtualLib.prestamo.dto;

import java.time.LocalDate;
import java.util.List;

import com.VirtualLibWeb.VirtualLib.alumno.entity.AlumnoEntity;
import com.VirtualLibWeb.VirtualLib.libro.entity.LibroEntity;
import com.VirtualLibWeb.VirtualLib.prestamo.entity.PrestamoEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PrestamoDTO {

    private LibroEntity libro;

    private AlumnoEntity alumno;

    private LocalDate fechaPrestamo;

    private LocalDate fechaDevolucion;

    private boolean devuelto;
}
