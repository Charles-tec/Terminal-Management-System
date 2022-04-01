package com.terminalmanagementsystem.services.impl;

import com.terminalmanagementsystem.dtos.AidDto;
import com.terminalmanagementsystem.dtos.BankDto;
import com.terminalmanagementsystem.exceptions.InvalidParameterException;
import com.terminalmanagementsystem.models.Aid;
import com.terminalmanagementsystem.models.Bank;
import com.terminalmanagementsystem.repositories.AidRepository;
import com.terminalmanagementsystem.repositories.BankRepository;
import com.terminalmanagementsystem.services.AidService;
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
public class AidServiceImpl implements AidService {
    private final AidRepository aidRepository;

    @Override
    public Aid createAid(AidDto aidDto) {
        Aid aid= new Aid();
        aid.setAid(aidDto.getAid());
        aid.setVendor(aidDto.getVendor());
        aid.setCountry(aidDto.getCountry());
        aid.setName(aidDto.getName());
        aid.setDescription(aidDto.getDescription());
        aid.setType(aidDto.getType());
        aid.setBankId(aidDto.getBankId());
        aidRepository.save(aid);

        return  aidRepository.save(aid);
    }

    @Override
    public Aid updateAid (@NotNull Integer id, @NotNull AidDto aidDto) {

        if (!Objects.equals(id, aidDto.getId())) {
            throw new InvalidParameterException("Invalid details");
        }

        if (!aidRepository.existsById(id)) {
            throw new EntityNotFoundException("Aid with provided id not found");
        }
        Aid aid = new Aid();
        aid.setId(aidDto.getId());
        aid.setAid(aidDto.getAid());
        aid.setVendor(aidDto.getVendor());
        aid.setCountry(aid.getCountry());
        aid.setName(aid.getName());
        aid.setDescription(aid.getDescription());
        aid.setType(aid.getType());
        aid.setBankId(aid.getBankId());
        aidRepository.save(aid);

        return aidRepository.save(aid);
    }
        @Override
        public Aid getOneAid (Integer id){
            return aidRepository.findById(id).
                    orElseThrow(() -> new EntityNotFoundException("aid not found"));
        }

        @Override
        public Boolean deleteAid (Integer id){
            aidRepository.deleteById(id);
            return true;
        }

        @Override
        public List<Aid> getAids () {
            return aidRepository.findAll();

        }

    }
