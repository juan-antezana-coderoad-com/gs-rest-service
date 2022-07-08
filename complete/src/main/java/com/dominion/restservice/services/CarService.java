package com.dominion.restservice.services;

import com.dominion.restservice.domain.Car;
import com.dominion.restservice.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return this.carRepository.findAll();
    }

    public Optional<Car> getById(final Long id) {
        Car foundCar;
        try {
            foundCar = this.carRepository.getReferenceById(id);
        } catch (EntityNotFoundException entityNotFoundException) {
            entityNotFoundException.printStackTrace();
            foundCar = null;
        }

        return Optional.ofNullable(foundCar);
    }

    public Car save(final Car car) {
        Car savedCar = this.carRepository.saveAndFlush(car);
        return savedCar;
    }

    public Car update(final Car car) {
        Optional<Car> optionalCar = this.getById(car.getId());
        if (!optionalCar.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                                              String.format("The car with id %s was not found", car.getId()));
        }
        Car updatedCar = this.carRepository.saveAndFlush(car);

        return updatedCar;
    }

    public void delete(final Long carId) {
        Optional<Car> optionalCar = this.getById(carId);
        if (!optionalCar.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                                              String.format("The car with id %s was not found", carId));
        }
        Car car = optionalCar.get();
        this.carRepository.delete(car);
    }
}
