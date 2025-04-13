package com.VirtualLibWeb.VirtualLib.auth.service.usuario_implementation;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.VirtualLibWeb.VirtualLib.auth.entity.UserEntity;
import com.VirtualLibWeb.VirtualLib.auth.repository.IUserRepository;
import com.VirtualLibWeb.VirtualLib.auth.service.usuario_interface.IUserService;

@Service
public class UserServiceImpl implements IUserService {


    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserEntity> findUserEntityByUsername(String username) {
        
        return userRepository.findUserEntityByUsername(username);
    }

 

}
