package com.ppj.project.data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue
    private int cityId;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "countryCode")
    private Country country;

    @OneToMany(mappedBy="city", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CityMeasurement> measurements;

    public City(){
        this.country = new Country();
    }

    public City(int id, String name){
        cityId = id;
        this.name = name;
    }

    public String GetName() {
        return name;
    }

    public void SetName(String name) { this.name = name; }

    public int GetCityId() {
        return cityId;
    }

    public void SetCityId(int cityId) {
        this.cityId = cityId;
    }

    public Country GetCountry(){return this.country;}

    public void SetCountry(Country country) { this.country = country; }
}
