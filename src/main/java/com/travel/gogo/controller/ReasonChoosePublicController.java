package com.travel.gogo.controller;

import com.travel.gogo.entity.MainInformation;
import com.travel.gogo.entity.ReasonChoose;
import com.travel.gogo.service.MainInformationService;
import com.travel.gogo.service.ReasonChooseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("public/reason-choose")
@AllArgsConstructor
@CrossOrigin(origins = {"http://gogotravelvn.com/", "http://localhost:3000"})
public class ReasonChoosePublicController {

    private final ReasonChooseService reasonChooseService;
    private final Integer HOME_SIZE = 4;

    @GetMapping("/get-four-active")
    public ResponseEntity<List<ReasonChoose>> getFourActive() {
        List<ReasonChoose> reasonChooseServiceAll = reasonChooseService.getAllActive();
        if(reasonChooseServiceAll != null) {
            if(reasonChooseServiceAll.size() > HOME_SIZE) {
                reasonChooseServiceAll = reasonChooseServiceAll.subList(0,HOME_SIZE);
            }
            return ResponseEntity.ok(reasonChooseServiceAll);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
