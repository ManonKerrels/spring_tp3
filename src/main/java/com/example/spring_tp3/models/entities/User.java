package com.example.spring_tp3.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private boolean isNotLocked = true;

    @ElementCollection(fetch = FetchType.EAGER)
    List<String> roles;

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
