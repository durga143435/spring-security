package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.security.UserAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest req, HttpServletResponse res) {
        UserAuthenticationToken token = new  UserAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(token);

        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(authentication);

        req.getSession(true)
                .setAttribute("SPRING_SECURITY_CONTEXT", context);


        return "Login Success!";
    }
}
