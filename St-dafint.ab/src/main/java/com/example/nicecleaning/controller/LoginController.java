package com.example.nicecleaning.controller;

import com.example.nicecleaning.dto.LoginRequestDTO;
import com.example.nicecleaning.dto.WhoAmIDTO;
import com.example.nicecleaning.services.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = {"http://localhost:3000"}, methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return loginService.login(loginRequestDTO.username(), loginRequestDTO.password());
    }

    @GetMapping("/whoami")
    public WhoAmIDTO whoAmIDTO(@RequestParam String token){
        return loginService.whoAmIDTO(token);
    }
    

}
