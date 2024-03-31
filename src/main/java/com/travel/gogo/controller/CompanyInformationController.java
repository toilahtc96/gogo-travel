package com.travel.gogo.controller;

import com.travel.gogo.entity.CompanyInformation;
import com.travel.gogo.entity.Posts;
import com.travel.gogo.request.CompanyInformationRequest;
import com.travel.gogo.request.PostRequest;
import com.travel.gogo.service.CompanyInformationService;
import com.travel.gogo.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/company-information")
@AllArgsConstructor
public class CompanyInformationController {
    private final CompanyInformationService companyInformationService;

    @PostMapping("/add")
    public ResponseEntity addCompanyInformation(@RequestBody CompanyInformationRequest companyInformationRequest) {
        companyInformationService.add(companyInformationRequest);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/edit")
    public ResponseEntity editCompanyInformation(@RequestBody CompanyInformationRequest companyInformationRequest) {
        if(companyInformationService.edit(companyInformationRequest)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<CompanyInformation> getById(@RequestParam int id) {
        CompanyInformation companyInformation = companyInformationService.getById(id);
        if(companyInformation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(companyInformation);
    }

    @GetMapping("/get-first-active")
    public ResponseEntity<CompanyInformation> getFirstActive() {
        CompanyInformation companyInformation = companyInformationService.getActive();
        if(companyInformation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(companyInformation);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<CompanyInformation>> getAll() {
        List<CompanyInformation> companyInformations = companyInformationService.getAll();
        return ResponseEntity.ok(companyInformations);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteById(@RequestParam int id) {
        if(companyInformationService.deleteById(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
