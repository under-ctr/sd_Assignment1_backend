package com.buleualexandru.assignment1.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class DeviceDto {


    private Long id;

    private String address;

    private String description;

    private float maxHourConsumption;

    private boolean assigned;

}
