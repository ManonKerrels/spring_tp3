package com.example.spring_tp3.metier.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.spring_tp3.config.JWTProperties;
import com.example.spring_tp3.models.forms.UserConnectForm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginService {


    private final JWTProperties jwtProperties;
    private final AuthenticationManager authenticationManager;

    public LoginService(JWTProperties jwtProperties, AuthenticationManager authenticationManager) {
        this.jwtProperties = jwtProperties;
        this.authenticationManager = authenticationManager;
    }

    public String login(UserConnectForm form) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword());
        authentication = authenticationManager.authenticate(authentication);

        return JWT.create()
                .withSubject(form.getUsername())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtProperties.getExpires()))
                .withClaim(
                        "roles",
                        authentication.getAuthorities()
                                .stream()
                                .map(GrantedAuthority::toString)
                                .toList()
                )
                .sign(Algorithm.HMAC512(jwtProperties.getSecret()));
    }
}
