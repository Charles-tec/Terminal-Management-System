package com.terminalmanagementsystem.repositories;

import com.terminalmanagementsystem.models.Capk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CapkRepository extends JpaRepository <Capk,Integer>{

    void deleteById(Integer id);

    List<Capk>findAll();

    List<Capk>findAllByBankName(String name);
}
