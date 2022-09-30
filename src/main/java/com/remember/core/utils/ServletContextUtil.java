package com.remember.core.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class ServletContextUtil {
    public static String currentContext() {
        return ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
    }

    public static String currentRequestUriContext() {
        return ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
    }

    public static String currentRequestContext() {
        return ServletUriComponentsBuilder.fromCurrentRequest().toUriString();
    }
}
