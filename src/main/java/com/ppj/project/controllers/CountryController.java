package com.ppj.project.controllers;

import com.ppj.project.data.Country;
import com.ppj.project.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Controller
public class CountryController {
    private CountryService countryService;

    @Autowired
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping(value="/",method=RequestMethod.GET, params={"!add", "!delete"})
    public String showHome(Model model) {
        List<Country> countries = countryService.getAllCountries();

        model.addAttribute("countries", countries);
        model.addAttribute("country", new Country());
        return "home";
    }

    @RequestMapping(value="/",method=RequestMethod.POST, params={"add", "!delete"})
    public String addCountry(@ModelAttribute("country") Country newCountry) {
        String name = getCountryNameFromFile(newCountry.getCountryCode());
        newCountry.setCountryName(name);
        countryService.saveOrUpdate(newCountry);
        return "redirect:/ ";
    }

    @RequestMapping(value="/",method=RequestMethod.POST, params={"delete", "!add"})
    public String deleteCountry(@ModelAttribute("country") Country country) {
        countryService.delete(country.getCountryCode());
        return "redirect:/ ";
    }

    private String getCountryNameFromFile(String countryCode){
        String row;
        try{
            String resourceFile = new ClassPathResource("data/data_countries.csv").getPath();
            BufferedReader csvReader = new BufferedReader(new FileReader(resourceFile));
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                if(data[1].equals(countryCode))return data[0];
            }
            csvReader.close();

        }catch( IOException e){
            return "error";
        }
        return "not found";
    }

}
