package com.terminalmanagementsystem.repositories;

import com.terminalmanagementsystem.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BankRepository extends JpaRepository<Bank,Integer> {

    void deleteById(Integer id);

    List<Bank> findAll();


   @Query("SELECT b.name as name FROM Bank b WHERE b.id=:id")
    String findBankNameById(Integer id);

}
