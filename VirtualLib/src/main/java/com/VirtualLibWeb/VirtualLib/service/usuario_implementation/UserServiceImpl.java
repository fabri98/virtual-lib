package com.VirtualLibWeb.VirtualLib.service.usuario_implementation;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.VirtualLibWeb.VirtualLib.persistence.entity.UserEntity;
import com.VirtualLibWeb.VirtualLib.persistence.repository.IUserRepository;
import com.VirtualLibWeb.VirtualLib.service.usuario_interface.IUserService;

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
