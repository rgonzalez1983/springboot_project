package com.example.demo.controller;

import com.example.demo.dto.CountryDTO;
import com.example.demo.entity.CountryEntity;
import com.example.demo.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity findAllCountries() {
        return countryService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity createCountry(@Validated @RequestBody CountryDTO country) {
        return countryService.create(country);
    }

    @PostMapping("/update/{idCountry}")
    public ResponseEntity updateCountry(@PathVariable long idCountry, @Validated @RequestBody CountryDTO country) {
        return countryService.update(idCountry, country);
    }

    @GetMapping("/get/{idCountry}")
    public ResponseEntity getCountry(@PathVariable long idCountry) {
        return countryService.getById(idCountry);
    }

    @DeleteMapping("/delete/{idCountry}")
    public ResponseEntity deleteCountryById(@PathVariable long idCountry) {
        return  countryService.deleteById(idCountry);
    }

}
