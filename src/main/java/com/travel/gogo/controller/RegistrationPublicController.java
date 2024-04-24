package com.travel.gogo.controller;

import com.travel.gogo.entity.Registrations;
import com.travel.gogo.request.RegistrationRequest;
import com.travel.gogo.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("public/registration")
@AllArgsConstructor
@CrossOrigin(origins = {"http://gogotravelvn.com/","https://gogotravalvn.com", "http://localhost:3000"})
public class RegistrationPublicController {
    private final RegistrationService registrationService;

    @PostMapping("/add")
    public ResponseEntity addRegistration(@RequestBody RegistrationRequest registrationRequest) {
        registrationService.addRegistration(registrationRequest);
        return ResponseEntity.noContent().build();
    }
}
