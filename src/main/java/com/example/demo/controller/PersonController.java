package com.example.demo.controller;

import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.PersonEntity;
import com.example.demo.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity findAllPersons() {
        return personService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity createPerson(@Validated @RequestBody PersonDTO person) {
        return personService.create(person);
    }

    @PostMapping("/update/{idPerson}")
    public ResponseEntity updatePerson(@PathVariable long idPerson, @Validated @RequestBody PersonDTO person) {
        return personService.update(idPerson, person);
    }

    @GetMapping("/get/{idPerson}")
    public ResponseEntity getPerson(@PathVariable long idPerson) {
        return personService.getById(idPerson);
    }

    @DeleteMapping("/delete/{idPerson}")
    public ResponseEntity deletePersonById(@PathVariable long idPerson) {
        return  personService.deleteById(idPerson);
    }
    
}
