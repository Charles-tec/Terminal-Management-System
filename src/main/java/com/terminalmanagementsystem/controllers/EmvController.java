package com.terminalmanagementsystem.controllers;

import com.terminalmanagementsystem.dtos.EmvDto;
import com.terminalmanagementsystem.models.Emv;
import com.terminalmanagementsystem.services.EmvService;
import com.terminalmanagementsystem.util.Response;
import com.terminalmanagementsystem.util.ResponseBuild;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/emvs")
public class EmvController {
    private final EmvService emvService;
    private final ResponseBuild<Emv> emvResponseBuild;


    @GetMapping("/")
    public ResponseEntity<Response> getAllEmvs(){

        return new ResponseEntity<>(emvResponseBuild.listResponseFunction.
                apply(emvService.getEmvs()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response>getOneEmv(@PathVariable Integer id){

        return new ResponseEntity<>(emvResponseBuild.responseFunction.
                apply(emvService.getOneEmv(id)),HttpStatus.OK);
    }

    @PostMapping("/save-emv")
    public ResponseEntity<Response> createEmv(@RequestBody EmvDto emvDto){

        return new ResponseEntity<>(emvResponseBuild.responseFunction.
                apply(emvService.createEmv(emvDto)),HttpStatus.OK);
    }

    @PutMapping("/update-emv/{id}")
    public ResponseEntity<Response>updateEmv(@PathVariable("id")Integer id, @RequestBody EmvDto emvDto){

        return new ResponseEntity<>(emvResponseBuild.responseFunction.
                apply(emvService.updateEmv(id, emvDto)),HttpStatus.OK);
    }

    @DeleteMapping("/delete-emv/{id}")
    public ResponseEntity<Boolean> deleteEmv(@PathVariable ("id")Integer id){

        return new ResponseEntity<>(emvService.deleteEmv(id),HttpStatus.OK);
    }

}
