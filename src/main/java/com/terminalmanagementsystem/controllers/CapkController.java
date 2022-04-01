package com.terminalmanagementsystem.controllers;

import com.terminalmanagementsystem.dtos.BankDto;
import com.terminalmanagementsystem.dtos.CapkDto;
import com.terminalmanagementsystem.models.Bank;
import com.terminalmanagementsystem.models.Capk;
import com.terminalmanagementsystem.services.CapkService;
import com.terminalmanagementsystem.util.Response;
import com.terminalmanagementsystem.util.ResponseBuild;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/capks")
public class CapkController {
    private final CapkService capkService;
    private final ResponseBuild<Capk> capkResponseBuild;


    @GetMapping("/")
    public ResponseEntity<Response> getAllCapks(){

        return new ResponseEntity<>(capkResponseBuild.listResponseFunction.
                apply(capkService.getCapks()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response>getOneCapk(@PathVariable Integer id){

        return new ResponseEntity<>(capkResponseBuild.responseFunction.
                apply(capkService.getOneCapk(id)),HttpStatus.OK);
    }

    @PostMapping("/save-capk")
    public ResponseEntity<Response> createCapk(@RequestBody CapkDto capkDto){

        return new ResponseEntity<>(capkResponseBuild.responseFunction.
                apply(capkService.createCapk(capkDto)),HttpStatus.OK);
    }

    @PutMapping("/update-capk/{id}")
    public ResponseEntity<Response>updateCapk(@PathVariable("id")Integer id, @RequestBody CapkDto capkDto){
        return new ResponseEntity<>(capkResponseBuild.responseFunction.
                apply(capkService.updateCapk(id, capkDto)),HttpStatus.OK);
    }

    @DeleteMapping("/delete-capk/{id}")
    public ResponseEntity<Boolean> deleteCapk(@PathVariable ("id")Integer id){

        return new ResponseEntity<>(capkService.deleteCapk(id),HttpStatus.OK);
    }

}
