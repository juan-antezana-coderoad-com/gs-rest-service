package com.dominion.restservice.repositories;

import com.dominion.restservice.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
