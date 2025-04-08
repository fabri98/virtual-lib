package com.VirtualLibWeb.VirtualLib.persistence.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails{

    private final UserEntity userEntity;

    public UserDetailsImpl(UserEntity userEntity){
        this.userEntity = userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        userEntity.getRoles()
                .forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRole().name()))));

        userEntity.getRoles()
                .stream()
                .flatMap(role -> role.getPermissions().stream())
                .forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getPermission().name())));
      
        return authorityList;
    }

    @Override
    public String getPassword() {
       
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
       
        return userEntity.getUsername();
    }

    public String getNombre(){
        return userEntity.getNombre();
    }

    public String getApellido(){
        return userEntity.getApellido();
    }

    public String getFullName(){
        return getNombre() + ' ' + getApellido();
    }
}
