package com.buleualexandru.assignment1.services;

import com.buleualexandru.assignment1.dto.UserDto;
import com.buleualexandru.assignment1.dto.builders.ClientBuilder;
import com.buleualexandru.assignment1.entitys.Client;
import com.buleualexandru.assignment1.repositories.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ClientService {
    private final ClientRepository clientRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findClients() {
        List<Client> clientList = clientRepository.findAll();
        return clientList.stream().collect(Collectors.toList());
    }

    public UserDto findClientById(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (!clientOptional.isPresent()) {
            LOGGER.error("Person with id {} was not found in db", id);

        }

        return ClientBuilder.toClientDTO(clientOptional.get());
    }

    public boolean isPresent(Long id){
        boolean itIs = clientRepository.findById(id).isPresent();
        if(itIs)
            return true;
        else {
            return false;
        }
    }
    public Client update( Client newInfo) {

        return clientRepository.save(newInfo);

    }

    public void delete (Long clientId){
        clientRepository.deleteById(clientId);
    }



    public Client createClient(Client client) {
        client.setName(client.getName());
        client.setAddress(client.getAddress());
        client.setPassword(client.getPassword());
        client.setRole(client.getRole());
        client.setDeviceId(client.getDeviceId());
        Client saveClient = clientRepository.save(client);

        return saveClient;
    }

   /* public  addDevice(Client client, Long deviceId){

    }*/

    /*public UserDto findClientById(Long id) {
        Optional<Client> prosumerOptional = ClientRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Person with id {} was not found in db", id);
            //throw new ResourceNotFoundException(Person.class.getSimpleName() + " with id: " + id);
        }
        return PersonBuilder.toPersonDetailsDTO(prosumerOptional.get());
    }*/
}
