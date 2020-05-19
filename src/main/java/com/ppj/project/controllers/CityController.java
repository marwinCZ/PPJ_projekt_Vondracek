package com.ppj.project.controllers;

import com.ppj.project.data.City;
import com.ppj.project.data.Country;
import com.ppj.project.service.CityService;
import com.ppj.project.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CityController {
    private CityService cityService;
    private CountryService countryService;

    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @Autowired
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping(value="/{countryCode}", method= RequestMethod.GET)
    public String findUser(@PathVariable("countryCode") String countryCode, Model model) {

        List<City> cities = cityService.getAllCitiesByCountry(countryCode);
        model.addAttribute("cities", cities);

        Country country = countryService.getByCountryCode(countryCode);
        model.addAttribute("country", country);
        return "country";
    }
}