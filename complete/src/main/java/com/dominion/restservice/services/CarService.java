package com.dominion.restservice.services;

import com.dominion.restservice.domain.Car;
import com.dominion.restservice.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Scope(value = "session")
@Component(value = "carService")
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return this.carRepository.findAll();
    }

    public Optional<Car> getBy(Long id) {
        Car foundCar = this.carRepository.getReferenceById(id);
        return Optional.ofNullable(foundCar);
    }

    public Car save(final Car car) {
        Car savedCar = this.carRepository.save(car);
        return savedCar;
    }

    public void delete(final Car car) {
        this.carRepository.delete(car);
    }

}
