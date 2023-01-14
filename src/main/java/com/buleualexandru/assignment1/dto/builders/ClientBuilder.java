package com.buleualexandru.assignment1.dto.builders;

import com.buleualexandru.assignment1.dto.UserDetailsDTO;
import com.buleualexandru.assignment1.dto.UserDto;
import com.buleualexandru.assignment1.entitys.Client;

public class ClientBuilder {

    private ClientBuilder(){

    }

    public static UserDto toClientDTO(Client client) {
        return new UserDto(client.getId(), client.getName());
    }

    public static UserDetailsDTO toClientDetailsDTO(Client client) {
        return new UserDetailsDTO( client.getName(), client.getAddress(), client.getRole(), client.getDeviceId());
    }
}
