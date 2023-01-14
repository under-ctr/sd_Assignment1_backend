package com.buleualexandru.assignment1.entitys;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@AllArgsConstructor

@Table(name = "SensorMesurment")

public class SensorMesurment {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "timestamp", nullable = false)
        private String timestamp;

        @Column(name = "consumption", nullable = false)
        private double consumption;

        @Column(name = "deviceId", nullable = false)
        private Long deviceId;

        public void setId(Long id) {
                this.id = id;
        }

        public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
        }

        public SensorMesurment() {
        }

        public SensorMesurment(double consumption, String timestamp, Long deviceId) {
                this.timestamp = timestamp;
                this.consumption = consumption;
                this.deviceId = deviceId;
        }

        public void setConsumption(double consumption) {
                this.consumption = consumption;
        }

        public void setDeviceId(Long deviceId) {
                this.deviceId = deviceId;
        }

        public Long getId() {
                return id;
        }

        public String getTimestamp() {
                return timestamp;
        }

        public double getConsumption() {
                return consumption;
        }

        public Long getDeviceId() {
                return deviceId;
        }
}
