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
		City city = cityRepo.findById(id).get(); // Metodo offerto gratis da JPA
		// Altri metodi offerti gratis sono save, delete, findAll, exists ...
		return city;
	}

	@RequestMapping("/find-milano")
	public City findMilano() {
		City city = cityRepo.findByName("Milano");
		return city;
	}

	@RequestMapping("/{id}/save")
	public City saveMilano(@PathVariable("id") Long id) {
		City city = cityRepo.findById(id).get();
		if (city != null) {
			city.setName(city.getName() + "A");
		} else {
			city = new City();
			city.setCodiceNazione("ITA");
			city.setName("B");
			city.setPopulation(1000);
		}
		city = cityRepo.save(city);
		return city;
	}

	@RequestMapping("/{countryCode}/find-by-country")
	public List<City> findCitiesByCC(@PathVariable("countryCode") String countryCode) {
		List<City> cities = cityRepo.findByCodiceNazione(countryCode);
		return cities;
	}

	@RequestMapping("/find-italian")
	public List<City> findItalianCities() {
		List<City> cities = cityRepo.findItalianCities();
		return cities;
	}

}
