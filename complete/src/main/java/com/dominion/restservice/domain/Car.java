package com.dominion.restservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "brand")
    private CarBrand brand;

    @Column(name = "model")
    private CarModel model;

    @Column(name = "maximum_speed")
    private long maximumSpeed;

    @Column(name = "engine")
    private long engine;

    @Column(name = "features")
    private String features;

    @Column(name = "launch_date")
    private LocalDate launchDate;


    public Car() {
        this.brand = CarBrand.CHEVROLET;
        this.model = CarModel.BLAZER;
        this.features = "";
        this.launchDate = LocalDate.now();
    }

    public Car(Long id, CarBrand brand, CarModel model, long maximumSpeed, long engine, String features,
               LocalDate launchDate) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.maximumSpeed = maximumSpeed;
        this.engine = engine;
        this.features = features;
        this.launchDate = launchDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    public CarModel getModel() {
        return model;
    }

    public void setModel(CarModel model) {
        this.model = model;
    }

    public long getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(long maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public long getEngine() {
        return engine;
    }

    public void setEngine(long engine) {
        this.engine = engine;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }


}
