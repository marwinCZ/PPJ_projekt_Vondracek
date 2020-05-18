package com.ppj.project.repositories;

import com.ppj.project.data.City;
import com.ppj.project.data.CityMeasurement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {

    @Query("select c from City as c where country.countryCode=:countryCode")
    public List<City> findByCountry(@Param("countryCode")String countryCode);

}