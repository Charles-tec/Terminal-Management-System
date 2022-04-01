package com.terminalmanagementsystem.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "imei")
    private String imei;

    @Column(name = "pos_type")
    private String posType;

    @Column(name = "company_number")
    private String companyNumber;

    @Column(name = "market_number")
    private String marketNumber;

    @Column(name = "shop_number")
    private Integer shopNumber;

    @Column(name = "terminal_number")
    private String terminalNumber;

    @Column(name = "area_number")
    private String areaNumber;

    @Column(name = "branch_number")
    private String branchNumber;

    @Column(name = "serial_number")
    private Integer serialNumber;

    @Column(name = "upgrade_version")
    private String upgradeVersion;

    @Column(name = "upgrade_flag")
    private Integer upgradeFlag;

    @Column(name = "available_flag")
    private Integer availableFlag;

    @Column(name = "create_date")
    private String createDate;

    @Column(name = "update_date")
    private String updateDate;

    @Column(name = "operator")
    private String operator;

    @Column(name = "Bank_id")
    private Integer bankId;


}
