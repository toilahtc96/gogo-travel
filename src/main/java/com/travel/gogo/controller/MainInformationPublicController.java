package com.travel.gogo.controller;

import com.travel.gogo.entity.MainInformation;
import com.travel.gogo.request.MainInformationRequest;
import com.travel.gogo.service.MainInformationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("public/main-information")
@AllArgsConstructor
@CrossOrigin(origins = {"http://gogotravelvn.com/","https://gogotravalvn.com", "http://localhost:3000"})
public class MainInformationPublicController {

    private final MainInformationService mainInformationService;

    @GetMapping("/get-first-active")
    public ResponseEntity<MainInformation> getFirstActive() {
        MainInformation firstActive = mainInformationService.getFirstActive();
        if (firstActive == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(firstActive);

    }
}
