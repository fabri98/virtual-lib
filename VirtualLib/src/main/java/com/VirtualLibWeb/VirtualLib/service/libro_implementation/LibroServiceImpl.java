package com.VirtualLibWeb.VirtualLib.service.libro_implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.VirtualLibWeb.VirtualLib.persistence.entity.Libro;
import com.VirtualLibWeb.VirtualLib.persistence.repository.LibroRepository;
import com.VirtualLibWeb.VirtualLib.service.libro_interface.LibroService;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public void saveLibro(Libro libro) {

        libroRepository.save(libro);

    }

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    @Override
    public void deleteLibro(Long id) {
        libroRepository.deleteById(id);
    }

    @Override
    public Libro findLibroById(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public void updateLibro(Libro libro) {

        libroRepository.updateLibro(libro.getId(), libro.getTitulo(), libro.getAutor(), libro.getEditorial(), libro.getGenero(), libro.getAnioPublicacion(), libro.getCantidadEjemplaresDisponibles(), libro.getIsbn());

    }


}
