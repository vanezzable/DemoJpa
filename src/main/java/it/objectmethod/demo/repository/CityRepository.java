package it.objectmethod.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.demo.entity.City;

@Repository //@Component + indica che e' una repository jpa
public interface CityRepository extends JpaRepository<City, Long>{ //City e' il riferimento alla entity gestita da questa repo, Long e' il tipo dell'ID
	
	public City findByName(String name); //Fare riferimento al link di Spring JPA
	
	@Query(value="select c from City c where c.codiceNazione = 'ITA'") //Attenzione, JPA Query fa riferimento all'entity, quindi notare il 'c' e il codiceNazione 
	public List<City> findItalianCities();
	
}
