package com.buleualexandru.assignment1.services;

import com.buleualexandru.assignment1.entitys.Device;
import com.buleualexandru.assignment1.entitys.SensorMesurment;
import com.buleualexandru.assignment1.repositories.DeviceRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
public class RabbitLisen {
    private final DeviceRepository deviceRepository;

    private final SensorMesurmentService sensorMesurmentService;
   // private final SimpMessagingTemplate messagingTemplate;

    public RabbitLisen(DeviceRepository deviceRepository, SensorMesurmentService sensorMesurmentService) {
        this.deviceRepository = deviceRepository;
        this.sensorMesurmentService = sensorMesurmentService;
        //this.messagingTemplate = messagingTemplate;
    }

    @RabbitListener(queues = "hello")
    public void run(String message) {
        System.out.println(message);
        String[] splitStr = message.trim().split("\\s+");
        String value = splitStr[0];
        String dateTime = splitStr[1];
        Long deviceId = Long.parseLong(splitStr[2]);
        Double val = Double.parseDouble(value);
        String[] splitTime = dateTime.trim().split("T");
        Device device = deviceRepository.findById(deviceId).orElseThrow(IllegalStateException::new);


        if(device.getMaxHourConsumption() < val){
           // notify("Ai depasit");
            System.out.println(val);
            System.out.println("a depasit" + " " + device.getMaxHourConsumption());
            device.setMaxHourConsumption(30);
            deviceRepository.save(device);
            SensorMesurment sensorMesurment = new SensorMesurment(val, splitTime[1], deviceId);
            sensorMesurmentService.insertMesurment(sensorMesurment);
        }





    }

   /* @CrossOrigin(origins = "http://localhost:3000")
    @MessageMapping("/send/message")
    public void notify(String message){
        System.out.println("--------------------SENT----------------------");
        this.messagingTemplate.convertAndSend("/message", message);
    }*/
}
//System.out.println(device.getAddress() + " " + device.getId());
        /*if (device.getMaxHourConsumption() < Float.parseFloat(message)) {
            System.out.println("a depasit" + " " + device.getMaxHourConsumption());*/
//device.setMaxHourConsumption(Float.parseFloat(message));
//SensorMesurment sensorMesurment = new SensorMesurment(val, splitTime[1], deviceId);
//sensorMesurmentService.insertMesurment(sensorMesurment);
       /* DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(time, timeFormatter);
        long timestamp = Timestamp.valueOf(dateTime).getTime();        long timestamp = Timestamp.valueOf(dateTime).getTime();*/