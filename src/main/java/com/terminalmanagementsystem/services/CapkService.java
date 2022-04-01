package com.terminalmanagementsystem.services;

import com.terminalmanagementsystem.dtos.BinDto;
import com.terminalmanagementsystem.dtos.CapkDto;
import com.terminalmanagementsystem.models.Bin;
import com.terminalmanagementsystem.models.Capk;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public interface CapkService {

    Capk createCapk(CapkDto capkDto);

    Capk updateCapk(@NotNull Integer id, @NotNull CapkDto capkDto);

    Capk getOneCapk(Integer id);

    Boolean  deleteCapk(Integer id);
    List<Capk> getCapks();
}
