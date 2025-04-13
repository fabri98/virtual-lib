package com.VirtualLibWeb.VirtualLib.libro.service.libro_implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.VirtualLibWeb.VirtualLib.libro.dto.LibroDTO;
import com.VirtualLibWeb.VirtualLib.libro.entity.LibroEntity;
import com.VirtualLibWeb.VirtualLib.libro.repository.ILibroRepository;
import com.VirtualLibWeb.VirtualLib.libro.service.libro_interface.ILibroService;

@Service
public class LibroServiceImpl implements ILibroService {

    private final ILibroRepository libroRepository;

    public LibroServiceImpl(ILibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public LibroEntity toEntity(LibroDTO libroDTO) {

        LibroEntity libroEntity = LibroEntity.builder()
                .isbn(libroDTO.getIsbn())
                .titulo(libroDTO.getTitulo())
                .autor(libroDTO.getAutor())
                .editorial(libroDTO.getEditorial())
                .anioPublicacion(libroDTO.getAnioPublicacion())
                .genero(libroDTO.getGenero())
                .cantidadEjemplaresDisponibles(libroDTO.getCantidadEjemplaresDisponibles())
                .numeroDePaginas(libroDTO.getNumeroDePaginas())
                .build();
        return libroEntity;
    }

    @Override
    public LibroDTO toDTO(LibroEntity libroEntity) {
        LibroDTO libroDTO = LibroDTO.builder()
                .isbn(libroEntity.getIsbn())
                .titulo(libroEntity.getTitulo())
                .autor(libroEntity.getAutor())
                .editorial(libroEntity.getEditorial())
                .anioPublicacion(libroEntity.getAnioPublicacion())
                .genero(libroEntity.getGenero())
                .cantidadEjemplaresDisponibles(libroEntity.getCantidadEjemplaresDisponibles())
                .numeroDePaginas(libroEntity.getNumeroDePaginas())
                .build();
        return libroDTO;
    }

    public void saveLibro(LibroDTO libroDto) {

        libroRepository.save(toEntity(libroDto));

    }

    public List<LibroDTO> findAll() {

        List<LibroEntity> librosEntity = libroRepository.findAll();
        List<LibroDTO> librosDTOs = new ArrayList<>();

        librosEntity.forEach(libroEntity -> {
            librosDTOs.add(toDTO(libroEntity));
        });

        return librosDTOs;
    }

    @Override
    public void deleteLibro(String isbn) {
        libroRepository.delete(libroRepository.findByIsbn(isbn));
    }

    @Override
    public LibroEntity findLibroById(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public void updateLibro(LibroDTO libro) {

        libroRepository.updateLibro(
                libro.getIsbn(),
                libro.getTitulo(), libro.getAutor(), libro.getEditorial(), libro.getGenero(),
                libro.getAnioPublicacion(), libro.getCantidadEjemplaresDisponibles(),
                libro.getNumeroDePaginas());

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
