package com.ppj.project.data;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City {

    @Id
    private int cityId;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "countryCode")
    private Country country;

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
