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

import com.terminalmanagementsystem.dtos.BankDto;
import com.terminalmanagementsystem.exceptions.InvalidParameterException;
import com.terminalmanagementsystem.models.Bank;
import com.terminalmanagementsystem.repositories.BankRepository;

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

@ContextConfiguration(classes = {BankServiceImpl.class})
@ExtendWith(SpringExtension.class)
class BankServiceImplTest {
    @MockBean
    private BankRepository bankRepository;

    @Autowired
    private BankServiceImpl bankServiceImpl;

    @Test
    void testCreateBank() {
        Bank bank = new Bank();
        bank.setDescription("The characteristics of someone or something");
        bank.setId(1);
        bank.setName("Name");
        when(this.bankRepository.save((Bank) any())).thenReturn(bank);

        BankDto bankDto = new BankDto();
        bankDto.setDescription("The characteristics of someone or something");
        bankDto.setId(1);
        bankDto.setName("Name");
        assertSame(bank, this.bankServiceImpl.createBank(bankDto));
        verify(this.bankRepository, atLeast(1)).save((Bank) any());
        assertTrue(this.bankServiceImpl.getBanks().isEmpty());
    }

    @Test
    void testCreateBank2() {
        when(this.bankRepository.save((Bank) any())).thenThrow(new InvalidParameterException("Exception"));

        BankDto bankDto = new BankDto();
        bankDto.setDescription("The characteristics of someone or something");
        bankDto.setId(1);
        bankDto.setName("Name");
        assertThrows(InvalidParameterException.class, () -> this.bankServiceImpl.createBank(bankDto));
        verify(this.bankRepository).save((Bank) any());
    }

    @Test
    void testUpdateBank() {
        Bank bank = new Bank();
        bank.setDescription("The characteristics of someone or something");
        bank.setId(1);
        bank.setName("Name");
        when(this.bankRepository.save((Bank) any())).thenReturn(bank);
        when(this.bankRepository.existsById((Integer) any())).thenReturn(true);

        BankDto bankDto = new BankDto();
        bankDto.setDescription("The characteristics of someone or something");
        bankDto.setId(1);
        bankDto.setName("Name");
        assertSame(bank, this.bankServiceImpl.updateBank(1, bankDto));
        verify(this.bankRepository).existsById((Integer) any());
        verify(this.bankRepository).save((Bank) any());
        assertTrue(this.bankServiceImpl.getBanks().isEmpty());
    }

    @Test
    void testUpdateBank2() {
        when(this.bankRepository.save((Bank) any())).thenThrow(new InvalidParameterException("Exception"));
        when(this.bankRepository.existsById((Integer) any())).thenReturn(true);

        BankDto bankDto = new BankDto();
        bankDto.setDescription("The characteristics of someone or something");
        bankDto.setId(1);
        bankDto.setName("Name");
        assertThrows(InvalidParameterException.class, () -> this.bankServiceImpl.updateBank(1, bankDto));
        verify(this.bankRepository).existsById((Integer) any());
        verify(this.bankRepository).save((Bank) any());
    }

    @Test
    void testUpdateBank3() {
        Bank bank = new Bank();
        bank.setDescription("The characteristics of someone or something");
        bank.setId(1);
        bank.setName("Name");
        when(this.bankRepository.save((Bank) any())).thenReturn(bank);
        when(this.bankRepository.existsById((Integer) any())).thenReturn(false);

        BankDto bankDto = new BankDto();
        bankDto.setDescription("The characteristics of someone or something");
        bankDto.setId(1);
        bankDto.setName("Name");
        assertThrows(EntityNotFoundException.class, () -> this.bankServiceImpl.updateBank(1, bankDto));
        verify(this.bankRepository).existsById((Integer) any());
    }

    @Test
    void testUpdateBank4() {
        Bank bank = new Bank();
        bank.setDescription("The characteristics of someone or something");
        bank.setId(1);
        bank.setName("Name");
        when(this.bankRepository.save((Bank) any())).thenReturn(bank);
        when(this.bankRepository.existsById((Integer) any())).thenReturn(true);

        BankDto bankDto = new BankDto();
        bankDto.setDescription("The characteristics of someone or something");
        bankDto.setId(1);
        bankDto.setName("Name");
        assertThrows(InvalidParameterException.class, () -> this.bankServiceImpl.updateBank(123, bankDto));
    }

    @Test
    void testGetOneBank() {
        Bank bank = new Bank();
        bank.setDescription("The characteristics of someone or something");
        bank.setId(1);
        bank.setName("Name");
        Optional<Bank> ofResult = Optional.of(bank);
        when(this.bankRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(bank, this.bankServiceImpl.getOneBank(1));
        verify(this.bankRepository).findById((Integer) any());
        assertTrue(this.bankServiceImpl.getBanks().isEmpty());
    }

    @Test
    void testGetOneBank2() {
        when(this.bankRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> this.bankServiceImpl.getOneBank(1));
        verify(this.bankRepository).findById((Integer) any());
    }

    @Test
    void testGetOneBank3() {
        when(this.bankRepository.findById((Integer) any())).thenThrow(new InvalidParameterException("Bank not found"));
        assertThrows(InvalidParameterException.class, () -> this.bankServiceImpl.getOneBank(1));
        verify(this.bankRepository).findById((Integer) any());
    }

    @Test
    void testDeleteBank() {
        doNothing().when(this.bankRepository).deleteById((Integer) any());
        assertTrue(this.bankServiceImpl.deleteBank(1));
        verify(this.bankRepository).deleteById((Integer) any());
        assertTrue(this.bankServiceImpl.getBanks().isEmpty());
    }

    @Test
    void testDeleteBank2() {
        doThrow(new InvalidParameterException("Exception")).when(this.bankRepository).deleteById((Integer) any());
        assertThrows(InvalidParameterException.class, () -> this.bankServiceImpl.deleteBank(1));
        verify(this.bankRepository).deleteById((Integer) any());
    }

    @Test
    void testGetBanks() {
        ArrayList<Bank> bankList = new ArrayList<>();
        when(this.bankRepository.findAll()).thenReturn(bankList);
        List<Bank> actualBanks = this.bankServiceImpl.getBanks();
        assertSame(bankList, actualBanks);
        assertTrue(actualBanks.isEmpty());
        verify(this.bankRepository).findAll();
    }

    @Test
    void testGetBanks2() {
        when(this.bankRepository.findAll()).thenThrow(new InvalidParameterException("Exception"));
        assertThrows(InvalidParameterException.class, () -> this.bankServiceImpl.getBanks());
        verify(this.bankRepository).findAll();
    }
}

