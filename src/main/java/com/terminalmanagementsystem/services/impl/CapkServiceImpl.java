package com.terminalmanagementsystem.services.impl;

import com.terminalmanagementsystem.dtos.CapkDto;
import com.terminalmanagementsystem.exceptions.InvalidParameterException;
import com.terminalmanagementsystem.models.Capk;
import com.terminalmanagementsystem.repositories.CapkRepository;
import com.terminalmanagementsystem.services.CapkService;
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
public class CapkServiceImpl implements CapkService {

    private final CapkRepository capkRepository;

    @Override
    public Capk createCapk(CapkDto capkDto) {
        Capk capk = new Capk();
        capk.setIssuer(capkDto.getIssuer());
        capk.setExponent(capkDto.getExponent());
        capk.setRidIndex(capkDto.getRidIndex());
        capk.setModulus(capk.getModulus());
        capk.setKeyLength(capk.getKeyLength());
        capk.setSha1(capk.getSha1());
        capk.setKeyLength(capk.getKeyLength());
        capk.setExpires(capkDto.getExpires());
        capk.setBankId(capkDto.getBankId());
        capkRepository.save(capk);


        return  capkRepository.save(capk);
    }

    @Override
    public Capk updateCapk(@NotNull Integer id, @NotNull CapkDto capkDto) {

        if (!Objects.equals(id, capkDto.getId())) {
            throw new InvalidParameterException("Invalid details");
        }

        if (!capkRepository.existsById(id)) {
            throw new EntityNotFoundException("Bank with provided id not found");
        }

        Capk capk = new Capk();
        capk.setId(capkDto.getId());
        capk.setIssuer(capkDto.getIssuer());
        capk.setExponent(capkDto.getExponent());
        capk.setRidIndex(capkDto.getRidIndex());
        capk.setModulus(capk.getModulus());
        capk.setKeyLength(capk.getKeyLength());
        capk.setSha1(capk.getSha1());
        capk.setKeyLength(capk.getKeyLength());
        capk.setExpires(capkDto.getExpires());
        capk.setBankId(capkDto.getBankId());
        capkRepository.save(capk);


        return  capkRepository.save(capk);
    }

    @Override
    public Capk getOneCapk(Integer id) {
        return capkRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("capk not found"));
    }

    @Override
    public Boolean deleteCapk(Integer id) {
        capkRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Capk> getCapks() {
        return capkRepository.findAll();

    }
}
