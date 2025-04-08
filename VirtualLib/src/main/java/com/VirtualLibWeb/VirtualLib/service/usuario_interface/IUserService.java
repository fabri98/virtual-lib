package com.VirtualLibWeb.VirtualLib.service.usuario_interface;

import java.util.Optional;

import com.VirtualLibWeb.VirtualLib.persistence.entity.UserEntity;

public interface IUserService {
    Optional<UserEntity> findUserEntityByUsername(String username);
}
