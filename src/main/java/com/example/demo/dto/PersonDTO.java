package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonDTO {

    private String name;
    private String lastname;
    private String ci;
    private String gender;
    private String address;
    private Long city;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @JsonProperty("ci")
    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("city")
    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }
}
