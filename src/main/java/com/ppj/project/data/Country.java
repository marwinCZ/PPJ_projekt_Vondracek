package com.ppj.project.data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "countryCode")
    private String countryCode;

    @Column(name = "countryName")
    private String countryName;

    @OneToMany(mappedBy="country", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<City> cities;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode.trim().toUpperCase();
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}
