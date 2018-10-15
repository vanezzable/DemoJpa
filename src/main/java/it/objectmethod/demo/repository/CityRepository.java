package it.objectmethod.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.demo.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{
	
	public City findByName(String name);
	
}
