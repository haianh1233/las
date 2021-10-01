package com.hai.las.security.filter;

import com.hai.las.security.jwt.JwtConfig;
import com.hai.las.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {


    private final JwtUtil jwtUtil;
    private final JwtConfig jwtConfig;
    private final UserDetailsService userDetailsService;

    @Autowired
    public JwtRequestFilter(JwtUtil jwtUtil, JwtConfig jwtConfig, UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.jwtConfig = jwtConfig;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(javax.servlet.http.HttpServletRequest request,
                                    javax.servlet.http.HttpServletResponse response,
                                    javax.servlet.FilterChain filterChain) throws ServletException, IOException {

        final String authorizationHeader = request.getHeader(jwtConfig.getAuthorizationHeader());
        String jwt = null;
        String username = null;
        HashMap<String, Object> informations = null;
        String role = null;

        if(authorizationHeader != null && authorizationHeader.startsWith(jwtConfig.getTokenPrefix() + " ")) {
            jwt = authorizationHeader.replace(jwtConfig.getTokenPrefix() + " ", "");
            username = jwtUtil.extractUsername(jwt);
            informations = (HashMap<String, Object>) jwtUtil.extractAllClaims(authorizationHeader);
            role = (String) informations.get("role");
        }

        if(username != null && role != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if(userDetails.isAccountNonLocked()
                        && userDetails.isEnabled()
                        && jwtUtil.validateToken(jwt, userDetails)) {

                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities()
                    );

                    usernamePasswordAuthenticationToken
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }


            filterChain.doFilter(request, response);
        }
    }
}
