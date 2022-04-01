package com.terminalmanagementsystem.controllers;

import com.terminalmanagementsystem.dtos.BinDto;
import com.terminalmanagementsystem.models.Bin;
import com.terminalmanagementsystem.services.BinService;
import com.terminalmanagementsystem.util.Response;
import com.terminalmanagementsystem.util.ResponseBuild;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/bins")
public class BinController {
    private final BinService binService;
    private final ResponseBuild<Bin> binResponseBuild;


    @GetMapping("/")
    public ResponseEntity<Response> getAllBins(){

        return new ResponseEntity<>(binResponseBuild.listResponseFunction.
                apply(binService.getBins()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response>getOneBin(@PathVariable Integer id){

        return new ResponseEntity<>(binResponseBuild.responseFunction.
                apply(binService.getOneBin(id)),HttpStatus.OK);
    }

    @PostMapping("/save-bin")
    public ResponseEntity<Response> createBin(@RequestBody BinDto binDto){

        return new ResponseEntity<>(binResponseBuild.responseFunction.
                apply(binService.createBin(binDto)),HttpStatus.OK);
    }

    @PutMapping("/update-bin/{id}")
    public ResponseEntity<Response>updateBin(@PathVariable("id")Integer id, @RequestBody BinDto binDto){

        return new ResponseEntity<>(binResponseBuild.responseFunction.
                apply(binService.updateBin(id, binDto)),HttpStatus.OK);
    }

    @DeleteMapping("/delete-bin/{id}")
    public ResponseEntity<Boolean> deleteBin(@PathVariable ("id")Integer id){

        return new ResponseEntity<>(binService.deleteBin(id),HttpStatus.OK);
    }

}
