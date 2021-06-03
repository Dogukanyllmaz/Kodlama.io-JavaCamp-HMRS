package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import kodlamaio.hmrs.business.abstracts.JobAdvertService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobadverts/")
public class JobAdvertsController {
	
	private JobAdvertService jobAdvertService;

	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@GetMapping("getall")
	public DataResult<List<JobAdvert>> getAll(){
		return this.jobAdvertService.getAll();
	}
	
	@GetMapping("getByActivityStatusIsTrue")
	public DataResult<List<JobAdvert>> getByActivityStatusIsTrue(){
		return this.jobAdvertService.getByActivityStatusIsTrue();
	}
	
	@GetMapping("getByActivityStatusIsTrueOrderByAdvertDateAsc")
	public DataResult<List<JobAdvert>> getByActivityStatusIsTrueOrderByAdvertDateAsc(){
		return this.jobAdvertService.getByActivityStatusIsTrueOrderByAdvertDateAsc();
	}
	
	@GetMapping("getByActivityStatusIsTrueOrderByAdvertDateDesc")
	public DataResult<List<JobAdvert>> getByActivityStatusIsTrueOrderByAdvertDateDesc(){
		return this.jobAdvertService.getByActivityStatusIsTrueOrderByAdvertDateDesc();
	}
	
	@GetMapping("getByEmployerId")
	public DataResult<List<JobAdvert>> getByEmployerId(int userId){
		return this.jobAdvertService.getByEmployer_UserId(userId);
	}

/*
	@GetMapping("getByPositionId")
	public DataResult<List<JobAdvert>> getByPosition_Id(int positionId) {
		return this.jobAdvertService.getByPosition_PositionId(positionId);
	}


	@GetMapping("getByPositionName")
		public DataResult<JobAdvert> getByPositionName(@RequestParam String positionName) {
			return this.jobAdvertService.getByPositionName(positionName);
	}

	@GetMapping("getByCityName")
	public DataResult<JobAdvert> getByCityName(@RequestParam String cityName) {
		return this.jobAdvertService.getByCityName(cityName);
	}
	*/

	@PostMapping("add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}
	
	@PostMapping("closeAdvert")
	public Result closeAdvert(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.closeAdvert(jobAdvert);
	}
}