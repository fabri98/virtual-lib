package com.VirtualLibWeb.VirtualLib.libro.service.libro_interface;

import java.util.List;

import com.VirtualLibWeb.VirtualLib.libro.dto.LibroDTO;
import com.VirtualLibWeb.VirtualLib.libro.entity.LibroEntity;

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
