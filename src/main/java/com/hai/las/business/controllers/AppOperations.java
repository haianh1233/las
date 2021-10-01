package com.hai.las.security;

import com.hai.las.security.model.AuthenticationRequest;
import com.hai.las.security.model.GoogleAuthenticationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/default")
public interface AppOperations {

    @PostMapping("/authenticate")
    public ResponseEntity<?> loginAuthentication(@RequestBody AuthenticationRequest authenticationRequest);

    @PostMapping("/google-login")
    public ResponseEntity<?> loginAuthentication(@RequestBody GoogleAuthenticationRequest authenticationRequest);
}


