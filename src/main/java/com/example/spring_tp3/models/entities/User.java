package com.example.spring_tp3.models.entities;

import com.example.spring_tp3.repository.UserRepository;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "email", length = 50)
    private String email;

    private boolean isNotLocked = true;

    @ManyToMany
    private List<Game> games = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles().stream()
                .map( SimpleGrantedAuthority::new )
                .toList();
    }

    @Override
    public boolean isAccountNonExpired() { return isNotLocked; }

    @Override
    public boolean isAccountNonLocked() { return isNotLocked; }

    @Override
    public boolean isCredentialsNonExpired() { return isNotLocked; }

    @Override
    public boolean isEnabled() { return isNotLocked; }

}
