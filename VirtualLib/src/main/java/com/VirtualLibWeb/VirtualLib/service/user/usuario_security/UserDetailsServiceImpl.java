package com.VirtualLibWeb.VirtualLib.service.user.usuario_security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.VirtualLibWeb.VirtualLib.persistence.entity.UserDetailsImpl;
import com.VirtualLibWeb.VirtualLib.persistence.entity.UserEntity;
import com.VirtualLibWeb.VirtualLib.service.user.usuario_interface.IUserService;


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
