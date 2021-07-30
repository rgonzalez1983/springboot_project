package com.example.demo.repository;

import com.example.demo.entity.CountryEntity;
import com.example.demo.interfaces.ICountryRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class CountryRepository implements ICountryRepository {
    @Override
    public List<CountryEntity> findAll() {
        return null;
    }

    @Override
    public List<CountryEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<CountryEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<CountryEntity> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(CountryEntity countryEntity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends CountryEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends CountryEntity> S save(S s) {
        return null;
    }

    @Override
    public <S extends CountryEntity> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<CountryEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends CountryEntity> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends CountryEntity> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<CountryEntity> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public CountryEntity getOne(Long aLong) {
        return null;
    }

    @Override
    public CountryEntity getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends CountryEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends CountryEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends CountryEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends CountryEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends CountryEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends CountryEntity> boolean exists(Example<S> example) {
        return false;
    }
}
