package com.buleualexandru.assignment1.dto;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class MesurmentDto {


    private LocalDateTime timestamp;
    private String consumption;
    private Long deviceId;

    public MesurmentDto() {
    }

    public MesurmentDto(LocalDateTime timestamp, String consumption, Long deviceId) {
        this.timestamp = timestamp;
        this.consumption = consumption;
        this.deviceId = deviceId;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getConsumption() {
        return consumption;
    }

    public Long getDeviceId() {
        return deviceId;
    }


}
