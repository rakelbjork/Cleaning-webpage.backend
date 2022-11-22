package com.example.nicecleaning.controller;

import com.example.nicecleaning.dto.CreateAppUserDTO;
import com.example.nicecleaning.services.AppUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"http://localhost:3000"}, methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})
public class RegisterController {

    private final AppUserService appUserService;

    public RegisterController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping("/register")
    public void createAppUserDTO(@RequestBody CreateAppUserDTO createAppUserDTO){
        System.out.println(createAppUserDTO);
         appUserService.createUser(createAppUserDTO);
    }

    public String getUser(){
        return "newUser";
    }

}
