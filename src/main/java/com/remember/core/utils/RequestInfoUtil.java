package com.remember.core.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class RequestInfoUtil {
    public String currentRoot() {
        return ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
    }

    public String currentRequestUri() {
        return ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
    }

    public String currentRequest() {
        return ServletUriComponentsBuilder.fromCurrentRequest().toUriString();
    }
}
