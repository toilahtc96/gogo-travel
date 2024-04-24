package com.travel.gogo.controller;

import com.travel.gogo.entity.ReasonChoose;
import com.travel.gogo.request.ReasonChooseRequest;
import com.travel.gogo.service.ReasonChooseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/reason-choose")
@AllArgsConstructor
@CrossOrigin(origins = {"http://gogotravelvn.com/","https://gogotravalvn.com", "http://localhost:3000"})
public class ReasonChooseController {
    private final ReasonChooseService reasonChooseService;

    @PostMapping("/add")
    public ResponseEntity addReasonChoose(@RequestBody ReasonChooseRequest reasonChooseRequest) {
        reasonChooseService.add(reasonChooseRequest);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/edit")
    public ResponseEntity editReasonChoose(@RequestBody ReasonChooseRequest reasonChooseRequest) {
        if(reasonChooseService.edit(reasonChooseRequest)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<ReasonChoose> getById(@RequestParam int id) {
        ReasonChoose companyInformation = reasonChooseService.getById(id);
        if(companyInformation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(companyInformation);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<ReasonChoose>> getAll() {
        List<ReasonChoose> companyInformations = reasonChooseService.getAll();
        return ResponseEntity.ok(companyInformations.stream().sorted((item1,item2) -> item2.getId().compareTo(item1.getId())).collect(Collectors.toList()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteById(@RequestParam int id) {
        if(reasonChooseService.deleteById(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
