package com.buleualexandru.assignment1.entitys;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "maxHourConsumption", nullable = false)
    private float maxHourConsumption;

    @Column(name = "assigned", nullable = false)
    private boolean assigned;

   /* @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_client", referencedColumnName = "id")
    private Client client;*/

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMaxHourConsumption(float maxHourConsumption) {
        this.maxHourConsumption = maxHourConsumption;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public float getMaxHourConsumption() {
        return maxHourConsumption;
    }

    public boolean isAssigned() {
        return assigned;
    }
}
