package com.VirtualLibWeb.VirtualLib.auth.service.usuario_interface;

import java.util.Optional;

import com.VirtualLibWeb.VirtualLib.auth.entity.UserEntity;

public interface IUserService {
    Optional<UserEntity> findUserEntityByUsername(String username);
}
