package com.travel.gogo.entity;

import com.travel.gogo.constans.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users implements UserDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "name")
    private String name;

    
    @Column(name = "username")
    private String username;

    
    @Column(name = "password")
    private String password;
    
    @Column(name = "role_id")
    private int roleId;
    
    @Column(name = "full_name")
    private String fullName;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "created_time")
    private LocalDateTime createdTime;
    
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return a collection of user authorities (roles)
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER")); // Example role
        // Replace with your logic to retrieve user roles from database or other source
        return authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Replace with logic to check account expiration if needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Replace with logic to check account lock status if needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Replace with logic to check credential expiration if needed
    }

    @Override
    public boolean isEnabled() {
        return true; // Replace with logic to check account enabled status if needed
    }
}
