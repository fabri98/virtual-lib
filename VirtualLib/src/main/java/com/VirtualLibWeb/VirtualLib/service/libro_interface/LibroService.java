package com.VirtualLibWeb.VirtualLib.service.libro_interface;

import java.util.List;

import com.VirtualLibWeb.VirtualLib.persistence.entity.Libro;

public interface LibroService {

    void saveLibro(Libro libro);
    Libro findLibroById(Long id);
    List<Libro> findAll();
    void deleteLibro(Long id);
    void updateLibro(Libro libro);
}
