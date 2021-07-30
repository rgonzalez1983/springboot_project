package com.example.demo.interfaces;

import com.example.demo.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<CityEntity, Long> {
}
