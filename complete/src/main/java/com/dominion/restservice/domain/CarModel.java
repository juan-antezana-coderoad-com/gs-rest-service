package com.dominion.restservice.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.StringUtils;

public enum CarModel {
    BLAZER("Blazer");
    private String value;

    CarModel(String value) {
        this.value = value;
    }

    /**
     * Gets the value
     *
     * @return the value
     */
    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public CarModel fromString(String value) {
        CarModel foundCardModel = null;
        for (CarModel carModel : CarModel.values()) {
            if (StringUtils.equalsIgnoreCase(carModel.getValue(), value)) {
                foundCardModel = carModel;
                break;
            }
        }

        return foundCardModel;
    }
}

