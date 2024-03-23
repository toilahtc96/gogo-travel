package com.travel.gogo.controller;

import com.travel.gogo.entity.Address;
import com.travel.gogo.request.AddressRequest;
import com.travel.gogo.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/address")
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody AddressRequest AddressRequest) {
        addressService.addAddress(AddressRequest);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/edit")
    public ResponseEntity editAddress(@RequestBody AddressRequest AddressRequest) {
        if(addressService.editAddress(AddressRequest)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<Address> getById(@RequestParam int id) {
        Address address = addressService.getById(id);
        if(address == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(address);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Address>> getAll() {
        List<Address> addresses = addressService.getAll();
        return ResponseEntity.ok(addresses);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteById(@RequestParam int id) {
        if(addressService.deleteById(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
