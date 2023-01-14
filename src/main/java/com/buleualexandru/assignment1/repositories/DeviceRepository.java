package com.buleualexandru.assignment1.repositories;

import com.buleualexandru.assignment1.entitys.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
