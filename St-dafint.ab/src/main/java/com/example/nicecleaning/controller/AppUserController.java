package com.example.nicecleaning.controller;

import com.example.nicecleaning.entities.AppUser;
import com.example.nicecleaning.dto.AppUserResponseDTO;
import com.example.nicecleaning.services.AppUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }



}
