package com.example.nicecleaning.service;


import com.example.nicecleaning.repo.AppUserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AppUserRepo appUserRepo;

    public UserDetailsServiceImpl(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {

        return (UserDetails) appUserRepo
                .findAppUsersByUsernameIgnoreCase(user)
                .orElseThrow();
    }
}
