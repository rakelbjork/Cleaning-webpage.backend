package com.example.nicecleaning.services;

import com.example.nicecleaning.dto.WhoAmIDTO;
import com.example.nicecleaning.entities.AppUser;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public LoginService(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }


    public ResponseEntity<String> login(String username, String password) {
        AppUser appUser = (AppUser) userDetailsService.loadUserByUsername(username);

        if(passwordEncoder.matches(password,appUser.getPassword())){
            return ResponseEntity.ok(jwtUtil.generateToken(appUser));
        } else {
            return ResponseEntity.status(401).body("Username or password is incorrect");
        }
    }

    public WhoAmIDTO whoAmIDTO(String token){
        return jwtUtil.parseToken(token);
    }
}
