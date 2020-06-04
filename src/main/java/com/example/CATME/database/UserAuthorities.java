package com.example.CATME.database;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public interface UserAuthorities {
    public List<GrantedAuthority> getUserAuthorities(String username);
}
