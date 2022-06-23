package com.vahid.encyclopedia.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
public class User {

    @Id
    String id;
    String name;
    String username;
    String password;
    List<String> roles;

    public User(String name, String username, String password, String... roles) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = Arrays.asList(roles);
    }

    // @Override
    // public Collection<GrantedAuthority> getAuthorities() {
    //     return getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role)).collect(Collectors.toList());
    // }

    // @Override
    // public String getPassword() {
    //     return this.password;
    // }

    // @Override
    // public String getUsername() {
    //     return this.username;
    // }

    // @Override
    // public boolean isAccountNonExpired() {
    //     return true;
    // }

    // @Override
    // public boolean isAccountNonLocked() {
    //     return true;
    // }

    // @Override
    // public boolean isCredentialsNonExpired() {
    //     return true;
    // }

    // @Override
    // public boolean isEnabled() {
    //     return true;
    // }
    
}
