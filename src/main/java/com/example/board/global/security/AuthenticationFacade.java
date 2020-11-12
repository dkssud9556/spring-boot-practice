package com.example.board.global.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public String getUsername() {
        Authentication auth = getAuthentication();
        if (auth.getPrincipal() instanceof AuthDetails) {
            return ((AuthDetails) auth.getPrincipal()).getUsername();
        } else {
            return getAuthentication().getName();
        }
    }
}
