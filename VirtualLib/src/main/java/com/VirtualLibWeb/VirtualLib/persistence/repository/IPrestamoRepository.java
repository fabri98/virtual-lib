package com.VirtualLibWeb.VirtualLib.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VirtualLibWeb.VirtualLib.persistence.entity.PrestamoEntity;

@Repository
public interface IPrestamoRepository extends JpaRepository<PrestamoEntity, Long> {

    


}
