package com.ppj.project.repositories;

import com.ppj.project.data.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<Country, String> {

    @Override
    List<Country> findAll();
}