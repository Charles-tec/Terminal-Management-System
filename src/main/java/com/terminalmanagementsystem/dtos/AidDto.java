package com.terminalmanagementsystem.dtos;

import lombok.Data;

@Data
public class AidDto {
    Integer id;
    String aid;
    String vendor;
    String country;
    String name;
    String description;
    String type;
    Integer bankId;
}
