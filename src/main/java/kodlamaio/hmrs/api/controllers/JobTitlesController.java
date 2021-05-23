package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.JobTitleService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobTitle;

@RestController
@RequestMapping("api/jobTitles")
public class JobTitlesController {

	private JobTitleService jobTitleService;
	
	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobTitle>> getAll() {
		return jobTitleService.getAll();
	}
	
	@PostMapping("/add") 
	public Result add(@RequestBody JobTitle jobTitle) {
		return this.jobTitleService.add(jobTitle);
	}
	
	@PostMapping("/update")
    public Result update(@RequestBody JobTitle jobTitle){
        return jobTitleService.update(jobTitle);
    }
	
    @PostMapping("/delete")
    public Result delete(@RequestBody int id){
        return jobTitleService.delete(id);
    }
}
