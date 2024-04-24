package com.travel.gogo.controller;

import com.travel.gogo.entity.Role;
import com.travel.gogo.request.RoleRequest;
import com.travel.gogo.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/role")
@AllArgsConstructor
@CrossOrigin(origins = {"http://gogotravelvn.com/","https://gogotravalvn.com", "http://localhost:3000"})
public class RoleController {
    private final RoleService roleService;

    @PostMapping("/add")
    public ResponseEntity addRole(@RequestBody RoleRequest roleRequest) {
        roleService.addRole(roleRequest);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/edit")
    public ResponseEntity editRole(@RequestBody RoleRequest roleRequest) {
        if(roleService.editRole(roleRequest)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<Role> getById(@RequestParam int id) {
        Role role = roleService.getById(id);
        if(role == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(role);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Role>> getAll() {
        List<Role> roles = roleService.getAll();
        return ResponseEntity.ok(roles);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteById(@RequestParam int id) {
        if(roleService.deleteById(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
