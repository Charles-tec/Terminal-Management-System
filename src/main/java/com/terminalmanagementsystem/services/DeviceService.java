package com.terminalmanagementsystem.services;

import com.terminalmanagementsystem.dtos.DeviceDto;
import com.terminalmanagementsystem.models.Device;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public interface DeviceService {
    Device createDevice(DeviceDto deviceDto);

    Device updateDevice(@NotNull Integer id, @NotNull DeviceDto deviceDto);

    Device getOneDevice(Integer id);

    Boolean  deleteDevice(Integer id);
    List<Device> getDevices();
}
