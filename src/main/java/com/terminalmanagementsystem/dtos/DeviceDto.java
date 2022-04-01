package com.terminalmanagementsystem.dtos;

import lombok.Data;

@Data
public class DeviceDto {
    Integer id;
    String  imei;
    String posType;
    String companyNumber;
    String marketNumber;
    Integer shopNumber;
    String terminalNumber;
    String areaNumber;
    String branchNumber;
    Integer serialNumber;
    String upgradeVersion;
    Integer upgradeFlag;
    Integer availableFlag;
    String createDate;
    String updateDate;
    String operator;
    Integer bankId;

}
