package com.terminalmanagementsystem.services.impl;

import com.terminalmanagementsystem.dtos.BinDto;
import com.terminalmanagementsystem.exceptions.InvalidParameterException;
import com.terminalmanagementsystem.models.Bin;
import com.terminalmanagementsystem.repositories.BinRepository;
import com.terminalmanagementsystem.services.BinService;
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
public class BinServiceImpl implements BinService {
    private final BinRepository binRepository;

    @Override
    public Bin createBin(BinDto binDto) {
        Bin bin= new Bin();
        bin.setBin(binDto.getBin());
        bin.setBankId(binDto.getBankId());
        binRepository.save(bin);


        return  binRepository.save(bin);
    }

    @Override
    public Bin updateBin(@NotNull Integer id, @NotNull BinDto binDto) {

        if (!Objects.equals(id, binDto.getId())) {
            throw new InvalidParameterException("Invalid details");
        }

        if (!binRepository.existsById(id)) {
            throw new EntityNotFoundException("Bin with provided id not found");
        }

        Bin bin = new Bin();
        bin.setBin(binDto.getBin());
        bin.setBankId(binDto.getBankId());
        bin.setId(binDto.getId());



        return binRepository.save(bin);
    }

    @Override
    public Bin getOneBin(Integer id) {
        return binRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("Bin not found"));
    }

    @Override
    public Boolean deleteBin(Integer id) {
        binRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Bin> getBins() {
        return binRepository.findAll();

    }
}
