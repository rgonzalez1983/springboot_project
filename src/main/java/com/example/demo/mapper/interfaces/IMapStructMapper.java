package com.example.demo.mapper.interfaces;

import com.example.demo.dto.CityDTO;
import com.example.demo.dto.CountryDTO;
import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.CityEntity;
import com.example.demo.entity.CountryEntity;
import com.example.demo.entity.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IMapStructMapper {

    public CountryEntity countryDTOToCountryEntity(CountryDTO countryDTO);

    public CityEntity cityDTOToCityEntity(CityDTO cityDTO);

    public PersonEntity personDTOToPersonEntity(PersonDTO personDTO);

}
