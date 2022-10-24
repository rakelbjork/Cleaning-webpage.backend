package com.example.nicecleaning.controller;


import com.example.nicecleaning.dto.AppUserResponseDTO;
import com.example.nicecleaning.entities.AppUser;
import com.example.nicecleaning.security.AuthService;
import com.example.nicecleaning.service.AppUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = {"http://localhost:3000"}, methods = {RequestMethod.GET, RequestMethod.OPTIONS})
public class AppUserController {

    private final AppUserService appUserService;
    private final AuthService authService;

    public AppUserController(AppUserService appUserService, AuthService authService) {
        this.appUserService = appUserService;
        this.authService = authService;
    }

    @GetMapping
    public List<AppUserResponseDTO> findAllUsers(){
        return appUserService.findAll()
                .stream()
                .map(AppUser::toResponseDTO)
                .toList();
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        appUserService.deleteById(id);
    }
}
