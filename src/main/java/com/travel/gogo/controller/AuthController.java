package com.travel.gogo.controller;

import com.travel.gogo.entity.Users;
import com.travel.gogo.request.LoginRequest;
import com.travel.gogo.request.RegisterRequest;
import com.travel.gogo.service.AuthenService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/authentication")
@CrossOrigin(origins = {"http://gogotravelvn.com/", "http://localhost:3000"})
public class AuthController {

    private final AuthenService authenService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        // Authenticate the user (e.g., using Spring Security's authentication manager)
        // If authentication is successful, generate a JWT
        String token = authenService.getTokenOfUser(request);
        if (token == null) {
            throw new AuthenticationServiceException("user not found");
        }
        return token;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequest request) {
        // Authenticate the user (e.g., using Spring Security's authentication manager)
        // If authentication is successful, generate a JWT
        Users users = authenService.register(request);
        if (users == null) {
            return  ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(users);
    }
}
