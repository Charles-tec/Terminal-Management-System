package com.terminalmanagementsystem.services;


import com.terminalmanagementsystem.dtos.AidDto;
import com.terminalmanagementsystem.dtos.BankDto;
import com.terminalmanagementsystem.models.Aid;
import com.terminalmanagementsystem.models.Bank;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public interface AidService {

    Aid createAid(AidDto aidDto);

    Aid updateAid(@NotNull Integer id, @NotNull AidDto aidDto);

    Aid getOneAid(Integer id);

    Boolean  deleteAid(Integer id);

    List<Aid> getAids();
}
