package com.VirtualLibWeb.VirtualLib.presentation.controllers.prestamo.dto;

import java.time.LocalDate;
import java.util.List;

import com.VirtualLibWeb.VirtualLib.persistence.entity.AlumnoEntity;
import com.VirtualLibWeb.VirtualLib.persistence.entity.LibroEntity;
import com.VirtualLibWeb.VirtualLib.persistence.entity.PrestamoEntity;

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
