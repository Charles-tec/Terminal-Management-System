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

import com.terminalmanagementsystem.dtos.BinDto;
import com.terminalmanagementsystem.exceptions.InvalidParameterException;
import com.terminalmanagementsystem.models.Bin;
import com.terminalmanagementsystem.repositories.BinRepository;

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

@ContextConfiguration(classes = {BinServiceImpl.class})
@ExtendWith(SpringExtension.class)
class BinServiceImplTest {
    @MockBean
    private BinRepository binRepository;

    @Autowired
    private BinServiceImpl binServiceImpl;

    @Test
    void testCreateBin() {
        Bin bin = new Bin();
        bin.setBankId(123);
        bin.setBin("Bin");
        bin.setId(1);
        when(this.binRepository.save((Bin) any())).thenReturn(bin);

        BinDto binDto = new BinDto();
        binDto.setBankId(123);
        binDto.setBin("Bin");
        binDto.setId(1);
        assertSame(bin, this.binServiceImpl.createBin(binDto));
        verify(this.binRepository, atLeast(1)).save((Bin) any());
        assertTrue(this.binServiceImpl.getBins().isEmpty());
    }

    @Test
    void testCreateBin2() {
        when(this.binRepository.save((Bin) any())).thenThrow(new InvalidParameterException("Exception"));

        BinDto binDto = new BinDto();
        binDto.setBankId(123);
        binDto.setBin("Bin");
        binDto.setId(1);
        assertThrows(InvalidParameterException.class, () -> this.binServiceImpl.createBin(binDto));
        verify(this.binRepository).save((Bin) any());
    }

    @Test
    void testUpdateBin() {
        Bin bin = new Bin();
        bin.setBankId(123);
        bin.setBin("Bin");
        bin.setId(1);
        when(this.binRepository.save((Bin) any())).thenReturn(bin);
        when(this.binRepository.existsById((Integer) any())).thenReturn(true);

        BinDto binDto = new BinDto();
        binDto.setBankId(123);
        binDto.setBin("Bin");
        binDto.setId(1);
        assertSame(bin, this.binServiceImpl.updateBin(1, binDto));
        verify(this.binRepository).existsById((Integer) any());
        verify(this.binRepository).save((Bin) any());
        assertTrue(this.binServiceImpl.getBins().isEmpty());
    }

    @Test
    void testUpdateBin2() {
        when(this.binRepository.save((Bin) any())).thenThrow(new InvalidParameterException("Exception"));
        when(this.binRepository.existsById((Integer) any())).thenReturn(true);

        BinDto binDto = new BinDto();
        binDto.setBankId(123);
        binDto.setBin("Bin");
        binDto.setId(1);
        assertThrows(InvalidParameterException.class, () -> this.binServiceImpl.updateBin(1, binDto));
        verify(this.binRepository).existsById((Integer) any());
        verify(this.binRepository).save((Bin) any());
    }

    @Test
    void testUpdateBin3() {
        Bin bin = new Bin();
        bin.setBankId(123);
        bin.setBin("Bin");
        bin.setId(1);
        when(this.binRepository.save((Bin) any())).thenReturn(bin);
        when(this.binRepository.existsById((Integer) any())).thenReturn(false);

        BinDto binDto = new BinDto();
        binDto.setBankId(123);
        binDto.setBin("Bin");
        binDto.setId(1);
        assertThrows(EntityNotFoundException.class, () -> this.binServiceImpl.updateBin(1, binDto));
        verify(this.binRepository).existsById((Integer) any());
    }

    @Test
    void testUpdateBin4() {
        Bin bin = new Bin();
        bin.setBankId(123);
        bin.setBin("Bin");
        bin.setId(1);
        when(this.binRepository.save((Bin) any())).thenReturn(bin);
        when(this.binRepository.existsById((Integer) any())).thenReturn(true);

        BinDto binDto = new BinDto();
        binDto.setBankId(123);
        binDto.setBin("Bin");
        binDto.setId(1);
        assertThrows(InvalidParameterException.class, () -> this.binServiceImpl.updateBin(123, binDto));
    }

    @Test
    void testGetOneBin() {
        Bin bin = new Bin();
        bin.setBankId(123);
        bin.setBin("Bin");
        bin.setId(1);
        Optional<Bin> ofResult = Optional.of(bin);
        when(this.binRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(bin, this.binServiceImpl.getOneBin(1));
        verify(this.binRepository).findById((Integer) any());
        assertTrue(this.binServiceImpl.getBins().isEmpty());
    }

    @Test
    void testGetOneBin2() {
        when(this.binRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> this.binServiceImpl.getOneBin(1));
        verify(this.binRepository).findById((Integer) any());
    }

    @Test
    void testGetOneBin3() {
        when(this.binRepository.findById((Integer) any())).thenThrow(new InvalidParameterException("Bin not found"));
        assertThrows(InvalidParameterException.class, () -> this.binServiceImpl.getOneBin(1));
        verify(this.binRepository).findById((Integer) any());
    }

    @Test
    void testDeleteBin() {
        doNothing().when(this.binRepository).deleteById((Integer) any());
        assertTrue(this.binServiceImpl.deleteBin(1));
        verify(this.binRepository).deleteById((Integer) any());
        assertTrue(this.binServiceImpl.getBins().isEmpty());
    }

    @Test
    void testDeleteBin2() {
        doThrow(new InvalidParameterException("Exception")).when(this.binRepository).deleteById((Integer) any());
        assertThrows(InvalidParameterException.class, () -> this.binServiceImpl.deleteBin(1));
        verify(this.binRepository).deleteById((Integer) any());
    }

    @Test
    void testGetBins() {
        ArrayList<Bin> binList = new ArrayList<>();
        when(this.binRepository.findAll()).thenReturn(binList);
        List<Bin> actualBins = this.binServiceImpl.getBins();
        assertSame(binList, actualBins);
        assertTrue(actualBins.isEmpty());
        verify(this.binRepository).findAll();
    }

    @Test
    void testGetBins2() {
        when(this.binRepository.findAll()).thenThrow(new InvalidParameterException("Exception"));
        assertThrows(InvalidParameterException.class, () -> this.binServiceImpl.getBins());
        verify(this.binRepository).findAll();
    }
}

