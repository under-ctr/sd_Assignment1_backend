package com.buleualexandru.assignment1.controllers;


import com.buleualexandru.assignment1.dto.UserDto;
import com.buleualexandru.assignment1.entitys.Client;
import com.buleualexandru.assignment1.entitys.Device;
import com.buleualexandru.assignment1.services.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RequestMapping(value = "/device")
@RestController
public class DeviceController {

    public final DeviceService deviceService;



    @PostMapping(value = "/add")
    public ResponseEntity<Device> insertClient(@RequestBody Device device) {
        //clientRepository.save(client);
        //UserDto userDto = new UserDto();
        //clientService.createClient(client);
        deviceService.createDevice(device);

        return new ResponseEntity<>( device, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Device>> getAll() {
        //List<Client> clients = clientService.findClients();
        List<Device> devices = deviceService.findDevice();
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Device> getDevice(@PathVariable("id") Long deviceId) {
        //UserDto dto = clientService.findClientById(clientId);
        //Client client = clientService.fin
        Device device = deviceService.findClientById(deviceId);

        return new ResponseEntity<>(device, HttpStatus.OK);
    }


    //trebuie pus si id-ul in body ca sa functioneze updateul
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/{id}")
    public ResponseEntity<Device> update(@RequestBody Device device){

        /*if(clientService.isPresent(client.getId())) {
            clientService.update(client);
        }*/
        Device newDevice = deviceService.update(device);
        return new ResponseEntity<>(newDevice, HttpStatus.OK);
    }

    @DeleteMapping( value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long deviceId){
        //clientService.delete(clientId);
        deviceService.delete(deviceId);

        return ResponseEntity.noContent().build();
    }


}
