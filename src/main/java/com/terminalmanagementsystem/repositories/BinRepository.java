package com.terminalmanagementsystem.repositories;


import com.terminalmanagementsystem.models.Bin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BinRepository extends JpaRepository<Bin,Integer> {

    void deleteById(Integer id);

    List<Bin> findAll();
}
