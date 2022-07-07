package com.dominion.restservice.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.StringUtils;

public enum CarBrand {
    CHEVROLET("Chevrolet");
    private String value;

    CarBrand(String value) {
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
    public CarBrand fromString(String value) {
        CarBrand foundCardBrand = null;
        for (CarBrand carBrand : CarBrand.values()) {
            if (StringUtils.equalsIgnoreCase(carBrand.getValue(), value)) {
                foundCardBrand = carBrand;
                break;
            }
        }

        return foundCardBrand;
    }
}
