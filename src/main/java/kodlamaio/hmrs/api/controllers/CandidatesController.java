package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CandidateService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Candidate;

@RestController
@RequestMapping("api/candidates")
public class CandidatesController {

	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll() {
		
		return this.candidateService.getAll();
		
	}
	
	@PostMapping("/add")
    public Result add(@RequestBody Candidate candidate){
        return candidateService.add(candidate);
     }
	
    @PostMapping("/update")
    public Result update(@RequestBody Candidate candidate){
        return candidateService.update(candidate);
    }
    
    @PostMapping("/delete")
    public Result delete(@RequestBody int id){
        return candidateService.delete(id);
    }
	
}
