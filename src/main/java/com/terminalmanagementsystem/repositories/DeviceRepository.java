package com.terminalmanagementsystem.repositories;

import com.terminalmanagementsystem.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Integer> {


    void deleteById(Integer id);

    List<Device> findAll();
}
