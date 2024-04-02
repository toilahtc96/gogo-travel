package com.travel.gogo.controller;

import com.travel.gogo.entity.MainInformation;
import com.travel.gogo.request.MainInformationRequest;
import com.travel.gogo.service.MainInformationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = {"http://gogotravelvn.com/", "http://localhost:3000"})
public class MainInformationController {

    private final MainInformationService mainInformationService;

    @PostMapping("/add")
    public ResponseEntity addMainInformation(@RequestBody MainInformationRequest mainInformationRequest) {
        mainInformationService.addMainInformation(mainInformationRequest);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<MainInformation>> getAllMainInformation() {
        List<MainInformation> mainInformations = mainInformationService.getAll();
        return ResponseEntity.ok(mainInformations);
    }

    @GetMapping("/get-first-active")
    public ResponseEntity<MainInformation> getFirstActive() {
        MainInformation firstActive = mainInformationService.getFirstActive();
        if (firstActive == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(firstActive);

    }

    @GetMapping("/get-by-id")
    public ResponseEntity getById(@RequestParam int id) {
        MainInformation mainInformation = mainInformationService.getMainInforById(id);
        if (mainInformation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mainInformation);
    }

    @PostMapping("/edit")
    public ResponseEntity edit(@RequestBody MainInformationRequest mainInformationRequest) {
        if (mainInformationService.editMainInfor(mainInformationRequest)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam int id) {
        if (mainInformationService.deleteMainInfor(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
