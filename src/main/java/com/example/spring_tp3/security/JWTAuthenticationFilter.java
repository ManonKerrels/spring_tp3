package com.example.spring_tp3.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.spring_tp3.config.JWTProperties;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class JWTAuthenticationFilter extends OncePerRequestFilter {
    private final JWTProperties properties;

    public JWTAuthenticationFilter(JWTProperties properties) {
        this.properties = properties;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (token != null){

            token = token.replace(properties.getPrefix(), "");

            try{
                DecodedJWT jwt = JWT.require(Algorithm.HMAC512(properties.getSecret()))
                        .build()
                        .verify(token);

                if (jwt.getExpiresAt() != null && jwt.getExpiresAt().after(new Date())){
                    Authentication auth = new UsernamePasswordAuthenticationToken(
                            jwt.getSubject(),
                            "",
                            jwt.getClaim("roles").asList(String.class)
                                    .stream()
                                    .map(SimpleGrantedAuthority::new)
                                    .toList()
                    );

                    SecurityContextHolder.getContext().setAuthentication(auth);
                }

            } catch (JWTVerificationException ignored){ }

            filterChain.doFilter(request, response);
        }
    }
}
