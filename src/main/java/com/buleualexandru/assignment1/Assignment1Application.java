package com.buleualexandru.assignment1;

import com.buleualexandru.assignment1.entitys.SensorMesurment;
import com.buleualexandru.assignment1.repositories.DeviceRepository;
import com.buleualexandru.assignment1.repositories.SensorMesurmentRepository;
import com.buleualexandru.assignment1.services.SensorMesurmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.buleualexandru.assignment1.services.ConsumerMq;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@SpringBootApplication
public class Assignment1Application {
	@Autowired
	private  DeviceRepository deviceRepository;
	@Autowired


	public static void main(String[] args) throws Exception {

		SpringApplication.run(Assignment1Application.class, args);

	}



}
