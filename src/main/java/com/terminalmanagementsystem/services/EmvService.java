package com.terminalmanagementsystem.services;


import com.terminalmanagementsystem.dtos.EmvDto;
import com.terminalmanagementsystem.models.Emv;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public interface EmvService {
    Emv createEmv(EmvDto emvDto);

    Emv updateEmv(@NotNull Integer id, @NotNull EmvDto emvDto);

    Emv getOneEmv(Integer id);

    Boolean  deleteEmv(Integer id);
    List<Emv> getEmvs();
}
