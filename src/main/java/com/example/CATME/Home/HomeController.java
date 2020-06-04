package com.example.CATME.Home;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        UserDetails user = (UserDetails) getContext().getAuthentication().getPrincipal();
        System.out.print(user.getUsername());
        System.out.print(user.getAuthorities());
        return "home";
    }
}
