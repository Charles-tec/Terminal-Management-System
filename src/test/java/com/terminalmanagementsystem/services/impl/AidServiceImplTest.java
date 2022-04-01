package com.terminalmanagementsystem.services.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.terminalmanagementsystem.dtos.AidDto;
import com.terminalmanagementsystem.exceptions.InvalidParameterException;
import com.terminalmanagementsystem.models.Aid;
import com.terminalmanagementsystem.repositories.AidRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AidServiceImpl.class})
@ExtendWith(SpringExtension.class)
class AidServiceImplTest {
    @MockBean
    private AidRepository aidRepository;

    @Autowired
    private AidServiceImpl aidServiceImpl;

    @Test
    void testCreateAid() {
        Aid aid = new Aid();
        aid.setAid("Aid");
        aid.setBankId(123);
        aid.setCountry("GB");
        aid.setDescription("The characteristics of someone or something");
        aid.setId(1);
        aid.setName("Name");
        aid.setType("Type");
        aid.setVendor("Vendor");
        when(this.aidRepository.save((Aid) any())).thenReturn(aid);

        AidDto aidDto = new AidDto();
        aidDto.setAid("Aid");
        aidDto.setBankId(123);
        aidDto.setCountry("GB");
        aidDto.setDescription("The characteristics of someone or something");
        aidDto.setId(1);
        aidDto.setName("Name");
        aidDto.setType("Type");
        aidDto.setVendor("Vendor");
        assertSame(aid, this.aidServiceImpl.createAid(aidDto));
        verify(this.aidRepository, atLeast(1)).save((Aid) any());
        assertTrue(this.aidServiceImpl.getAids().isEmpty());
    }

    @Test
    void testCreateAid2() {
        when(this.aidRepository.save((Aid) any())).thenThrow(new InvalidParameterException("Exception"));

        AidDto aidDto = new AidDto();
        aidDto.setAid("Aid");
        aidDto.setBankId(123);
        aidDto.setCountry("GB");
        aidDto.setDescription("The characteristics of someone or something");
        aidDto.setId(1);
        aidDto.setName("Name");
        aidDto.setType("Type");
        aidDto.setVendor("Vendor");
        assertThrows(InvalidParameterException.class, () -> this.aidServiceImpl.createAid(aidDto));
        verify(this.aidRepository).save((Aid) any());
    }

    @Test
    void testGetOneAid() {
        Aid aid = new Aid();
        aid.setAid("Aid");
        aid.setBankId(123);
        aid.setCountry("GB");
        aid.setDescription("The characteristics of someone or something");
        aid.setId(1);
        aid.setName("Name");
        aid.setType("Type");
        aid.setVendor("Vendor");
        Optional<Aid> ofResult = Optional.of(aid);
        when(this.aidRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(aid, this.aidServiceImpl.getOneAid(1));
        verify(this.aidRepository).findById((Integer) any());
        assertTrue(this.aidServiceImpl.getAids().isEmpty());
    }

    @Test
    void testGetOneAid2() {
        when(this.aidRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> this.aidServiceImpl.getOneAid(1));
        verify(this.aidRepository).findById((Integer) any());
    }

    @Test
    void testGetOneAid3() {
        when(this.aidRepository.findById((Integer) any())).thenThrow(new InvalidParameterException("aid not found"));
        assertThrows(InvalidParameterException.class, () -> this.aidServiceImpl.getOneAid(1));
        verify(this.aidRepository).findById((Integer) any());
    }

    @Test
    void testDeleteAid() {
        doNothing().when(this.aidRepository).deleteById((Integer) any());
        assertTrue(this.aidServiceImpl.deleteAid(1));
        verify(this.aidRepository).deleteById((Integer) any());
        assertTrue(this.aidServiceImpl.getAids().isEmpty());
    }

    @Test
    void testDeleteAid2() {
        doThrow(new InvalidParameterException("Exception")).when(this.aidRepository).deleteById((Integer) any());
        assertThrows(InvalidParameterException.class, () -> this.aidServiceImpl.deleteAid(1));
        verify(this.aidRepository).deleteById((Integer) any());
    }

    @Test
    void testGetAids() {
        ArrayList<Aid> aidList = new ArrayList<>();
        when(this.aidRepository.findAll()).thenReturn(aidList);
        List<Aid> actualAids = this.aidServiceImpl.getAids();
        assertSame(aidList, actualAids);
        assertTrue(actualAids.isEmpty());
        verify(this.aidRepository).findAll();
    }

    @Test
    void testGetAids2() {
        when(this.aidRepository.findAll()).thenThrow(new InvalidParameterException("Exception"));
        assertThrows(InvalidParameterException.class, () -> this.aidServiceImpl.getAids());
        verify(this.aidRepository).findAll();
    }
}

