package com.terminalmanagementsystem.repositories;

import com.terminalmanagementsystem.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BankRepository extends JpaRepository<Bank,Integer> {

    void deleteById(Integer id);

    List<Bank> findAll();

}
