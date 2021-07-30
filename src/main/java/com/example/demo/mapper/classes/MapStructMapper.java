package com.example.demo.mapper.classes;

import com.example.demo.dto.CityDTO;
import com.example.demo.dto.CountryDTO;
import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.CityEntity;
import com.example.demo.entity.CountryEntity;
import com.example.demo.entity.PersonEntity;
import com.example.demo.mapper.interfaces.IMapStructMapper;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class MapStructMapper implements IMapStructMapper {
    @Override
    public CountryEntity countryDTOToCountryEntity(CountryDTO countryDTO) {
        if ( countryDTO == null ) {
            return null;
        }
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setName(countryDTO.getName());
        return countryEntity;
    }

    @Override
    public CityEntity cityDTOToCityEntity(CityDTO cityDTO) {
        if ( cityDTO == null ) {
            return null;
        }
        CityEntity cityEntity = new CityEntity();
        cityEntity.setName(cityDTO.getName());
        cityEntity.setCountry(cityDTO.getCountry());
        return cityEntity;
    }

    @Override
    public PersonEntity personDTOToPersonEntity(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }
        PersonEntity personEntity = new PersonEntity();
        personEntity.setCity(personDTO.getCity());
        personEntity.setCi(personDTO.getCi());
        personEntity.setAddress(personDTO.getAddress());
        personEntity.setGender(personDTO.getGender());
        personEntity.setLastname(personDTO.getLastname());
        personEntity.setName(personDTO.getName());
        return personEntity;
    }
}
