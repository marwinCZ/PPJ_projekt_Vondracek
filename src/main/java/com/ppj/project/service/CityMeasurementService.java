package com.ppj.project.service;


import com.ppj.project.data.City;
import com.ppj.project.data.CityMeasurement;
import com.ppj.project.repositories.CityMeasurementRepository;
import com.ppj.project.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityMeasurementService {

    private final CityMeasurementRepository cityMeasurementRepository;

    @Autowired
    public CityMeasurementService(CityMeasurementRepository cm) { this.cityMeasurementRepository = cm; }

    public CityMeasurement getNewestCityMeasurement(int id) { return cityMeasurementRepository.findFirstByTimeDesc(id); }

    public CityMeasurement getNewestCityMeasurement(String name) {
        return cityMeasurementRepository.findFirstByTimeDesc(name);
    }

    public void saveOrUpdate(CityMeasurement cm) {
        cityMeasurementRepository.save(cm);
    }

    public void delete(int id) {
        cityMeasurementRepository.deleteById(id);
    }
}
