package com.terminalmanagementsystem.repositories;


import com.terminalmanagementsystem.models.Emv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmvRepository extends JpaRepository<Emv, Integer> {

    void deleteById(Integer id);

    List<Emv> findAll();
}


