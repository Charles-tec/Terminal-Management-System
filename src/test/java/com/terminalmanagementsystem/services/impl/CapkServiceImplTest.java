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

import com.terminalmanagementsystem.dtos.CapkDto;
import com.terminalmanagementsystem.exceptions.InvalidParameterException;
import com.terminalmanagementsystem.models.Capk;
import com.terminalmanagementsystem.repositories.CapkRepository;

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

@ContextConfiguration(classes = {CapkServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CapkServiceImplTest {
    @MockBean
    private CapkRepository capkRepository;

    @Autowired
    private CapkServiceImpl capkServiceImpl;

    @Test
    void testCreateCapk() {
        Capk capk = new Capk();
        capk.setBankId(123);
        capk.setExpires("Expires");
        capk.setExponent(1);
        capk.setId(1);
        capk.setIssuer("Issuer");
        capk.setKeyLength(3);
        capk.setKeyType("Key Type");
        capk.setModulus("Modulus");
        capk.setRidIndex(1);
        capk.setSha1("Sha1");
        when(this.capkRepository.save((Capk) any())).thenReturn(capk);

        CapkDto capkDto = new CapkDto();
        capkDto.setBankId(123);
        capkDto.setExpires("Expires");
        capkDto.setExponent(1);
        capkDto.setId(1);
        capkDto.setIssuer("Issuer");
        capkDto.setKeyLength(3);
        capkDto.setKeyType("Key Type");
        capkDto.setModulus("Modulus");
        capkDto.setRidIndex(1);
        capkDto.setSha1("Sha1");
        assertSame(capk, this.capkServiceImpl.createCapk(capkDto));
        verify(this.capkRepository, atLeast(1)).save((Capk) any());
        assertTrue(this.capkServiceImpl.getCapks().isEmpty());
    }

    @Test
    void testCreateCapk2() {
        when(this.capkRepository.save((Capk) any())).thenThrow(new InvalidParameterException("Exception"));

        CapkDto capkDto = new CapkDto();
        capkDto.setBankId(123);
        capkDto.setExpires("Expires");
        capkDto.setExponent(1);
        capkDto.setId(1);
        capkDto.setIssuer("Issuer");
        capkDto.setKeyLength(3);
        capkDto.setKeyType("Key Type");
        capkDto.setModulus("Modulus");
        capkDto.setRidIndex(1);
        capkDto.setSha1("Sha1");
        assertThrows(InvalidParameterException.class, () -> this.capkServiceImpl.createCapk(capkDto));
        verify(this.capkRepository).save((Capk) any());
    }

    @Test
    void testUpdateCapk() {
        Capk capk = new Capk();
        capk.setBankId(123);
        capk.setExpires("Expires");
        capk.setExponent(1);
        capk.setId(1);
        capk.setIssuer("Issuer");
        capk.setKeyLength(3);
        capk.setKeyType("Key Type");
        capk.setModulus("Modulus");
        capk.setRidIndex(1);
        capk.setSha1("Sha1");
        when(this.capkRepository.save((Capk) any())).thenReturn(capk);
        when(this.capkRepository.existsById((Integer) any())).thenReturn(true);

        CapkDto capkDto = new CapkDto();
        capkDto.setBankId(123);
        capkDto.setExpires("Expires");
        capkDto.setExponent(1);
        capkDto.setId(1);
        capkDto.setIssuer("Issuer");
        capkDto.setKeyLength(3);
        capkDto.setKeyType("Key Type");
        capkDto.setModulus("Modulus");
        capkDto.setRidIndex(1);
        capkDto.setSha1("Sha1");
        assertSame(capk, this.capkServiceImpl.updateCapk(1, capkDto));
        verify(this.capkRepository).existsById((Integer) any());
        verify(this.capkRepository, atLeast(1)).save((Capk) any());
        assertTrue(this.capkServiceImpl.getCapks().isEmpty());
    }

    @Test
    void testUpdateCapk2() {
        when(this.capkRepository.save((Capk) any())).thenThrow(new InvalidParameterException("Exception"));
        when(this.capkRepository.existsById((Integer) any())).thenReturn(true);

        CapkDto capkDto = new CapkDto();
        capkDto.setBankId(123);
        capkDto.setExpires("Expires");
        capkDto.setExponent(1);
        capkDto.setId(1);
        capkDto.setIssuer("Issuer");
        capkDto.setKeyLength(3);
        capkDto.setKeyType("Key Type");
        capkDto.setModulus("Modulus");
        capkDto.setRidIndex(1);
        capkDto.setSha1("Sha1");
        assertThrows(InvalidParameterException.class, () -> this.capkServiceImpl.updateCapk(1, capkDto));
        verify(this.capkRepository).existsById((Integer) any());
        verify(this.capkRepository).save((Capk) any());
    }

    @Test
    void testUpdateCapk3() {
        Capk capk = new Capk();
        capk.setBankId(123);
        capk.setExpires("Expires");
        capk.setExponent(1);
        capk.setId(1);
        capk.setIssuer("Issuer");
        capk.setKeyLength(3);
        capk.setKeyType("Key Type");
        capk.setModulus("Modulus");
        capk.setRidIndex(1);
        capk.setSha1("Sha1");
        when(this.capkRepository.save((Capk) any())).thenReturn(capk);
        when(this.capkRepository.existsById((Integer) any())).thenReturn(false);

        CapkDto capkDto = new CapkDto();
        capkDto.setBankId(123);
        capkDto.setExpires("Expires");
        capkDto.setExponent(1);
        capkDto.setId(1);
        capkDto.setIssuer("Issuer");
        capkDto.setKeyLength(3);
        capkDto.setKeyType("Key Type");
        capkDto.setModulus("Modulus");
        capkDto.setRidIndex(1);
        capkDto.setSha1("Sha1");
        assertThrows(EntityNotFoundException.class, () -> this.capkServiceImpl.updateCapk(1, capkDto));
        verify(this.capkRepository).existsById((Integer) any());
    }

    @Test
    void testUpdateCapk4() {
        Capk capk = new Capk();
        capk.setBankId(123);
        capk.setExpires("Expires");
        capk.setExponent(1);
        capk.setId(1);
        capk.setIssuer("Issuer");
        capk.setKeyLength(3);
        capk.setKeyType("Key Type");
        capk.setModulus("Modulus");
        capk.setRidIndex(1);
        capk.setSha1("Sha1");
        when(this.capkRepository.save((Capk) any())).thenReturn(capk);
        when(this.capkRepository.existsById((Integer) any())).thenReturn(true);

        CapkDto capkDto = new CapkDto();
        capkDto.setBankId(123);
        capkDto.setExpires("Expires");
        capkDto.setExponent(1);
        capkDto.setId(1);
        capkDto.setIssuer("Issuer");
        capkDto.setKeyLength(3);
        capkDto.setKeyType("Key Type");
        capkDto.setModulus("Modulus");
        capkDto.setRidIndex(1);
        capkDto.setSha1("Sha1");
        assertThrows(InvalidParameterException.class, () -> this.capkServiceImpl.updateCapk(123, capkDto));
    }

    @Test
    void testGetOneCapk() {
        Capk capk = new Capk();
        capk.setBankId(123);
        capk.setExpires("Expires");
        capk.setExponent(1);
        capk.setId(1);
        capk.setIssuer("Issuer");
        capk.setKeyLength(3);
        capk.setKeyType("Key Type");
        capk.setModulus("Modulus");
        capk.setRidIndex(1);
        capk.setSha1("Sha1");
        Optional<Capk> ofResult = Optional.of(capk);
        when(this.capkRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(capk, this.capkServiceImpl.getOneCapk(1));
        verify(this.capkRepository).findById((Integer) any());
        assertTrue(this.capkServiceImpl.getCapks().isEmpty());
    }

    @Test
    void testGetOneCapk2() {
        when(this.capkRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> this.capkServiceImpl.getOneCapk(1));
        verify(this.capkRepository).findById((Integer) any());
    }

    @Test
    void testGetOneCapk3() {
        when(this.capkRepository.findById((Integer) any())).thenThrow(new InvalidParameterException("capk not found"));
        assertThrows(InvalidParameterException.class, () -> this.capkServiceImpl.getOneCapk(1));
        verify(this.capkRepository).findById((Integer) any());
    }

    @Test
    void testDeleteCapk() {
        doNothing().when(this.capkRepository).deleteById((Integer) any());
        assertTrue(this.capkServiceImpl.deleteCapk(1));
        verify(this.capkRepository).deleteById((Integer) any());
        assertTrue(this.capkServiceImpl.getCapks().isEmpty());
    }

    @Test
    void testDeleteCapk2() {
        doThrow(new InvalidParameterException("Exception")).when(this.capkRepository).deleteById((Integer) any());
        assertThrows(InvalidParameterException.class, () -> this.capkServiceImpl.deleteCapk(1));
        verify(this.capkRepository).deleteById((Integer) any());
    }

    @Test
    void testGetCapks() {
        ArrayList<Capk> capkList = new ArrayList<>();
        when(this.capkRepository.findAll()).thenReturn(capkList);
        List<Capk> actualCapks = this.capkServiceImpl.getCapks();
        assertSame(capkList, actualCapks);
        assertTrue(actualCapks.isEmpty());
        verify(this.capkRepository).findAll();
    }

    @Test
    void testGetCapks2() {
        when(this.capkRepository.findAll()).thenThrow(new InvalidParameterException("Exception"));
        assertThrows(InvalidParameterException.class, () -> this.capkServiceImpl.getCapks());
        verify(this.capkRepository).findAll();
    }
}

