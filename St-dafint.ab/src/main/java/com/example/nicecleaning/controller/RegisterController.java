package com.example.nicecleaning.controller;

import com.example.nicecleaning.dto.CreateAppUserDTO;
import com.example.nicecleaning.services.AppUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

    private final AppUserService appUserService;

    public RegisterController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PutMapping("/register")
    public void createAppUserDTO(@RequestBody CreateAppUserDTO createAppUserDTO){
        System.out.println(createAppUserDTO);
         appUserService.createUser(createAppUserDTO);
    }

    public String getUser(){
        return "newUser";
    }

}
