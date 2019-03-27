package it.objectmethod.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.demo.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{
	
	public City findByName(String name);
	
	@Query(value="select c from City c where c.codiceNazione = 'ITA'")
	public List<City> findItalianCities();
	
}
