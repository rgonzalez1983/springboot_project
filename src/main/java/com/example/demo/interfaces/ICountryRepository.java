package com.example.demo.interfaces;

import com.example.demo.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICountryRepository extends JpaRepository<CountryEntity, Long> {
}
