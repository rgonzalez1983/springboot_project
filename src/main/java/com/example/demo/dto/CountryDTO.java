package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryDTO {

    private String name;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
