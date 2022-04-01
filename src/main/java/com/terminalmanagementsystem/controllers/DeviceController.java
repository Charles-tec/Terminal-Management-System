package com.terminalmanagementsystem.controllers;

import com.terminalmanagementsystem.dtos.DeviceDto;
import com.terminalmanagementsystem.models.Device;
import com.terminalmanagementsystem.services.DeviceService;
import com.terminalmanagementsystem.util.Response;
import com.terminalmanagementsystem.util.ResponseBuild;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/devices")
public class DeviceController {

    private final DeviceService deviceService;
    private final ResponseBuild<Device> deviceResponseBuild;


    @GetMapping("/")
    public ResponseEntity<Response> getAllDevices(){

        return new ResponseEntity<>(deviceResponseBuild.listResponseFunction.
                apply(deviceService.getDevices()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response>getOneDevice(@PathVariable Integer id){

        return new ResponseEntity<>(deviceResponseBuild.responseFunction.
                apply(deviceService.getOneDevice(id)),HttpStatus.OK);
    }

    @PostMapping("/save-device")
    public ResponseEntity<Response> createDevice(@RequestBody DeviceDto deviceDto){

        return new ResponseEntity<>(deviceResponseBuild.responseFunction.
                apply(deviceService.createDevice(deviceDto)),HttpStatus.OK);
    }

    @PutMapping("/update-device/{id}")
    public ResponseEntity<Response>updateDevice(@PathVariable("id")Integer id, @RequestBody DeviceDto deviceDto){

        return new ResponseEntity<>(deviceResponseBuild.responseFunction.
                apply(deviceService.updateDevice(id, deviceDto)),HttpStatus.OK);
    }

    @DeleteMapping("/delete-device/{id}")
    public ResponseEntity<Boolean> deleteDevice(@PathVariable ("id")Integer id){

        return new ResponseEntity<>(deviceService.deleteDevice(id),HttpStatus.OK);
    }

}
