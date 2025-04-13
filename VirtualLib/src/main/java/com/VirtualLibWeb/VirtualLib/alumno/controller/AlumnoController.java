package com.VirtualLibWeb.VirtualLib.alumno.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.VirtualLibWeb.VirtualLib.alumno.dto.AlumnoDTO;
import com.VirtualLibWeb.VirtualLib.alumno.service.alumno_interface.IAlumnoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    private final IAlumnoService alumnoService;

    public AlumnoController(IAlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    // Formulario para guardar un alumno
    @GetMapping("/formulario")
    public String alumnosForm(Model model) {
        model.addAttribute("alumno", new AlumnoDTO());
        return "forms/form_alumno";
    }

    // Guarda un alumno
    @PostMapping("/guardar")
    public String saveAlumno(@Valid @ModelAttribute("alumno") AlumnoDTO alumnoDTO,
            BindingResult result, RedirectAttributes redirectAttributes) {

        if (alumnoService.existsByLegajo(alumnoDTO.getLegajo())) {
            result.rejectValue("legajo", "error.alumno", "El legajo ya está en uso");
        }
        if (result.hasErrors()) {
            return "forms/form_alumno";
        }

        try {
            alumnoService.saveAlumno(alumnoDTO);
            redirectAttributes.addFlashAttribute("success", "Alumno guardado correctamente");
        } catch (Exception __) {
            redirectAttributes.addFlashAttribute("error", "Error al guardar el alumno");
        }

        return "redirect:/alumnos";
    }

    // Lista todos lo alumnos
    @GetMapping
    public String findAll(Model model) {

        List<AlumnoDTO> alumnos = alumnoService.findAll();

        if (alumnos.isEmpty()) {
            model.addAttribute("mensaje", "No hay alumnos registrados actualmente.");
            return "alumnos/lista_alumnos";
        }
        model.addAttribute("alumnos", alumnos);
        return "alumnos/lista_alumnos";
    }

    // Elimina un alumno por su legajo
    @PostMapping("/eliminar/{legajo}")
    public String deleteAlumno(@PathVariable Long legajo, RedirectAttributes redirectAttributes) {
        try {
            alumnoService.delete(legajo);
            redirectAttributes.addFlashAttribute("success", "Alumno eliminado con éxito");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar el alumno");
        }
        return "redirect:/alumnos";
    }

    // Formulario para editar un alumno
    @GetMapping("/editar/{legajo}")
    public String editAlumno(@PathVariable Long legajo, Model model, RedirectAttributes redirectAttributes) {
    
        AlumnoDTO alumnoDTO = alumnoService.toDTO(alumnoService.findByLegajo(legajo));

        if (alumnoService.existsByLegajo(legajo)) {
            redirectAttributes.addAttribute("error", "El alumno no existe");
        }
        model.addAttribute("alumno", alumnoDTO);

        return "forms/edit_alumno";
    }

    // Actualiza un alumno
    @PostMapping("/actualizar/{legajo}")
    public String updateAlumno(@PathVariable Long legajo, @Valid @ModelAttribute("alumno") AlumnoDTO alumnoDTO,
            BindingResult result, RedirectAttributes redirectAttributes) {


        if (!alumnoService.validarEmail(alumnoDTO)) {
            result.rejectValue("email", "error.alumno", "El email ya está en uso");
        }

        if (result.hasErrors()) {
            return "forms/edit_alumno";
        }

        try {
            alumnoService.update(alumnoDTO);
            redirectAttributes.addFlashAttribute("success", "Alumno actualizado correctamente");
        } catch (Exception __) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar el alumno");
        }

        return "redirect:/alumnos";
    }

}
