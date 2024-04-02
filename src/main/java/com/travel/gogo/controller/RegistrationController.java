package com.travel.gogo.controller;

import com.travel.gogo.entity.Registrations;
import com.travel.gogo.request.RegistrationRequest;
import com.travel.gogo.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/registration")
@AllArgsConstructor
@CrossOrigin(origins = {"http://gogotravelvn.com/", "http://localhost:3000"})
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping("/add")
    public ResponseEntity addRegistration(@RequestBody RegistrationRequest registrationRequest) {
        registrationService.addRegistration(registrationRequest);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/edit")
    public ResponseEntity editRegistration(@RequestBody RegistrationRequest registrationRequest) {
        if (registrationService.editRegistration(registrationRequest)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<Registrations> getById(@RequestParam int id) {
        Registrations registration = registrationService.getById(id);
        if (registration == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(registration);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Registrations>> getAll() {
        List<Registrations> registrations = registrationService.getAll();
        return ResponseEntity.ok(registrations);
    }

    @GetMapping("/get-page")
    public ResponseEntity<List<Registrations>> getPage(@RequestParam("size") int size, @RequestParam("page") int page) {
        List<Registrations> registrations = registrationService.getPage(page, size);
        return ResponseEntity.ok(registrations);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteById(@RequestParam int id) {
        if (registrationService.deleteById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
