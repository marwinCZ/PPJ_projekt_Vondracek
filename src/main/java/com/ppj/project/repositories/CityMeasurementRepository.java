package com.ppj.project.repositories;

import com.ppj.project.data.City;
import com.ppj.project.data.CityMeasurement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityMeasurementRepository extends CrudRepository<CityMeasurement, Integer> {

    @Query("select c from CityMeasurement as c where city.cityId=:cityId")
    CityMeasurement findFirstByTimeDesc(@Param("cityId")int cityId);

    @Query("select c from CityMeasurement as c where city.name=:name")
    CityMeasurement findFirstByTimeDesc(@Param("name")String name);

    @Query("select c from CityMeasurement as c where city.cityId=:cityId")
    List<CityMeasurement> findByCity(@Param("cityId")int cityId);
}
