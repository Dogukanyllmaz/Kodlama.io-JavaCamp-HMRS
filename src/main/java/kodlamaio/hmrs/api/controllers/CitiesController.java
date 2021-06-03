package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CityService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.City;

@RestController
@RequestMapping("/api/cities/")
public class CitiesController {

	private CityService cityService;
	
	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}


	@GetMapping("getAll-cities")
	public DataResult<List<City>> getAll() {
		return this.cityService.getAll();
	}
	
	@PostMapping("get-by-city-name")
	public DataResult<City> getByCityName(@RequestParam String cityName) {
		return this.cityService.getByCityName(cityName);
	}
	
	
}
