package com.VirtualLibWeb.VirtualLib.prestamo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.VirtualLibWeb.VirtualLib.alumno.entity.AlumnoEntity;
import com.VirtualLibWeb.VirtualLib.alumno.service.alumno_interface.IAlumnoService;
import com.VirtualLibWeb.VirtualLib.libro.entity.LibroEntity;
import com.VirtualLibWeb.VirtualLib.libro.service.libro_interface.ILibroService;
import com.VirtualLibWeb.VirtualLib.prestamo.dto.PrestamoDTO;
import com.VirtualLibWeb.VirtualLib.prestamo.entity.PrestamoEntity;
import com.VirtualLibWeb.VirtualLib.prestamo.service.prestamo_interface.IPrestamoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/prestamos")
public class PrestamoController {

    private final ILibroService libroService;
    private final IPrestamoService prestamoService;
    private final IAlumnoService alumnoService;

    public PrestamoController(ILibroService libroService, IPrestamoService prestamoService,
            IAlumnoService alumnoService) {
        this.libroService = libroService;
        this.prestamoService = prestamoService;
        this.alumnoService = alumnoService;
    }

    @GetMapping("/formulario/{isbn}")
    public String prestamoForm(@PathVariable String isbn, Model model) {

        model.addAttribute("libro", libroService.findByIsbn(isbn));
        return "prestamos/buscar_alumno";
    }

    @GetMapping("/buscar-alumno")
    public String buscarAlumno(@RequestParam Long legajo, @RequestParam(required = false) String isbn, Model model) {
        AlumnoEntity alumno = alumnoService.findByLegajo(legajo);
        LibroEntity libro = libroService.findByIsbn(isbn);
        model.addAttribute("alumnos", alumno);
        model.addAttribute("libro", libro);
        return "prestamos/buscar_alumno";
    }

    @GetMapping("/formulario/{isbn}/{legajo}")
    public String mostrarFormularioPrestamo(
            @PathVariable String isbn,
            @PathVariable Long legajo,
            Model model) {

        LibroEntity libro = libroService.findByIsbn(isbn);
        AlumnoEntity alumno = alumnoService.findByLegajo(legajo);

        if (libro == null || alumno == null) {
            model.addAttribute("error", "Libro o alumno no encontrado");
            return "redirect:/libros";
        }

        PrestamoDTO prestamoDTO = new PrestamoDTO();
        prestamoDTO.setLibro(libro);
        prestamoDTO.setAlumno(alumno);

        model.addAttribute("prestamo", prestamoDTO);
        model.addAttribute("libro", libro);
        model.addAttribute("alumno", alumno);
        return "forms/form_prestamo";
    }

    @PostMapping("/guardar")
    public String guardarPrestamo(@ModelAttribute PrestamoDTO prestamoDTO, Model model) {
        // Validar que el libro y alumno existan
        LibroEntity libro = libroService.findByIsbn(prestamoDTO.getLibro().getIsbn());
        AlumnoEntity alumno = alumnoService.findByLegajo(prestamoDTO.getAlumno().getLegajo());

        if (libro == null || alumno == null) {
            model.addAttribute("error", "Libro o alumno inválido");
            return "redirect:/libros";
        }

        // Crear entidad Prestamo
        PrestamoEntity nuevoPrestamo = new PrestamoEntity();
        nuevoPrestamo.setLibro(libro);
        nuevoPrestamo.setAlumno(alumno);
        nuevoPrestamo.setFechaPrestamo(prestamoDTO.getFechaPrestamo());
        nuevoPrestamo.setFechaDevolucion(prestamoDTO.getFechaDevolucion());

        prestamoService.save(nuevoPrestamo); // persistir

        return "redirect:/libros"; // o a donde quieras redirigir luego
    }

}
