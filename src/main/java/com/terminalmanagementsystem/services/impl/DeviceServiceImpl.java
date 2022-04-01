package com.terminalmanagementsystem.services.impl;


import com.terminalmanagementsystem.dtos.DeviceDto;
import com.terminalmanagementsystem.exceptions.InvalidParameterException;

import com.terminalmanagementsystem.models.Device;
import com.terminalmanagementsystem.repositories.DeviceRepository;
import com.terminalmanagementsystem.services.DeviceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;


@Slf4j
@RequiredArgsConstructor
@Service
public class DeviceServiceImpl implements DeviceService {

    public final DeviceRepository deviceRepository;
    @Override
    public Device createDevice(DeviceDto deviceDto) {
        Device device = new Device();
        device.setImei(deviceDto.getImei());
        device.setPosType(deviceDto.getPosType());
        device.setCompanyNumber(deviceDto.getCompanyNumber());
        device.setMarketNumber(deviceDto.getMarketNumber());
        device.setShopNumber(deviceDto.getShopNumber());
        device.setTerminalNumber(deviceDto.getTerminalNumber());
        device.setAreaNumber(deviceDto.getAreaNumber());
        device.setBranchNumber(deviceDto.getBranchNumber());
        device.setSerialNumber(deviceDto.getSerialNumber());
        device.setUpgradeVersion(deviceDto.getUpgradeVersion());
        device.setUpgradeFlag(deviceDto.getUpgradeFlag());
        device.setAvailableFlag(deviceDto.getAvailableFlag());
        device.setCreateDate(deviceDto.getCreateDate());
        device.setUpdateDate(deviceDto.getUpdateDate());
        device.setOperator(deviceDto.getOperator());
        device.setBankId(deviceDto.getBankId());
        deviceRepository.save(device);


        return  deviceRepository.save(device);
    }

    @Override
    public Device updateDevice(@NotNull Integer id, @NotNull DeviceDto deviceDto) {

        if (!Objects.equals(id, deviceDto.getId())) {
            throw new InvalidParameterException("Invalid details");
        }

        if (!deviceRepository.existsById(id)) {
            throw new EntityNotFoundException("device with provided id not found");
        }

        Device device = new Device();
        device.setId(deviceDto.getId());
        device.setImei(deviceDto.getImei());
        device.setPosType(deviceDto.getPosType());
        device.setCompanyNumber(deviceDto.getCompanyNumber());
        device.setMarketNumber(deviceDto.getMarketNumber());
        device.setShopNumber(deviceDto.getShopNumber());
        device.setTerminalNumber(deviceDto.getTerminalNumber());
        device.setAreaNumber(deviceDto.getAreaNumber());
        device.setBranchNumber(deviceDto.getBranchNumber());
        device.setSerialNumber(deviceDto.getSerialNumber());
        device.setUpgradeVersion(deviceDto.getUpgradeVersion());
        device.setUpgradeFlag(deviceDto.getUpgradeFlag());
        device.setAvailableFlag(deviceDto.getAvailableFlag());
        device.setCreateDate(deviceDto.getCreateDate());
        device.setUpdateDate(deviceDto.getUpdateDate());
        device.setOperator(deviceDto.getOperator());
        device.setBankId(deviceDto.getBankId());
        return  deviceRepository.save(device);
    }

    @Override
    public Device getOneDevice(Integer id) {
        return deviceRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("Device not found"));
    }

    @Override
    public Boolean deleteDevice(Integer id) {
        deviceRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Device> getDevices() {
        return deviceRepository.findAll();

    }

}
