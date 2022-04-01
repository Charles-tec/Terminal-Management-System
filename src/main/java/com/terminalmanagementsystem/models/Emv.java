package com.terminalmanagementsystem.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "emv")
public class Emv {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tag")
    private String tag;

    @Column(name = "description")
    private String description;

    @Column(name = "min_length")
    private Integer minLength;

    @Column(name = "max_length")
    private Integer maxLength;

    @Column(name = "mandatory")
    private Boolean mandatory;

    @Column(name = "bank_id")
    private Integer bankId;

}
