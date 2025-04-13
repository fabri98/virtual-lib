package com.VirtualLibWeb.VirtualLib.prestamo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VirtualLibWeb.VirtualLib.prestamo.entity.PrestamoEntity;

@Repository
public interface IPrestamoRepository extends JpaRepository<PrestamoEntity, Long> {

    


}
