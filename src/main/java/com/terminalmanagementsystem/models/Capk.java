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

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIssuer() {
        return this.issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public Integer getExponent() {
        return this.exponent;
    }

    public void setExponent(Integer exponent) {
        this.exponent = exponent;
    }

    public Integer getRidIndex() {
        return this.ridIndex;
    }

    public void setRidIndex(Integer ridIndex) {
        this.ridIndex = ridIndex;
    }

    public String getModulus() {
        return this.modulus;
    }

    public void setModulus(String modulus) {
        this.modulus = modulus;
    }

    public Integer getKeyLength() {
        return this.keyLength;
    }

    public void setKeyLength(Integer keyLength) {
        this.keyLength = keyLength;
    }

    public String getSha1() {
        return this.sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public String getKeyType() {
        return this.keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String getExpires() {
        return this.expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public Integer getBankId() {
        return this.bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }
}
