package com.example.demo.service;

import com.example.demo.dto.CountryDTO;
import com.example.demo.entity.CountryEntity;
import com.example.demo.entity.ResponseGenericEntity;
import com.example.demo.enumerators.StaticKeys;
import com.example.demo.enumerators.StaticValues;
import com.example.demo.interfaces.ICountryRepository;
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
public class CountryService {

    private final ICountryRepository countryRepository;
    private final IMapStructMapper mapStructMapper;

    public CountryService(ICountryRepository countryRepository) {
        this.countryRepository = countryRepository;
        this.mapStructMapper = new MapStructMapper();
    }

    public ResponseEntity<Map> findAll() {
        List<CountryEntity> countries = countryRepository.findAll(Sort.by(Sort.Direction.ASC, StaticKeys.KEY_NAME.toString()));
        Map map = (Map) new ResponseGenericEntity<>().convertResponse(
                StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_READ_COUNTRY_OK.toString(),
                HttpStatus.OK.value(), StaticValues.MSG_CRUD_READ.toString(), countries
        );
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    public ResponseEntity<Map> create(CountryDTO country) {
        ResponseGenericEntity rge = new ResponseGenericEntity<>();
        Map map;
        HttpStatus status;
        try {
            CountryEntity countryEntity = mapStructMapper.countryDTOToCountryEntity(country);
            countryRepository.save(countryEntity);
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_CREATE_COUNTRY_OK.toString(),
                    HttpStatus.OK.value(), StaticValues.MSG_CRUD_CREATE.toString(), countryEntity
            );
            status = HttpStatus.OK;
        } catch (Exception ex) {
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_CREATE_COUNTRY_ERROR_EXISTS.toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), StaticValues.MSG_CRUD_CREATE.toString(), null
            );
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(map, status);
    }

    public ResponseEntity<Map> update(Long idCountry, CountryDTO country) {
        ResponseGenericEntity rge = new ResponseGenericEntity<>();
        Map map;
        HttpStatus status;
        try {
            CountryEntity countryEntity = countryRepository.getById(idCountry);
            countryEntity.setName(country.getName());
            countryRepository.save(countryEntity);
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_UPDATE_COUNTRY_OK.toString(),
                    HttpStatus.OK.value(), StaticValues.MSG_CRUD_UPDATE.toString(), countryEntity
            );
            status = HttpStatus.OK;
        } catch (EntityNotFoundException ex) {
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_UPDATE_COUNTRY_ERROR_NOT_FOUND.toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), StaticValues.MSG_CRUD_UPDATE.toString(), null
            );
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } catch (Exception ex) {
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_UPDATE_COUNTRY_ERROR_EXISTS.toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), StaticValues.MSG_CRUD_UPDATE.toString(), null
            );
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(map, status);
    }

    public ResponseEntity<Map> getById(Long idCountry) {
        ResponseGenericEntity rge = new ResponseGenericEntity<>();
        Map map;
        HttpStatus status;
        try {
            CountryEntity country = countryRepository.getById(idCountry);
            country.toString();
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_GET_COUNTRY_OK.toString(),
                    HttpStatus.OK.value(), StaticValues.MSG_CRUD_GET.toString(), country
            );
            status = HttpStatus.OK;
        } catch (EntityNotFoundException ex) {
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_GET_COUNTRY_ERROR_NOT_FOUND.toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), StaticValues.MSG_CRUD_GET.toString(), null
            );
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(map, status);
    }

    public ResponseEntity<Map> deleteById(Long idCountry) {
        ResponseGenericEntity rge = new ResponseGenericEntity<>();
        Map map;
        HttpStatus status;
        try {
            countryRepository.deleteById(idCountry);
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_DELETE_COUNTRY_OK.toString(),
                    HttpStatus.OK.value(), StaticValues.MSG_CRUD_DELETE.toString(), null
            );
            status = HttpStatus.OK;
        } catch (EmptyResultDataAccessException ex) {
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_DELETE_COUNTRY_ERROR_NOT_FOUND.toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), StaticValues.MSG_CRUD_DELETE.toString(), null
            );
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } catch (Exception ex) {
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_DELETE_COUNTRY_ERROR_DEPENDENCY.toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), StaticValues.MSG_CRUD_DELETE.toString(), null
            );
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(map, status);
    }

}
