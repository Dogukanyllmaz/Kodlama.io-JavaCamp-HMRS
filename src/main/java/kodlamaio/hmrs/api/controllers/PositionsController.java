package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.PositionService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Position;

@RestController
@RequestMapping("/api/positions/")
public class PositionsController {

	private PositionService positionService;

	@Autowired
	public PositionsController(PositionService positionService) {
		super();
		this.positionService = positionService;
	}
	
	@GetMapping("getall")
	public DataResult<List<Position>> getAll(){
		return this.positionService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@RequestBody Position position) {
		return this.positionService.add(position);
	}
	@GetMapping("{id}")
	public Result getById(@PathVariable int id){
		return this.positionService.getById(id);
	}
	
}
