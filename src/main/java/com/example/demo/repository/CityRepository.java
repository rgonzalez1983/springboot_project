package com.example.demo.repository;

import com.example.demo.entity.CityEntity;
import com.example.demo.interfaces.ICityRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class CityRepository implements ICityRepository {
    @Override
    public List<CityEntity> findAll() {
        return null;
    }

    @Override
    public List<CityEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<CityEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<CityEntity> findAllById(Iterable<Long> iterable) {
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
    public void delete(CityEntity cityEntity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends CityEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends CityEntity> S save(S s) {
        return null;
    }

    @Override
    public <S extends CityEntity> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<CityEntity> findById(Long aLong) {
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
    public <S extends CityEntity> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends CityEntity> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<CityEntity> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public CityEntity getOne(Long aLong) {
        return null;
    }

    @Override
    public CityEntity getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends CityEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends CityEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends CityEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends CityEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends CityEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends CityEntity> boolean exists(Example<S> example) {
        return false;
    }
}
