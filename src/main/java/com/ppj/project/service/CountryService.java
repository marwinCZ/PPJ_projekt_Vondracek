package com.ppj.project.service;

import com.ppj.project.data.City;
import com.ppj.project.data.Country;
import com.ppj.project.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countries) {
        this.countryRepository = countries;
    }

    public void create(Country country) {
        countryRepository.save(country);
    }

    public boolean exists(String countryCode) { return countryRepository.existsById(countryCode); }

    public List<Country> getAllCountries() {
        return StreamSupport.stream(countryRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public void saveOrUpdate(Country country) {
        countryRepository.save(country);
    }

    public void delete(String id) {
        countryRepository.deleteById(id);
    }

}
