package com.dominion.restservice.controllers;

import com.dominion.restservice.domain.Car;
import com.dominion.restservice.domain.Greeting;
import com.dominion.restservice.repositories.CarRepository;
import com.dominion.restservice.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars() throws Exception {
        List<Car> cars = this.carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }
}
