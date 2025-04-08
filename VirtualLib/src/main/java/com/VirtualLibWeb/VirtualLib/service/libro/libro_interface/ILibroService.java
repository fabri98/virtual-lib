package com.VirtualLibWeb.VirtualLib.service.libro.libro_interface;

import java.util.List;

import com.VirtualLibWeb.VirtualLib.persistence.entity.LibroEntity;

public interface ILibroService {

    void saveLibro(LibroEntity libro);
    LibroEntity findLibroById(Long id);
    List<LibroEntity> findAll();
    void deleteLibro(Long id);
    void updateLibro(LibroEntity libro);
    boolean existsByIsbn(String isbn);
    LibroEntity findByIsbn(String isbn);
}
