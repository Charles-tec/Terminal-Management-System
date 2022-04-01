package com.terminalmanagementsystem.services;

import com.terminalmanagementsystem.dtos.BinDto;
import com.terminalmanagementsystem.models.Bin;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public interface BinService {

    Bin createBin(BinDto binDto);

    Bin updateBin(@NotNull Integer id, @NotNull BinDto binDto);

    Bin getOneBin(Integer id);

    Boolean  deleteBin(Integer id);
    List<Bin> getBins();
}
