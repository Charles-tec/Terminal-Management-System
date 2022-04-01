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

import com.terminalmanagementsystem.dtos.EmvDto;
import com.terminalmanagementsystem.exceptions.InvalidParameterException;
import com.terminalmanagementsystem.models.Emv;
import com.terminalmanagementsystem.repositories.EmvRepository;

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

@ContextConfiguration(classes = {EmvServiceImpl.class})
@ExtendWith(SpringExtension.class)
class EmvServiceImplTest {
    @MockBean
    private EmvRepository emvRepository;

    @Autowired
    private EmvServiceImpl emvServiceImpl;

    @Test
    void testCreateEmv() {
        Emv emv = new Emv();
        emv.setBankId(123);
        emv.setDescription("The characteristics of someone or something");
        emv.setId(1);
        emv.setMandatory(true);
        emv.setMaxLength(3);
        emv.setMinLength(3);
        emv.setTag("Tag");
        when(this.emvRepository.save((Emv) any())).thenReturn(emv);

        EmvDto emvDto = new EmvDto();
        emvDto.setBankId(123);
        emvDto.setDescription("The characteristics of someone or something");
        emvDto.setId(1);
        emvDto.setMandatory(true);
        emvDto.setMaxLength(3);
        emvDto.setMinLength(3);
        emvDto.setTag("Tag");
        assertSame(emv, this.emvServiceImpl.createEmv(emvDto));
        verify(this.emvRepository, atLeast(1)).save((Emv) any());
        assertTrue(this.emvServiceImpl.getEmvs().isEmpty());
    }

    @Test
    void testCreateEmv2() {
        when(this.emvRepository.save((Emv) any())).thenThrow(new InvalidParameterException("Exception"));

        EmvDto emvDto = new EmvDto();
        emvDto.setBankId(123);
        emvDto.setDescription("The characteristics of someone or something");
        emvDto.setId(1);
        emvDto.setMandatory(true);
        emvDto.setMaxLength(3);
        emvDto.setMinLength(3);
        emvDto.setTag("Tag");
        assertThrows(InvalidParameterException.class, () -> this.emvServiceImpl.createEmv(emvDto));
        verify(this.emvRepository).save((Emv) any());
    }

    @Test
    void testUpdateEmv() {
        Emv emv = new Emv();
        emv.setBankId(123);
        emv.setDescription("The characteristics of someone or something");
        emv.setId(1);
        emv.setMandatory(true);
        emv.setMaxLength(3);
        emv.setMinLength(3);
        emv.setTag("Tag");
        when(this.emvRepository.save((Emv) any())).thenReturn(emv);
        when(this.emvRepository.existsById((Integer) any())).thenReturn(true);

        EmvDto emvDto = new EmvDto();
        emvDto.setBankId(123);
        emvDto.setDescription("The characteristics of someone or something");
        emvDto.setId(1);
        emvDto.setMandatory(true);
        emvDto.setMaxLength(3);
        emvDto.setMinLength(3);
        emvDto.setTag("Tag");
        assertSame(emv, this.emvServiceImpl.updateEmv(1, emvDto));
        verify(this.emvRepository).existsById((Integer) any());
        verify(this.emvRepository).save((Emv) any());
        assertTrue(this.emvServiceImpl.getEmvs().isEmpty());
    }

    @Test
    void testUpdateEmv2() {
        when(this.emvRepository.save((Emv) any())).thenThrow(new InvalidParameterException("Exception"));
        when(this.emvRepository.existsById((Integer) any())).thenReturn(true);

        EmvDto emvDto = new EmvDto();
        emvDto.setBankId(123);
        emvDto.setDescription("The characteristics of someone or something");
        emvDto.setId(1);
        emvDto.setMandatory(true);
        emvDto.setMaxLength(3);
        emvDto.setMinLength(3);
        emvDto.setTag("Tag");
        assertThrows(InvalidParameterException.class, () -> this.emvServiceImpl.updateEmv(1, emvDto));
        verify(this.emvRepository).existsById((Integer) any());
        verify(this.emvRepository).save((Emv) any());
    }

    @Test
    void testUpdateEmv3() {
        Emv emv = new Emv();
        emv.setBankId(123);
        emv.setDescription("The characteristics of someone or something");
        emv.setId(1);
        emv.setMandatory(true);
        emv.setMaxLength(3);
        emv.setMinLength(3);
        emv.setTag("Tag");
        when(this.emvRepository.save((Emv) any())).thenReturn(emv);
        when(this.emvRepository.existsById((Integer) any())).thenReturn(false);

        EmvDto emvDto = new EmvDto();
        emvDto.setBankId(123);
        emvDto.setDescription("The characteristics of someone or something");
        emvDto.setId(1);
        emvDto.setMandatory(true);
        emvDto.setMaxLength(3);
        emvDto.setMinLength(3);
        emvDto.setTag("Tag");
        assertThrows(EntityNotFoundException.class, () -> this.emvServiceImpl.updateEmv(1, emvDto));
        verify(this.emvRepository).existsById((Integer) any());
    }

    @Test
    void testUpdateEmv4() {
        Emv emv = new Emv();
        emv.setBankId(123);
        emv.setDescription("The characteristics of someone or something");
        emv.setId(1);
        emv.setMandatory(true);
        emv.setMaxLength(3);
        emv.setMinLength(3);
        emv.setTag("Tag");
        when(this.emvRepository.save((Emv) any())).thenReturn(emv);
        when(this.emvRepository.existsById((Integer) any())).thenReturn(true);

        EmvDto emvDto = new EmvDto();
        emvDto.setBankId(123);
        emvDto.setDescription("The characteristics of someone or something");
        emvDto.setId(1);
        emvDto.setMandatory(true);
        emvDto.setMaxLength(3);
        emvDto.setMinLength(3);
        emvDto.setTag("Tag");
        assertThrows(InvalidParameterException.class, () -> this.emvServiceImpl.updateEmv(123, emvDto));
    }

    @Test
    void testGetOneEmv() {
        Emv emv = new Emv();
        emv.setBankId(123);
        emv.setDescription("The characteristics of someone or something");
        emv.setId(1);
        emv.setMandatory(true);
        emv.setMaxLength(3);
        emv.setMinLength(3);
        emv.setTag("Tag");
        Optional<Emv> ofResult = Optional.of(emv);
        when(this.emvRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(emv, this.emvServiceImpl.getOneEmv(1));
        verify(this.emvRepository).findById((Integer) any());
        assertTrue(this.emvServiceImpl.getEmvs().isEmpty());
    }

    @Test
    void testGetOneEmv2() {
        when(this.emvRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> this.emvServiceImpl.getOneEmv(1));
        verify(this.emvRepository).findById((Integer) any());
    }

    @Test
    void testGetOneEmv3() {
        when(this.emvRepository.findById((Integer) any())).thenThrow(new InvalidParameterException("emv not found"));
        assertThrows(InvalidParameterException.class, () -> this.emvServiceImpl.getOneEmv(1));
        verify(this.emvRepository).findById((Integer) any());
    }

    @Test
    void testDeleteEmv() {
        doNothing().when(this.emvRepository).deleteById((Integer) any());
        assertTrue(this.emvServiceImpl.deleteEmv(1));
        verify(this.emvRepository).deleteById((Integer) any());
        assertTrue(this.emvServiceImpl.getEmvs().isEmpty());
    }

    @Test
    void testDeleteEmv2() {
        doThrow(new InvalidParameterException("Exception")).when(this.emvRepository).deleteById((Integer) any());
        assertThrows(InvalidParameterException.class, () -> this.emvServiceImpl.deleteEmv(1));
        verify(this.emvRepository).deleteById((Integer) any());
    }

    @Test
    void testGetEmvs() {
        ArrayList<Emv> emvList = new ArrayList<>();
        when(this.emvRepository.findAll()).thenReturn(emvList);
        List<Emv> actualEmvs = this.emvServiceImpl.getEmvs();
        assertSame(emvList, actualEmvs);
        assertTrue(actualEmvs.isEmpty());
        verify(this.emvRepository).findAll();
    }

    @Test
    void testGetEmvs2() {
        when(this.emvRepository.findAll()).thenThrow(new InvalidParameterException("Exception"));
        assertThrows(InvalidParameterException.class, () -> this.emvServiceImpl.getEmvs());
        verify(this.emvRepository).findAll();
    }
}

