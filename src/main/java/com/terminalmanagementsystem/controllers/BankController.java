package com.terminalmanagementsystem.controllers;


import com.terminalmanagementsystem.dtos.BankDto;
import com.terminalmanagementsystem.models.Bank;
import com.terminalmanagementsystem.services.BankService;
import com.terminalmanagementsystem.util.Response;
import com.terminalmanagementsystem.util.ResponseBuild;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/banks")
public class BankController {
private final BankService bankService;
private final ResponseBuild<Bank> bankResponseBuild;


    @GetMapping("/")
    public ResponseEntity<Response> getAllBanks(){

        return new ResponseEntity<>(bankResponseBuild.listResponseFunction.
                apply(bankService.getBanks()),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response>getOneBank(@PathVariable Integer id){

        return new ResponseEntity<>(bankResponseBuild.responseFunction.
                apply(bankService.getOneBank(id)),HttpStatus.OK);
    }

    @PostMapping("/save-bank")
    public ResponseEntity<Response> createBank(@RequestBody BankDto bankDto){

        return new ResponseEntity<>(bankResponseBuild.responseFunction.
                apply(bankService.createBank(bankDto)),HttpStatus.OK);
    }

    @PutMapping("/update-bank/{id}")
    public ResponseEntity<Response>updateBank(@PathVariable("id")Integer id, @RequestBody BankDto bankDto){
        return new ResponseEntity<>(bankResponseBuild.responseFunction.
                apply(bankService.updateBank(id, bankDto)),HttpStatus.OK);
    }

    @DeleteMapping("/delete-bank/{id}")
    public ResponseEntity<Boolean> deleteBank(@PathVariable ("id")Integer id){

        return new ResponseEntity<>(bankService.deleteBank(id),HttpStatus.OK);
    }

}

