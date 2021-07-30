package com.example.demo.service;

import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.PersonEntity;
import com.example.demo.entity.ResponseGenericEntity;
import com.example.demo.enumerators.StaticKeys;
import com.example.demo.enumerators.StaticValues;
import com.example.demo.interfaces.IPersonRepository;
import com.example.demo.mapper.classes.MapStructMapper;
import com.example.demo.mapper.interfaces.IMapStructMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {

    private final IPersonRepository personRepository;
    private final IMapStructMapper mapStructMapper;

    public PersonService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
        this.mapStructMapper = new MapStructMapper();
    }

    public ResponseEntity<Map> findAll() {
        List<PersonEntity> persons = personRepository.findAll(Sort.by(Sort.Direction.ASC, StaticKeys.KEY_LASTNAME.toString()));
        Map map = (Map) new ResponseGenericEntity<>().convertResponse(
                StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_READ_PERSON_OK.toString(),
                HttpStatus.OK.value(), StaticValues.MSG_CRUD_READ.toString(), persons
        );
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    public ResponseEntity<Map> create(PersonDTO person) {
        ResponseGenericEntity rge = new ResponseGenericEntity<>();
        Map map;
        HttpStatus status;
        try {
            PersonEntity personEntity = mapStructMapper.personDTOToPersonEntity(person);
            personRepository.save(personEntity);
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_CREATE_PERSON_OK.toString(),
                    HttpStatus.OK.value(), StaticValues.MSG_CRUD_CREATE.toString(), personEntity
            );
            status = HttpStatus.OK;
        } catch (Exception ex) {
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_CREATE_PERSON_ERROR_EXISTS.toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), StaticValues.MSG_CRUD_CREATE.toString(), null
            );
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(map, status);
    }

    public ResponseEntity<Map> update(Long idPerson, PersonDTO person) {
        ResponseGenericEntity rge = new ResponseGenericEntity<>();
        Map map;
        HttpStatus status;
        try {
            PersonEntity personEntity = personRepository.getById(idPerson);
            personEntity.setName(person.getName());
            personEntity.setLastname(person.getLastname());
            personEntity.setCi(person.getCi());
            personEntity.setAddress(person.getAddress());
            personEntity.setGender(person.getGender());
            personEntity.setCity(person.getCity());
            personRepository.save(personEntity);
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_UPDATE_PERSON_OK.toString(),
                    HttpStatus.OK.value(), StaticValues.MSG_CRUD_UPDATE.toString(), personEntity
            );
            status = HttpStatus.OK;
        } catch (EntityNotFoundException ex) {
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_UPDATE_PERSON_ERROR_NOT_FOUND.toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), StaticValues.MSG_CRUD_UPDATE.toString(), null
            );
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } catch (Exception ex) {
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_UPDATE_PERSON_ERROR_EXISTS.toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), StaticValues.MSG_CRUD_UPDATE.toString(), null
            );
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(map, status);
    }

    public ResponseEntity<Map> getById(Long idPerson) {
        ResponseGenericEntity rge = new ResponseGenericEntity<>();
        Map map;
        HttpStatus status;
        try {
            PersonEntity person = personRepository.getById(idPerson);
            person.toString();
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_GET_PERSON_OK.toString(),
                    HttpStatus.OK.value(), StaticValues.MSG_CRUD_GET.toString(), person
            );
            status = HttpStatus.OK;
        } catch (EntityNotFoundException ex) {
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_GET_PERSON_ERROR_NOT_FOUND.toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), StaticValues.MSG_CRUD_GET.toString(), null
            );
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(map, status);
    }

    public ResponseEntity<Map> deleteById(Long idPerson) {
        ResponseGenericEntity rge = new ResponseGenericEntity<>();
        Map map;
        HttpStatus status;
        try {
            personRepository.deleteById(idPerson);
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_DELETE_PERSON_OK.toString(),
                    HttpStatus.OK.value(), StaticValues.MSG_CRUD_DELETE.toString(), null
            );
            status = HttpStatus.OK;
        } catch (EmptyResultDataAccessException ex) {
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_DELETE_PERSON_ERROR_NOT_FOUND.toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), StaticValues.MSG_CRUD_DELETE.toString(), null
            );
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } catch (Exception ex) {
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_DELETE_PERSON_ERROR_DEPENDENCY.toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), StaticValues.MSG_CRUD_DELETE.toString(), null
            );
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(map, status);
    }

}
