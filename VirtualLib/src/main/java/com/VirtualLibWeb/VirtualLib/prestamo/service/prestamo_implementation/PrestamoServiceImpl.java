package com.VirtualLibWeb.VirtualLib.prestamo.service.prestamo_implementation;

import org.springframework.stereotype.Service;

import com.VirtualLibWeb.VirtualLib.prestamo.entity.PrestamoEntity;
import com.VirtualLibWeb.VirtualLib.prestamo.repository.IPrestamoRepository;
import com.VirtualLibWeb.VirtualLib.prestamo.service.prestamo_interface.IPrestamoService;

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
