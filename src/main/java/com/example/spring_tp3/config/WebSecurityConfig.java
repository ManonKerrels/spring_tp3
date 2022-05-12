package com.example.spring_tp3.config;

import com.example.spring_tp3.security.JWTAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder encoder;
    private final JWTProperties properties;

    public WebSecurityConfig(PasswordEncoder encoder, JWTProperties properties) {
        this.encoder = encoder;
        this.properties = properties;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

//        http.httpBasic(); //= faire une simple connection sans jwt

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //pour ne pas garder de cookies

        http.headers().frameOptions().disable(); //éviter les censures mises par défaut (header)

        http.authorizeRequests().anyRequest().permitAll();

        http.addFilterBefore(new JWTAuthenticationFilter(properties), UsernamePasswordAuthenticationFilter.class);

//        http.authorizeRequests()
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/user").hasRole("USER")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}