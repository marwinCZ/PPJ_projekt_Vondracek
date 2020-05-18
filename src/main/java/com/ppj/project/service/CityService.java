package com.ppj.project.service;

import com.ppj.project.data.City;
import com.ppj.project.data.CityMeasurement;
import com.ppj.project.data.Country;
import com.ppj.project.repositories.CityRepository;
import com.ppj.project.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cities) {
        this.cityRepository = cities;
    }

    public void create(City city) {
        cityRepository.save(city);
    }

    public List<City>  getAllCitiesByCountry(String countryCode) { return cityRepository.findByCountry(countryCode); }

    public void saveOrUpdate(City city) {
        cityRepository.save(city);
    }

    public void delete(int id) {
        cityRepository.deleteById(id);
    }
}
