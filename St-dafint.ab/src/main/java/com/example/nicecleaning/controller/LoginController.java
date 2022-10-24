package com.example.nicecleaning.controller;

import com.example.nicecleaning.dto.LoginRequestDTO;
import com.example.nicecleaning.dto.WhoAmIDTO;
import com.example.nicecleaning.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"http://localhost:3000"}, methods = {RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.GET})
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return loginService.login(loginRequestDTO.user(), loginRequestDTO.password());
    }

    @GetMapping("/whoami")
    public WhoAmIDTO whoAmI(@RequestParam String token){
        return loginService.whoami(token);
    }

}
