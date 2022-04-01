package com.terminalmanagementsystem.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@RequiredArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "aid")
public class Aid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "aid")
    private String aid;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "country")
    private String country;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "bank_id")
    private Integer bankId;


}
