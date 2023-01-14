package com.buleualexandru.assignment1.services;

import com.buleualexandru.assignment1.dto.UserDto;
import com.buleualexandru.assignment1.dto.builders.ClientBuilder;
import com.buleualexandru.assignment1.entitys.Client;
import com.buleualexandru.assignment1.entitys.Device;
import com.buleualexandru.assignment1.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Device createDevice(Device device) {
        device.setDescription(device.getDescription());
        device.setMaxHourConsumption(device.getMaxHourConsumption());
        device.setAssigned(device.isAssigned());
        device.setAddress(device.getAddress());
        Device saveDevice = deviceRepository.save(device);

        return saveDevice;
    }

    public List<Device> findDevice() {
        List<Device> devicetList = deviceRepository.findAll();
        return devicetList.stream().collect(Collectors.toList());
    }

    public Device findClientById(Long id) {
        Device deviceOptional = deviceRepository.findById(id).orElseThrow(IllegalStateException::new);

        return deviceOptional;
    }

    /*public boolean isPresent(Long id){
        boolean itIs = clientRepository.findById(id).isPresent();
        if(itIs)
            return true;
        else {
            return false;
        }
    }*/
    public Device update( Device newInfo) {

        return deviceRepository.save(newInfo);

    }

    public void delete (Long deviceId){
        deviceRepository.deleteById(deviceId);
    }
}
