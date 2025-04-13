package com.VirtualLibWeb.VirtualLib.presentation.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.VirtualLibWeb.VirtualLib.auth.entity.UserDetailsImpl;

@Controller
@RequestMapping("/")
public class DashboardController {

    @GetMapping
    public String dashboard(Model model) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    UserDetailsImpl user = (UserDetailsImpl) auth.getPrincipal();

    model.addAttribute("user", user);
    return "dashboard";
    }

    // Ejemplo usando OAuth2 
    // @GetMapping
    // public String dashboard(Model model, @AuthenticationPrincipal Object principal) {
    //     if (principal instanceof UserDetailsImpl userDetails) {
    //         model.addAttribute("nombre", userDetails.getFullName());
    //     } else if (principal instanceof DefaultOidcUser oidcUser) {

    //         model.addAttribute("nombre", oidcUser.getFullName());
    //     } else {
    //         model.addAttribute("nombre", "Invitado");
    //     }
    //     return "dashboard";
    // }
}
