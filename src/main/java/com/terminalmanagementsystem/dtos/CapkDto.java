package com.terminalmanagementsystem.dtos;

import lombok.Data;

@Data
public class CapkDto {
    private Integer id;
    private String issuer;
    private Integer exponent;
    private Integer ridIndex;
    private String modulus;
    private Integer keyLength;
    private String sha1;
    private String keyType;
    private String expires;
    private Integer bankId;

}
