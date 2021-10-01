package com.hai.las.security;

import com.hai.las.security.appuser.MyUserDetailsService;
import com.hai.las.security.jwt.JwtConfig;
import com.hai.las.security.jwt.JwtUtil;
import com.hai.las.security.model.AuthenticationRequest;
import com.hai.las.security.model.AuthenticationResponse;
import com.hai.las.security.model.GoogleAuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
public class AppRestControllerV1 implements AppOperations {

    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final JwtConfig jwtConfig;


    public AppRestControllerV1(MyUserDetailsService adminDetailsService,
                               JwtUtil jwtUtil,
                               JwtConfig jwtConfig,
                               AuthenticationManager authenticationManager) {
        this.userDetailsService = adminDetailsService;
        this.jwtUtil = jwtUtil;
        this.jwtConfig = jwtConfig;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public ResponseEntity<?> loginAuthentication(@RequestBody AuthenticationRequest authenticationRequest) throws BadCredentialsException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException ex) {
            throw new BadCredentialsException("Incorrect username or password");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @Override
    public ResponseEntity<?> loginAuthentication(GoogleAuthenticationRequest authenticationRequest) {
        return null;
    }
}

