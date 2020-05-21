package com.ppj.project.controllers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ppj.project.data.Country;
import com.ppj.project.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;
import java.util.Iterator;
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
    public String addCountry(@ModelAttribute("country") Country country) {
        String name = getCountryNameFromJson(country.getCountryCode());
        if(name != "error") return "redirect:/ ";
        country.setCountryName(name);
        countryService.saveOrUpdate(country);
        return "redirect:/ ";
    }

    @RequestMapping(value="/",method=RequestMethod.POST, params={"delete", "!add"})
    public String deleteCountry(@ModelAttribute("country") Country country) {
        countryService.delete(country.getCountryCode());
        return "redirect:/ ";
    }

    private String getCountryNameFromJson(String countryCode){
        InputStream resource = null;
        String line,input="";
        try {
            resource = new ClassPathResource("countryNamesAndCodes.json").getInputStream();
            try ( BufferedReader reader = new BufferedReader(new InputStreamReader(resource)) ) {
                while ((line = reader.readLine()) != null)input+=line;
                JsonObject jsonObject = new JsonParser().parse(input).getAsJsonObject();
                if(jsonObject.has(countryCode)) return jsonObject.get(countryCode).toString();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

}
