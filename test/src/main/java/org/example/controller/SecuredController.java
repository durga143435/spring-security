package org.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredController {

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/secure/test")
    public String secureTest() {
        return "Success from Secure Endpoint";
    }
}
