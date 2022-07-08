package com.dominion.restservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    private double engine;

    @Column(name = "features")
    private String features;

    @Column(name = "launch_date")
    private LocalDate launchDate;

    public Car(Long id, CarBrand brand, CarModel model, long maximumSpeed, double engine, String features,
               LocalDate launchDate) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.maximumSpeed = maximumSpeed;
        this.engine = engine;
        this.features = features;
        this.launchDate = launchDate;
    }

    public Car() {
        this.launchDate = LocalDate.now();
    }

    @JsonProperty(value = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty(value = "brand")
    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    @JsonProperty(value = "model")
    public CarModel getModel() {
        return model;
    }

    public void setModel(CarModel model) {
        this.model = model;
    }

    @JsonProperty(value = "maximum_speed")
    public long getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(long maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    @JsonProperty(value = "engine")
    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    @JsonProperty(value = "features")
    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    @JsonProperty(value = "launch_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }


}
