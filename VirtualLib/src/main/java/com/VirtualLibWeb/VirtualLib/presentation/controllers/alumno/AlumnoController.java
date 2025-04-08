package com.VirtualLibWeb.VirtualLib.presentation.controllers.alumno;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.VirtualLibWeb.VirtualLib.persistence.entity.AlumnoEntity;
import com.VirtualLibWeb.VirtualLib.service.alumnoService.alumno_interface.IAlumnoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    private final IAlumnoService alumnoService;


    public AlumnoController(IAlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/formulario")
    public String alumnosForm(Model model){
        model.addAttribute("alumno", new AlumnoEntity());
        return "forms/form_alumno";
    }

    @PostMapping("/guardar")
    public String saveAlumno(@Valid @ModelAttribute("alumno") AlumnoEntity alumnoEntity,
            BindingResult result, RedirectAttributes redirectAttributes) {

        if (alumnoService.existsByLegajo(alumnoEntity.getLegajo())) {
            result.rejectValue("legajo", "error.alumno", "El legajo ya está en uso");
        }
        if (result.hasErrors()) {
            return "forms/form_alumno";
        }

        try {
            alumnoService.saveAlumno(alumnoEntity);
            redirectAttributes.addFlashAttribute("success", "Alumno guardado correctamente");
        } catch (Exception __) {
            redirectAttributes.addFlashAttribute("error", "Error al guardar el alumno");
        }
        
        return "redirect:/";
    }
    
}
