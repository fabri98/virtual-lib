package com.VirtualLibWeb.VirtualLib.presentation.controllers.libro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.VirtualLibWeb.VirtualLib.persistence.entity.LibroEntity;
import com.VirtualLibWeb.VirtualLib.presentation.controllers.libro.dto.LibroDTO;
import com.VirtualLibWeb.VirtualLib.service.libro.libro_interface.ILibroService;

import jakarta.validation.Valid;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/libros")
public class LibroController {

    private final ILibroService libroService;

    public LibroController(ILibroService libroService) {
        this.libroService = libroService;
    }

    // Formulario para guardar un libro
    @GetMapping("/formulario")
    public String librosForm(Model model) {
        model.addAttribute("libro", new LibroDTO());
        return "forms/form_libro";
    }

    // Guarda el libro
    @PostMapping("/guardar")
    public String saveLibro(@Valid @ModelAttribute("libro") LibroDTO libroDTO,
            BindingResult result, RedirectAttributes redirectAttributes) {

        if (libroService.existsByIsbn(libroDTO.getIsbn())) {
            result.rejectValue("isbn", "error.libroDTO", "El ISBN ya está en uso");
        }

        if (result.hasErrors()) {
            return "forms/form_libro";
        }

        try {
            libroService.saveLibro(libroDTO);
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

    // Busca un libro por ID, para eliminarlo
    @PostMapping("/eliminar/{isbn}")
    public String deleteLibro(@PathVariable String isbn, RedirectAttributes redirectAttributes) {

        try {
            libroService.deleteLibro(isbn);
            redirectAttributes.addFlashAttribute("success", "Libro eliminado correctamente");
        } catch (Exception __) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar el libro");
        }
        return "redirect:/libros";
    }


    // Formulario de edicion
    @GetMapping("/editar/{isbn}")
    public String editLibro(@PathVariable String isbn, Model model, RedirectAttributes redirectAttributes) {
        LibroEntity libroEntity = libroService.findByIsbn(isbn);
        if (libroEntity == null) {
            redirectAttributes.addFlashAttribute("error", "El libro no existe");
            return "redirect:/libros";
        }
        model.addAttribute("libro", libroEntity);
        return "forms/edit_libro";
    }

    // Actualiza el libro
    @PostMapping("/actualizar/{id}")
    public String updateLibro(@PathVariable Long id, @Valid @ModelAttribute("libro") LibroEntity libro,
            BindingResult result, RedirectAttributes redirectAttributes) {

        LibroEntity libroBuscado = libroService.findByIsbn(libro.getIsbn());

        if (libroBuscado != null && !libroBuscado.getId().equals(id)) {
            result.rejectValue("isbn", "error.libro", "El ISBN ya está en uso");
        }

        if (result.hasErrors()) {
            return "forms/edit_libro";
        }

        try {
            libroService.updateLibro(libro);
            redirectAttributes.addFlashAttribute("success", "Libro actualizado correctamente");
        } catch (Exception __) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar el libro");
        }

        return "redirect:/libros";
    }

}
