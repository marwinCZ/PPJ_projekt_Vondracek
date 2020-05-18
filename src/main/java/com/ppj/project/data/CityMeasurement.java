package com.ppj.project.data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "citymeasurements")
public class CityMeasurement {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "time")
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;

    @Column(name = "main")
    private String main;

    @Column(name = "description")
    private String description;

    @Column(name = "temperature")
    private float temperature;

    @Column(name = "windSpeed")
    private float windSpeed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public com.ppj.project.data.City getCity() {
        return city;
    }

    public void setCity(com.ppj.project.data.City city) {
        this.city = city;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }
}
