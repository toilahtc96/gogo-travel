package com.travel.gogo.controller;

import com.travel.gogo.entity.CompanyInformation;
import com.travel.gogo.service.CompanyInformationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public/company-information")
@AllArgsConstructor
@CrossOrigin(origins = {"http://gogotravelvn.com/","https://gogotravalvn.com", "http://localhost:3000"})
public class CompanyInformationPublicController {

    private final CompanyInformationService companyInformationService;
    @GetMapping("/get-first-active")
    public ResponseEntity<CompanyInformation> getFirstActive() {
        CompanyInformation companyInformation = companyInformationService.getActive();
        if(companyInformation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(companyInformation);
    }
}
