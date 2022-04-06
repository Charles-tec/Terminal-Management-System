package com.terminalmanagementsystem.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "capk")
public class Capk {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "issuer")
    private String issuer;

    @Column(name = "exponent")
    private Integer exponent;

    @Column(name = "rid_index")
    private Integer ridIndex;

    @Column(name = "modulus")
    private String modulus;

    @Column(name = "key_length")
    private Integer keyLength;

    @Column(name = "sha1")
    private String sha1;

    @Column(name = "key_type")
    private String keyType;

    @Column(name = "expires")
    private String expires;

    @Column(name = "bank_id")
    private Integer bankId;

    @Column(name="bank_name")
    private String bankName;
}
