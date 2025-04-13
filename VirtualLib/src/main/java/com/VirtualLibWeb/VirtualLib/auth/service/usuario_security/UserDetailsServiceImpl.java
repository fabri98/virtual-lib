package com.VirtualLibWeb.VirtualLib.auth.service.usuario_security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.VirtualLibWeb.VirtualLib.auth.entity.UserDetailsImpl;
import com.VirtualLibWeb.VirtualLib.auth.entity.UserEntity;
import com.VirtualLibWeb.VirtualLib.auth.service.usuario_interface.IUserService;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    private final IUserService userService;

    public UserDetailsServiceImpl(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       UserEntity userEntity = userService.findUserEntityByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario no existe!"));

        return new UserDetailsImpl(userEntity);
    }

}
