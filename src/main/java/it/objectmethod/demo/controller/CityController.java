package it.objectmethod.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.demo.entity.City;
import it.objectmethod.demo.service.CityService;

@RestController
@RequestMapping("/api/city")
public class CityController {

	@Autowired
	private CityService cityService;

	@GetMapping("/{id}/find")
	public City findCityById(@PathVariable("id") Long id) {
		City city = cityService.findCityById(id);
		return city;
	}

	@RequestMapping("/find-milano")
	public City findMilano() {
		City city = cityService.findByName("Milano");
		return city;
	}

	@RequestMapping("/{countryCode}/find-by-country")
	public List<City> findCitiesByCC(@PathVariable("countryCode") String countryCode) {
		List<City> cities = cityService.findByCodiceNazione(countryCode);
		return cities;
	}

	@RequestMapping("/{countryCode}/find-by-country-native")
	public List<City> findCitiesByCCNative(@PathVariable("countryCode") String countryCode) {
		List<City> cities = cityService.findCitiesByCodiceNazioneNative(countryCode);
		return cities;
	}

//
//	@RequestMapping("/{id}/save")
//	public City saveMilano(@PathVariable("id") Long id) {
//		City city = null;
//		if (id > 0) {
//			city = cityRepo.findById(id).get();
//			city.setName(city.getName() + "A");
//		} else {
//			city = new City();
//			city.setCodiceNazione("ITA");
//			city.setName("B");
//			city.setPopulation(1000);
//		}
//		city = cityRepo.save(city);
//		return city;
//	}

}
