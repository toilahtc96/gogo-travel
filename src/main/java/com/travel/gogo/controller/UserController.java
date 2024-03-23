package com.travel.gogo.controller;

import com.travel.gogo.entity.Users;
import com.travel.gogo.request.UserRequest;
import com.travel.gogo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity adduser(@RequestBody UserRequest userRequest) {
        userService.addUser(userRequest);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/edit")
    public ResponseEntity edituser(@RequestBody UserRequest userRequest) {
        if(userService.editUser(userRequest)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<Users> getById(@RequestParam int id) {
        Users user = userService.getById(id);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Users>> getAll() {
        List<Users> useres = userService.getAll();
        return ResponseEntity.ok(useres);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteById(@RequestParam int id) {
        if(userService.deleteById(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
