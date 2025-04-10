package com.VirtualLibWeb.VirtualLib.presentation.controllers.alumno;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.VirtualLibWeb.VirtualLib.persistence.entity.AlumnoEntity;
import com.VirtualLibWeb.VirtualLib.presentation.controllers.alumno.dto.AlumnoDTO;
import com.VirtualLibWeb.VirtualLib.service.alumnoService.alumno_interface.IAlumnoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    private final IAlumnoService alumnoService;

    public AlumnoController(IAlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/formulario")
    public String alumnosForm(Model model) {
        model.addAttribute("alumno", new AlumnoEntity());
        return "forms/form_alumno";
    }

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

    @GetMapping
    public String findAll(Model model) {

        List<AlumnoEntity> alumnos = alumnoService.findAll();

        if (alumnos.isEmpty()) {
            model.addAttribute("mensaje", "No hay alumnos registrados actualmente.");
            return "alumnos/lista_alumnos";
        }
        model.addAttribute("alumnos", alumnos);
        return "alumnos/lista_alumnos";
    }

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

}
