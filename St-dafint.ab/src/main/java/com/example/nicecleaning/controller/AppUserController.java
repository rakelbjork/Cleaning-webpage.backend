package com.example.nicecleaning.controller;


import com.example.nicecleaning.dto.AppUserResponseDTO;
import com.example.nicecleaning.security.AuthService;
import com.example.nicecleaning.service.AppUserService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{email}")
    public AppUserResponseDTO findAppUserByEmail(@PathVariable("email")String email){
        return appUserService.findAppUserByEmail(email).toResponseDTO();
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        appUserService.deleteById(id);
    }
}
