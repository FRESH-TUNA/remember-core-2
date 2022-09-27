package com.remember.core.utils;

import com.remember.core.auth.RememberUserDetails;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtil {
    public RememberUserDetails getUserDetails() {
        Authentication authentication = getAuthentication();

        checkIsAuthenticated(authentication);

        return userDetailsExtract(authentication);
    }

    /*
     * helpers
     */
    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    private RememberUserDetails userDetailsExtract(Authentication authentication) {
        return (RememberUserDetails) authentication.getPrincipal();
    }

    private void checkIsAuthenticated(Authentication authentication) {
        if (authentication instanceof AnonymousAuthenticationToken)
            throw new RuntimeException();
    }
}
