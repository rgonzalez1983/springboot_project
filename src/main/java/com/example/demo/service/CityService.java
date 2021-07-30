package com.example.demo.service;

import com.example.demo.dto.CityDTO;
import com.example.demo.entity.CityEntity;
import com.example.demo.entity.ResponseGenericEntity;
import com.example.demo.enumerators.StaticKeys;
import com.example.demo.enumerators.StaticValues;
import com.example.demo.interfaces.ICityRepository;
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
public class CityService {

    private final ICityRepository cityRepository;
    private final IMapStructMapper mapStructMapper;

    public CityService(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
        this.mapStructMapper = new MapStructMapper();
    }

    public ResponseEntity<Map> findAll() {
        List<CityEntity> cities = cityRepository.findAll(Sort.by(Sort.Direction.ASC, StaticKeys.KEY_NAME.toString()));
        Map map = (Map) new ResponseGenericEntity<>().convertResponse(
                StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_READ_CITY_OK.toString(),
                HttpStatus.OK.value(), StaticValues.MSG_CRUD_READ.toString(), cities
        );
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    public ResponseEntity<Map> create(CityDTO city) {
        ResponseGenericEntity rge = new ResponseGenericEntity<>();
        Map map;
        HttpStatus status;
        try {
            CityEntity cityEntity = mapStructMapper.cityDTOToCityEntity(city);
            cityRepository.save(cityEntity);
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_CREATE_CITY_OK.toString(),
                    HttpStatus.OK.value(), StaticValues.MSG_CRUD_CREATE.toString(), cityEntity
            );
            status = HttpStatus.OK;
        } catch (Exception ex) {
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_CREATE_CITY_ERROR_EXISTS.toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), StaticValues.MSG_CRUD_CREATE.toString(), null
            );
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(map, status);
    }

    public ResponseEntity<Map> update(Long idCity, CityDTO city) {
        ResponseGenericEntity rge = new ResponseGenericEntity<>();
        Map map;
        HttpStatus status;
        try {
            CityEntity cityEntity = cityRepository.getById(idCity);
            cityEntity.setName(city.getName());
            cityEntity.setCountry(city.getCountry());
            cityRepository.save(cityEntity);
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_UPDATE_CITY_OK.toString(),
                    HttpStatus.OK.value(), StaticValues.MSG_CRUD_UPDATE.toString(), cityEntity
            );
            status = HttpStatus.OK;
        } catch (EntityNotFoundException ex) {
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_UPDATE_CITY_ERROR_NOT_FOUND.toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), StaticValues.MSG_CRUD_UPDATE.toString(), null
            );
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } catch (Exception ex) {
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_UPDATE_CITY_ERROR_EXISTS.toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), StaticValues.MSG_CRUD_UPDATE.toString(), null
            );
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(map, status);
    }

    public ResponseEntity<Map> getById(Long idCity) {
        ResponseGenericEntity rge = new ResponseGenericEntity<>();
        Map map;
        HttpStatus status;
        try {
            CityEntity city = cityRepository.getById(idCity);
            city.toString();
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_GET_CITY_OK.toString(),
                    HttpStatus.OK.value(), StaticValues.MSG_CRUD_GET.toString(), city
            );
            status = HttpStatus.OK;
        } catch (EntityNotFoundException ex) {
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_GET_CITY_ERROR_NOT_FOUND.toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), StaticValues.MSG_CRUD_GET.toString(), null
            );
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(map, status);
    }

    public ResponseEntity<Map> deleteById(Long idCity) {
        ResponseGenericEntity<Object> rge = new ResponseGenericEntity<>();
        Map map;
        HttpStatus status;
        try {
            cityRepository.deleteById(idCity);
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_DELETE_CITY_OK.toString(),
                    HttpStatus.OK.value(), StaticValues.MSG_CRUD_DELETE.toString(), null
            );
            status = HttpStatus.OK;
        } catch (EmptyResultDataAccessException ex) {
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_DELETE_CITY_ERROR_NOT_FOUND.toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), StaticValues.MSG_CRUD_DELETE.toString(), null
            );
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } catch (Exception ex) {
            map = (Map) rge.convertResponse(
                    StaticValues.JSON_TYPE_MAP.toString(), StaticValues.MSG_DELETE_CITY_ERROR_DEPENDENCY.toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), StaticValues.MSG_CRUD_DELETE.toString(), null
            );
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(map, status);
    }

}
