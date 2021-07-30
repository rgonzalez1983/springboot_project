package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CityDTO {

    private String name;
    private Long country;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("country")
    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }
}
