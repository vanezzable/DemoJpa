package it.objectmethod.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.demo.entity.City;
import it.objectmethod.demo.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepo;

	public City findCityById(Long id) {
		City city = null;
		Optional<City> optCity = cityRepo.findById(id);
		if (optCity.isPresent()) {
			city = optCity.get();
		}
		return city;
	}

	public City findByName(String name) {
		City city = cityRepo.findByName(name);
		return city;
	}

	public List<City> findByCodiceNazione(String codice) {
		List<City> cityList = cityRepo.findByCodiceNazione(codice);
		return cityList;
	}

	public List<City> findCitiesByCodiceNazione(String codNaz) {
		List<City> cityList = cityRepo.findCitiesByCodiceNazione(codNaz);
		return cityList;
	}

	public List<City> findCitiesByCodiceNazioneNative(String codNaz) {
		List<City> cityList = cityRepo.findCitiesByCodiceNazioneNative(codNaz);
		return cityList;
	}

	public List<City> findCitiesByPopulation(Integer minPop, Integer maxPop) {
		List<City> cityList = cityRepo.findCitiesByPopulation(minPop, maxPop);
		return cityList;
	}

}
