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
public class CountryController {
    private CountryService countryService;

    @Autowired
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping("/")
    public String showHome(Model model) {
        List<Country> countries = countryService.getAllCountries();

        model.addAttribute("countries", countries);
        return "home";
    }

}
