package com.VirtualLibWeb.VirtualLib.service.libro.libro_implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.VirtualLibWeb.VirtualLib.persistence.entity.LibroEntity;
import com.VirtualLibWeb.VirtualLib.persistence.repository.LibroRepository;
import com.VirtualLibWeb.VirtualLib.service.libro.libro_interface.ILibroService;

@Service
public class LibroServiceImpl implements ILibroService {

    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public void saveLibro(LibroEntity libro) {

        libroRepository.save(libro);

    }

    public List<LibroEntity> findAll() {
        return libroRepository.findAll();
    }

    @Override
    public void deleteLibro(Long id) {
        libroRepository.deleteById(id);
    }

    @Override
    public LibroEntity findLibroById(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public void updateLibro(LibroEntity libro) {

        libroRepository.updateLibro(libro.getId(),
                libro.getTitulo(), libro.getAutor(), libro.getEditorial(), libro.getGenero(),
                libro.getAnioPublicacion(), libro.getCantidadEjemplaresDisponibles(), libro.getIsbn());

    }

    @Override
    public boolean existsByIsbn(String isbn) {
        return libroRepository.existsByIsbn(isbn);
    }

    @Override
    public LibroEntity findByIsbn(String isbn) {
        return libroRepository.findByIsbn(isbn);
    }

}
