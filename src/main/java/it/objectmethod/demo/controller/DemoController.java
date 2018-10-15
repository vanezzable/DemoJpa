package it.objectmethod.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import it.objectmethod.demo.entity.City;
import it.objectmethod.demo.repository.CityRepository;

@Controller
public class DemoController {

	@Autowired
	private CityRepository cityRepo;
	
	@RequestMapping("/prima")
	public String hello(ModelMap map) {
		City prima = cityRepo.findOne(20L);
		map.addAttribute("city", prima);
		return "hello";
	}
	
}
