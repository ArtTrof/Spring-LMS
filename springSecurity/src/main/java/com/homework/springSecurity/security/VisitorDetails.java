package com.homework.springSecurity.security;

import com.homework.springSecurity.models.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class VisitorDetails implements UserDetails {
    private final Visitor visitor;

    @Autowired
    public VisitorDetails(Visitor visitor) {
        this.visitor = visitor;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(visitor.getRole()));
    }

    @Override
    public String getPassword() {
        return this.visitor.getPassword();
    }

    @Override
    public String getUsername() {
        return this.visitor.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Visitor getVisitor() {
        return this.visitor;
    }
}
