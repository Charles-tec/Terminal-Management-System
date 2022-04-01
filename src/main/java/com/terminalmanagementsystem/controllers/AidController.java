package com.terminalmanagementsystem.controllers;


import com.terminalmanagementsystem.dtos.AidDto;
import com.terminalmanagementsystem.models.Aid;
import com.terminalmanagementsystem.services.AidService;
import com.terminalmanagementsystem.util.Response;
import com.terminalmanagementsystem.util.ResponseBuild;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/aids")
public class AidController {

    private final AidService aidService;
    private final ResponseBuild<Aid> aidResponseBuild;


    @GetMapping("/")
    public ResponseEntity<Response> getAllAid(){

        return new ResponseEntity<>(aidResponseBuild.listResponseFunction.
                apply(aidService.getAids()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response>getOneAid(@PathVariable Integer id){

        return new ResponseEntity<>(aidResponseBuild.responseFunction.
                apply(aidService.getOneAid(id)),HttpStatus.OK);
    }

    @PostMapping("/save-aid")
    public ResponseEntity<Response> createAid(@RequestBody AidDto aidDto){

        return new ResponseEntity<>(aidResponseBuild.responseFunction.
                apply(aidService.createAid(aidDto)),HttpStatus.OK);
    }

    @PutMapping("/update-aid/{id}")
    public ResponseEntity<Response>updateAid(@PathVariable("id")Integer id, @RequestBody AidDto aidDto){
        return new ResponseEntity<>(aidResponseBuild.responseFunction.
                apply(aidService.updateAid(id, aidDto)),HttpStatus.OK);
    }

    @DeleteMapping("/delete-aid/{id}")
    public ResponseEntity<Boolean> deleteAid(@PathVariable ("id")Integer id){

        return new ResponseEntity<>(aidService.deleteAid(id),HttpStatus.OK);
    }

}
