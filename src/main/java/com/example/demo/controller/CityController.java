package com.example.demo.controller;

import com.example.demo.dto.CityDTO;
import com.example.demo.entity.CityEntity;
import com.example.demo.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity findAllCities() {
        return cityService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity createCity(@Validated @RequestBody CityDTO city) {
        return cityService.create(city);
    }

    @PostMapping("/update/{idCity}")
    public ResponseEntity updateCity(@PathVariable long idCity, @Validated @RequestBody CityDTO city) {
        return cityService.update(idCity, city);
    }

    @GetMapping("/get/{idCity}")
    public ResponseEntity getCity(@PathVariable long idCity) {
        return cityService.getById(idCity);
    }

    @DeleteMapping("/delete/{idCity}")
    public ResponseEntity deleteCityById(@PathVariable long idCity) {
        return cityService.deleteById(idCity);
    }

}
