package com.example.CATME.authorization;

import com.example.CATME.database.UserAuthorities;
import com.example.CATME.database.UserAuthoritiesImpl;
import com.example.CATME.database.UserLogInDBImpl;
import com.example.CATME.login.LoginService;
import com.example.CATME.login.LoginServiceImpl;
import com.example.CATME.login.UserLoginDAOImpl;
import com.example.CATME.user.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomAuthentication implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        LoginService loginService = new LoginServiceImpl(new UserLoginDAOImpl(), new UserLogInDBImpl());
        User u = loginService.findUserByEmail(name);

        if (u.getPassword().equals(password)) {

            UserAuthorities authorities = new UserAuthoritiesImpl();
            final List<GrantedAuthority> grantedAuths = authorities.getUserAuthorities(name);

            final UserDetails principal = new org.springframework.security.core.userdetails.User(name, password, grantedAuths);
            final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
            return auth;
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}