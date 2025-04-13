package com.VirtualLibWeb.VirtualLib.service.libro.libro_interface;

import java.util.List;

import com.VirtualLibWeb.VirtualLib.persistence.entity.LibroEntity;
import com.VirtualLibWeb.VirtualLib.presentation.controllers.libro.dto.LibroDTO;

public interface ILibroService {

    void saveLibro(LibroDTO libro);
    LibroEntity findLibroById(Long id);
    List<LibroDTO> findAll();
    void deleteLibro(String isbn);
    void updateLibro(LibroDTO libro);
    boolean existsByIsbn(String isbn);
    LibroEntity findByIsbn(String isbn);
    LibroDTO toDTO(LibroEntity libroEntity);
}
