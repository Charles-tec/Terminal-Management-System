package com.terminalmanagementsystem.repositories;

import com.terminalmanagementsystem.models.Aid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AidRepository extends JpaRepository<Aid, Integer> {

    void deleteById(Integer id);

    List<Aid> findAll();
}
