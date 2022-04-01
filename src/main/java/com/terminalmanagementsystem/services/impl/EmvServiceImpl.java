package com.terminalmanagementsystem.services.impl;

import com.terminalmanagementsystem.dtos.EmvDto;
import com.terminalmanagementsystem.exceptions.InvalidParameterException;
import com.terminalmanagementsystem.models.Emv;
import com.terminalmanagementsystem.repositories.EmvRepository;
import com.terminalmanagementsystem.services.EmvService;
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
public class EmvServiceImpl implements EmvService {
    public final EmvRepository emvRepository;
    @Override
    public Emv createEmv(EmvDto emvDto) {
        Emv emv= new Emv();
        emv.setTag(emvDto.getTag());
        emv.setDescription(emvDto.getDescription());
        emv.setMinLength(emvDto.getMinLength());
        emv.setMaxLength(emvDto.getMaxLength());
        emv.setMandatory(true);
        emv.setBankId(emvDto.getBankId());

        emvRepository.save(emv);


        return  emvRepository.save(emv);
    }

    @Override
    public Emv updateEmv(@NotNull Integer id, @NotNull EmvDto emvDto) {

        if (!Objects.equals(id, emvDto.getId())) {
            throw new InvalidParameterException("Invalid details");
        }

        if (!emvRepository.existsById(id)) {
            throw new EntityNotFoundException("emv with provided id not found");
        }

        Emv emv= new Emv();
        emv.setId(emvDto.getId());
        emv.setTag(emvDto.getTag());
        emv.setDescription(emvDto.getDescription());
        emv.setMinLength(emvDto.getMinLength());
        emv.setMaxLength(emvDto.getMaxLength());
        emv.setMandatory(true);
        emv.setBankId(emvDto.getBankId());

        return  emvRepository.save(emv);
    }

    @Override
    public Emv getOneEmv(Integer id) {
        return emvRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("emv not found"));
    }

    @Override
    public Boolean deleteEmv(Integer id) {
        emvRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Emv> getEmvs() {
        return emvRepository.findAll();

    }

}
