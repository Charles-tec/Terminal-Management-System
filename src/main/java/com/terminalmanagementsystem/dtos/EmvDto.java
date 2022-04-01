package com.terminalmanagementsystem.dtos;

import lombok.Data;

@Data
public class EmvDto {
    Integer id;
    String tag;
    String description;
    Integer minLength;
    Integer maxLength;
    boolean mandatory;
    Integer bankId;

}
