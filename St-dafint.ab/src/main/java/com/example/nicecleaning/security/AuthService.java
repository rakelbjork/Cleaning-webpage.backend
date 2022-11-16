package com.example.nicecleaning.security;

import com.example.nicecleaning.entities.AppUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public static boolean idMatchesUser(int id){
        AppUser appUser = (AppUser) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        return appUser.getId() == id;
    }
}
