package com.terminalmanagementsystem.services;


import com.terminalmanagementsystem.dtos.BankDto;
import com.terminalmanagementsystem.models.Bank;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public interface BankService {
    Bank createBank(BankDto bankDto);

    Bank updateBank(@NotNull Integer id, @NotNull BankDto bankDto);

    Bank getOneBank(Integer id);

    Boolean  deleteBank(Integer id);
    List<Bank> getBanks();
}
