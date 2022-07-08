package com.dominion.restservice.controllers;

import com.dominion.restservice.domain.Car;
import com.dominion.restservice.services.CarService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    /**
     * Get all cars.
     *
     * @return the list of cars
     * @throws Exception the exception
     */
    @GetMapping(path = "/cars", produces = {"application/json"})
    public List<Car> getAllCars() throws Exception {
        List<Car> cars = this.carService.getAllCars();
        return cars;
    }

    /**
     * Gets the car by ID.
     *
     * @param carId the car ID
     * @return the found car
     * @throws Exception the exception
     */
    @GetMapping(path = "/cars/{carId}", produces = {"application/json"})
    public Car getCar(@PathVariable("carId") Long carId) throws Exception {
        Optional<Car> carOptional = this.carService.getById(carId);
        if (!carOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                                              String.format("The car with id %s was not found", carId));
        }
        Car foundCar = carOptional.get();
        return foundCar;
    }

    /**
     * Saves the car.
     *
     * @param car the car to save
     * @return the saved car
     */
    @PostMapping(path = "/cars", produces = {"application/json"})
    private Car saveCar(@RequestBody Car car) {
        Car savedCar = this.carService.save(car);
        return savedCar;
    }

    /**
     * Updates the car.
     *
     * @param carId the car ID
     * @param patch the patch body
     * @return the updated car
     * @throws Exception the exception
     * @see <a href="https://www.baeldung.com/spring-rest-json-patch">Using JSON Patch in Spring REST APIs</a>
     */
    @PatchMapping(path = "/cars/{carId}", consumes = {"application/json-patch+json"}, produces = {"application/json"})
    private Car updateCar(@PathVariable("carId") Long carId, @RequestBody JsonPatch patch) throws Exception {
        Optional<Car> carOptional = this.carService.getById(carId);
        if (!carOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                                              String.format("The car with id %s was not found", carId));
        }
        Car customerPatched = applyPatchToCar(patch, carOptional.get());
        Car updatedCar = this.carService.update(customerPatched);
        return updatedCar;
    }

    @DeleteMapping(path = "/cars/{carId}")
    private void deleteCar(@PathVariable("carId") Long carId) {
        this.carService.delete(carId);
    }

    private Car applyPatchToCar(JsonPatch patch, Car targetCar) throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patched = patch.apply(objectMapper.convertValue(targetCar, JsonNode.class));
        return objectMapper.treeToValue(patched, Car.class);
    }
}
