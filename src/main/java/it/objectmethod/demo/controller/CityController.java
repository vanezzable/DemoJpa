package it.objectmethod.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.demo.entity.City;
import it.objectmethod.demo.repository.CityRepository;

@RestController
@RequestMapping("/api/city")
public class CityController {

	@Autowired
	private CityRepository cityRepo;
	
	@GetMapping("/{id}/find")
	public City findCityById(@PathVariable("id") Long id) {
		City city = cityRepo.findOne(id);
		return city;
	}
	
	@RequestMapping("/find-milano")
	public City findMilano() {
		City city = cityRepo.findByName("Milano");
		return city;
	}
	
	@RequestMapping("/find-italian")
	public List<City> findItalianCities() {
		List<City> cities = cityRepo.findItalianCities();
		return cities;
	}
	
}
