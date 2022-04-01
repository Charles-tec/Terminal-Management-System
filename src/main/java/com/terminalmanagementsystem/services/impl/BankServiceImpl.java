package com.terminalmanagementsystem.services.impl;


import com.terminalmanagementsystem.dtos.BankDto;
import com.terminalmanagementsystem.exceptions.InvalidParameterException;

import com.terminalmanagementsystem.models.Bank;
import com.terminalmanagementsystem.repositories.BankRepository;
import com.terminalmanagementsystem.services.BankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service

public class BankServiceImpl implements BankService {
    private final BankRepository bankRepository;

    @Override
    public Bank createBank(BankDto bankDto) {
        Bank bank = new Bank();
        bank.setName(bankDto.getName());
        bank.setDescription(bankDto.getDescription());
        bankRepository.save(bank);


        return  bankRepository.save(bank);
    }

    @Override
    public Bank updateBank(@NotNull Integer id, @NotNull BankDto bankDto) {

        if (!Objects.equals(id, bankDto.getId())) {
            throw new InvalidParameterException("Invalid details");
        }

        if (!bankRepository.existsById(id)) {
            throw new EntityNotFoundException("Bank with provided id not found");
        }

        Bank bank = new Bank();
        bank.setName(bankDto.getName());
        bank.setDescription(bankDto.getDescription());
        bank.setId(bankDto.getId());



        return  bankRepository.save(bank);
    }

    @Override
    public Bank getOneBank(Integer id) {
        return bankRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("Bank not found"));
    }

    @Override
    public Boolean deleteBank(Integer id) {
        bankRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Bank> getBanks() {
        return bankRepository.findAll();

    }
}
