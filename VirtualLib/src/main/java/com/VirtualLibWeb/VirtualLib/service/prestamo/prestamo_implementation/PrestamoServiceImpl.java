package com.VirtualLibWeb.VirtualLib.service.prestamo.prestamo_implementation;

import org.springframework.stereotype.Service;

import com.VirtualLibWeb.VirtualLib.persistence.entity.PrestamoEntity;
import com.VirtualLibWeb.VirtualLib.persistence.repository.IPrestamoRepository;
import com.VirtualLibWeb.VirtualLib.service.prestamo.prestamo_interface.IPrestamoService;

@Service
public class PrestamoServiceImpl implements IPrestamoService{

    private final IPrestamoRepository prestamoRepository;

    public PrestamoServiceImpl(IPrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;

    }

    public void save(PrestamoEntity prestamoEntity){
        prestamoRepository.save(prestamoEntity);
    }



}
