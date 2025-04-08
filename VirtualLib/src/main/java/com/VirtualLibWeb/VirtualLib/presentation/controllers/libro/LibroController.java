package com.VirtualLibWeb.VirtualLib.presentation.controllers.libro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.VirtualLibWeb.VirtualLib.persistence.entity.Libro;
import com.VirtualLibWeb.VirtualLib.service.libro_interface.LibroService;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    // Formulario para guardar un libro
    @GetMapping("/formulario")
    public String librosForm(Model model) {
        model.addAttribute("libro", new Libro());
        return "forms/form_libro";
    }

    // Guardamos el libro
    @PostMapping("/guardar")
    public String saveLibro(@ModelAttribute Libro libro, RedirectAttributes redirectAttributes) {
        try {
            libroService.saveLibro(libro);
            redirectAttributes.addFlashAttribute("success", "Libro guardado correctamente");
        } catch (Exception __) {
            redirectAttributes.addFlashAttribute("error", "Error al guardar el libro");
        }
        return "redirect:/libros";
    }

    // Listamos los libros
    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("libros", libroService.findAll());
        return "libros/lista_libros";
    }

    // Buscamos un libro por ID, para eliminarlo
    @PostMapping("/eliminar/{id}")
    public String deleteLibro(@PathVariable Long id, RedirectAttributes redirectAttributes) {

        try {
            libroService.deleteLibro(id);
            redirectAttributes.addFlashAttribute("success", "Libro eliminado correctamente");
        } catch (Exception __) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar el libro");
        }
        return "redirect:/libros";
    }


    @GetMapping("/editar/{id}")
    public String editLibro(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Libro libro = libroService.findLibroById(id);
        if (libro == null) {
            redirectAttributes.addFlashAttribute("error", "El libro no existe");
            return "redirect:/libros";
        }
        model.addAttribute("libro", libro);
        return "forms/edit_libro";
    }

    @PostMapping("/actualizar/{id}")
    public String updateLibro(@PathVariable Long id, @ModelAttribute("libro") Libro libro,
                              BindingResult result, RedirectAttributes redirectAttributes) {

        
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar el libro");
            return "forms/edit_libro";
        }
        try{
            libroService.updateLibro(libro);
            redirectAttributes.addFlashAttribute("success", "Libro actualizado correctamente");
        }catch (Exception __){
            redirectAttributes.addFlashAttribute("error", "Error al actualizar el libro");
        }
        

        return "redirect:/libros";
    }
    

}
