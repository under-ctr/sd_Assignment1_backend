package com.buleualexandru.assignment1.dto;




public class UserDetailsDTO{
    private String name;

    private String address;

    private String role;

    private Long deviceId;

    public UserDetailsDTO() {
    }

    public UserDetailsDTO(String name, String address, String role, Long deviceId) {
        this.name = name;
        this.address = address;
        this.role = role;
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getAddress() {
        return address;
    }

    public String getRole() {
        return role;
    }

    public Long getDeviceId() {
        return deviceId;
    }
}
