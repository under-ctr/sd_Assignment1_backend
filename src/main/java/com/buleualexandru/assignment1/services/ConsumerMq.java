package com.buleualexandru.assignment1.services;
import com.buleualexandru.assignment1.dto.DeviceDto;
import com.buleualexandru.assignment1.entitys.Device;
import com.buleualexandru.assignment1.entitys.SensorMesurment;
import com.buleualexandru.assignment1.repositories.ClientRepository;
import com.buleualexandru.assignment1.repositories.DeviceRepository;
import com.buleualexandru.assignment1.repositories.SensorMesurmentRepository;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;

public class ConsumerMq {


    private  DeviceRepository deviceRepository;
    private   SensorMesurmentService sensorMesurmentService;

    public ConsumerMq (DeviceRepository deviceRepository, SensorMesurmentService sensorMesurmentService) {
        this.deviceRepository = deviceRepository;
        this.sensorMesurmentService = sensorMesurmentService;

    }

    public ConsumerMq() {
    }

    private final static String QUEUE_NAME = "hello";

    public  void run() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setPort(5672);
        factory.setPassword("n23WmcDJ5ZTvPe21BG8wwyo8EYH2A8DX");
        factory.setUri("amqps://kvyhfmkf:n23WmcDJ5ZTvPe21BG8wwyo8EYH2A8DX@sparrow.rmq.cloudamqp.com/kvyhfmkf");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [x] Received '" + message + "'");
            Long id = 1L;
            Device device = deviceRepository.findById(id).orElseThrow(IllegalStateException::new);
            /*if(device.getMaxHourConsumption() < Float.parseFloat(message)){
                System.out.println("a depasit" + " " + device.getMaxHourConsumption());
                device.setMaxHourConsumption(Float.parseFloat(message));
                SensorMesurment sensorMesurment = new SensorMesurment();
                sensorMesurmentService.insertMesurment()
            }*/
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }
}