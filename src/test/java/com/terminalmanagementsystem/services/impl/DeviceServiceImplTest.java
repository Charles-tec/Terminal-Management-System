package com.terminalmanagementsystem.services.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.terminalmanagementsystem.dtos.DeviceDto;
import com.terminalmanagementsystem.exceptions.InvalidParameterException;
import com.terminalmanagementsystem.models.Device;
import com.terminalmanagementsystem.repositories.DeviceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DeviceServiceImpl.class})
@ExtendWith(SpringExtension.class)
class DeviceServiceImplTest {
    @MockBean
    private DeviceRepository deviceRepository;

    @Autowired
    private DeviceServiceImpl deviceServiceImpl;

    @Test
    void testCreateDevice() {
        Device device = new Device();
        device.setAreaNumber("42");
        device.setAvailableFlag(1);
        device.setBankId(123);
        device.setBranchNumber("janedoe/featurebranch");
        device.setCompanyNumber("42");
        device.setCreateDate("2020-03-01");
        device.setId(1);
        device.setImei("Imei");
        device.setMarketNumber("42");
        device.setOperator("Operator");
        device.setPosType("Pos Type");
        device.setSerialNumber(10);
        device.setShopNumber(10);
        device.setTerminalNumber("42");
        device.setUpdateDate("2020-03-01");
        device.setUpgradeFlag(1);
        device.setUpgradeVersion("1.0.2");
        when(this.deviceRepository.save((Device) any())).thenReturn(device);

        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setAreaNumber("42");
        deviceDto.setAvailableFlag(1);
        deviceDto.setBankId(123);
        deviceDto.setBranchNumber("janedoe/featurebranch");
        deviceDto.setCompanyNumber("42");
        deviceDto.setCreateDate("2020-03-01");
        deviceDto.setId(1);
        deviceDto.setImei("Imei");
        deviceDto.setMarketNumber("42");
        deviceDto.setOperator("Operator");
        deviceDto.setPosType("Pos Type");
        deviceDto.setSerialNumber(10);
        deviceDto.setShopNumber(10);
        deviceDto.setTerminalNumber("42");
        deviceDto.setUpdateDate("2020-03-01");
        deviceDto.setUpgradeFlag(1);
        deviceDto.setUpgradeVersion("1.0.2");
        assertSame(device, this.deviceServiceImpl.createDevice(deviceDto));
        verify(this.deviceRepository, atLeast(1)).save((Device) any());
        assertTrue(this.deviceServiceImpl.getDevices().isEmpty());
    }

    @Test
    void testUpdateDevice() {
        Device device = new Device();
        device.setAreaNumber("42");
        device.setAvailableFlag(1);
        device.setBankId(123);
        device.setBranchNumber("janedoe/featurebranch");
        device.setCompanyNumber("42");
        device.setCreateDate("2020-03-01");
        device.setId(1);
        device.setImei("Imei");
        device.setMarketNumber("42");
        device.setOperator("Operator");
        device.setPosType("Pos Type");
        device.setSerialNumber(10);
        device.setShopNumber(10);
        device.setTerminalNumber("42");
        device.setUpdateDate("2020-03-01");
        device.setUpgradeFlag(1);
        device.setUpgradeVersion("1.0.2");
        when(this.deviceRepository.save((Device) any())).thenReturn(device);
        when(this.deviceRepository.existsById((Integer) any())).thenReturn(true);

        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setAreaNumber("42");
        deviceDto.setAvailableFlag(1);
        deviceDto.setBankId(123);
        deviceDto.setBranchNumber("janedoe/featurebranch");
        deviceDto.setCompanyNumber("42");
        deviceDto.setCreateDate("2020-03-01");
        deviceDto.setId(1);
        deviceDto.setImei("Imei");
        deviceDto.setMarketNumber("42");
        deviceDto.setOperator("Operator");
        deviceDto.setPosType("Pos Type");
        deviceDto.setSerialNumber(10);
        deviceDto.setShopNumber(10);
        deviceDto.setTerminalNumber("42");
        deviceDto.setUpdateDate("2020-03-01");
        deviceDto.setUpgradeFlag(1);
        deviceDto.setUpgradeVersion("1.0.2");
        assertSame(device, this.deviceServiceImpl.updateDevice(1, deviceDto));
        verify(this.deviceRepository).existsById((Integer) any());
        verify(this.deviceRepository).save((Device) any());
        assertTrue(this.deviceServiceImpl.getDevices().isEmpty());
    }

    @Test
    void testUpdateDevice2() {
        when(this.deviceRepository.save((Device) any())).thenThrow(new InvalidParameterException("Exception"));
        when(this.deviceRepository.existsById((Integer) any())).thenReturn(true);

        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setAreaNumber("42");
        deviceDto.setAvailableFlag(1);
        deviceDto.setBankId(123);
        deviceDto.setBranchNumber("janedoe/featurebranch");
        deviceDto.setCompanyNumber("42");
        deviceDto.setCreateDate("2020-03-01");
        deviceDto.setId(1);
        deviceDto.setImei("Imei");
        deviceDto.setMarketNumber("42");
        deviceDto.setOperator("Operator");
        deviceDto.setPosType("Pos Type");
        deviceDto.setSerialNumber(10);
        deviceDto.setShopNumber(10);
        deviceDto.setTerminalNumber("42");
        deviceDto.setUpdateDate("2020-03-01");
        deviceDto.setUpgradeFlag(1);
        deviceDto.setUpgradeVersion("1.0.2");
        assertThrows(InvalidParameterException.class, () -> this.deviceServiceImpl.updateDevice(1, deviceDto));
        verify(this.deviceRepository).existsById((Integer) any());
        verify(this.deviceRepository).save((Device) any());
    }

    @Test
    void testUpdateDevice3() {
        Device device = new Device();
        device.setAreaNumber("42");
        device.setAvailableFlag(1);
        device.setBankId(123);
        device.setBranchNumber("janedoe/featurebranch");
        device.setCompanyNumber("42");
        device.setCreateDate("2020-03-01");
        device.setId(1);
        device.setImei("Imei");
        device.setMarketNumber("42");
        device.setOperator("Operator");
        device.setPosType("Pos Type");
        device.setSerialNumber(10);
        device.setShopNumber(10);
        device.setTerminalNumber("42");
        device.setUpdateDate("2020-03-01");
        device.setUpgradeFlag(1);
        device.setUpgradeVersion("1.0.2");
        when(this.deviceRepository.save((Device) any())).thenReturn(device);
        when(this.deviceRepository.existsById((Integer) any())).thenReturn(false);

        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setAreaNumber("42");
        deviceDto.setAvailableFlag(1);
        deviceDto.setBankId(123);
        deviceDto.setBranchNumber("janedoe/featurebranch");
        deviceDto.setCompanyNumber("42");
        deviceDto.setCreateDate("2020-03-01");
        deviceDto.setId(1);
        deviceDto.setImei("Imei");
        deviceDto.setMarketNumber("42");
        deviceDto.setOperator("Operator");
        deviceDto.setPosType("Pos Type");
        deviceDto.setSerialNumber(10);
        deviceDto.setShopNumber(10);
        deviceDto.setTerminalNumber("42");
        deviceDto.setUpdateDate("2020-03-01");
        deviceDto.setUpgradeFlag(1);
        deviceDto.setUpgradeVersion("1.0.2");
        assertThrows(EntityNotFoundException.class, () -> this.deviceServiceImpl.updateDevice(1, deviceDto));
        verify(this.deviceRepository).existsById((Integer) any());
    }

    @Test
    void testUpdateDevice4() {
        Device device = new Device();
        device.setAreaNumber("42");
        device.setAvailableFlag(1);
        device.setBankId(123);
        device.setBranchNumber("janedoe/featurebranch");
        device.setCompanyNumber("42");
        device.setCreateDate("2020-03-01");
        device.setId(1);
        device.setImei("Imei");
        device.setMarketNumber("42");
        device.setOperator("Operator");
        device.setPosType("Pos Type");
        device.setSerialNumber(10);
        device.setShopNumber(10);
        device.setTerminalNumber("42");
        device.setUpdateDate("2020-03-01");
        device.setUpgradeFlag(1);
        device.setUpgradeVersion("1.0.2");
        when(this.deviceRepository.save((Device) any())).thenReturn(device);
        when(this.deviceRepository.existsById((Integer) any())).thenReturn(true);

        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setAreaNumber("42");
        deviceDto.setAvailableFlag(1);
        deviceDto.setBankId(123);
        deviceDto.setBranchNumber("janedoe/featurebranch");
        deviceDto.setCompanyNumber("42");
        deviceDto.setCreateDate("2020-03-01");
        deviceDto.setId(1);
        deviceDto.setImei("Imei");
        deviceDto.setMarketNumber("42");
        deviceDto.setOperator("Operator");
        deviceDto.setPosType("Pos Type");
        deviceDto.setSerialNumber(10);
        deviceDto.setShopNumber(10);
        deviceDto.setTerminalNumber("42");
        deviceDto.setUpdateDate("2020-03-01");
        deviceDto.setUpgradeFlag(1);
        deviceDto.setUpgradeVersion("1.0.2");
        assertThrows(InvalidParameterException.class, () -> this.deviceServiceImpl.updateDevice(123, deviceDto));
    }

    @Test
    void testGetOneDevice() {
        Device device = new Device();
        device.setAreaNumber("42");
        device.setAvailableFlag(1);
        device.setBankId(123);
        device.setBranchNumber("janedoe/featurebranch");
        device.setCompanyNumber("42");
        device.setCreateDate("2020-03-01");
        device.setId(1);
        device.setImei("Imei");
        device.setMarketNumber("42");
        device.setOperator("Operator");
        device.setPosType("Pos Type");
        device.setSerialNumber(10);
        device.setShopNumber(10);
        device.setTerminalNumber("42");
        device.setUpdateDate("2020-03-01");
        device.setUpgradeFlag(1);
        device.setUpgradeVersion("1.0.2");
        Optional<Device> ofResult = Optional.of(device);
        when(this.deviceRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(device, this.deviceServiceImpl.getOneDevice(1));
        verify(this.deviceRepository).findById((Integer) any());
        assertTrue(this.deviceServiceImpl.getDevices().isEmpty());
    }

    @Test
    void testGetOneDevice2() {
        when(this.deviceRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> this.deviceServiceImpl.getOneDevice(1));
        verify(this.deviceRepository).findById((Integer) any());
    }

    @Test
    void testGetOneDevice3() {
        when(this.deviceRepository.findById((Integer) any())).thenThrow(new InvalidParameterException("Device not found"));
        assertThrows(InvalidParameterException.class, () -> this.deviceServiceImpl.getOneDevice(1));
        verify(this.deviceRepository).findById((Integer) any());
    }

    @Test
    void testDeleteDevice() {
        doNothing().when(this.deviceRepository).deleteById((Integer) any());
        assertTrue(this.deviceServiceImpl.deleteDevice(1));
        verify(this.deviceRepository).deleteById((Integer) any());
        assertTrue(this.deviceServiceImpl.getDevices().isEmpty());
    }

    @Test
    void testDeleteDevice2() {
        doThrow(new InvalidParameterException("Exception")).when(this.deviceRepository).deleteById((Integer) any());
        assertThrows(InvalidParameterException.class, () -> this.deviceServiceImpl.deleteDevice(1));
        verify(this.deviceRepository).deleteById((Integer) any());
    }

    @Test
    void testGetDevices() {
        ArrayList<Device> deviceList = new ArrayList<>();
        when(this.deviceRepository.findAll()).thenReturn(deviceList);
        List<Device> actualDevices = this.deviceServiceImpl.getDevices();
        assertSame(deviceList, actualDevices);
        assertTrue(actualDevices.isEmpty());
        verify(this.deviceRepository).findAll();
    }

    @Test
    void testGetDevices2() {
        when(this.deviceRepository.findAll()).thenThrow(new InvalidParameterException("Exception"));
        assertThrows(InvalidParameterException.class, () -> this.deviceServiceImpl.getDevices());
        verify(this.deviceRepository).findAll();
    }
}

