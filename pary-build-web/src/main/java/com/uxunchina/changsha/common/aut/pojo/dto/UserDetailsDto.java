package com.uxunchina.changsha.common.aut.pojo.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 操作员信息整合
 * Created by leo on 2017/7/8.
 */
public class UserDetailsDto implements UserDetails {
    private String password;
    private String userName;
    private Collection<? extends GrantedAuthority> grantedAuthorities;
    public UserDetailsDto(String userName, String password,
                          Collection<? extends GrantedAuthority> grantedAuthorities) {
        this.password=password;
        this.userName=userName;
        this.grantedAuthorities=grantedAuthorities;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
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
}
