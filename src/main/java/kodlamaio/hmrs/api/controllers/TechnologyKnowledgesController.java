package kodlamaio.hmrs.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.TechnologyKnowledgeService;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.entities.concretes.TechnologyKnowledge;

@RestController
@RequestMapping("/api/technologyknowledges/")
public class TechnologyKnowledgesController {
	
	private TechnologyKnowledgeService  technologyKnowledgeService;
	
	@Autowired
	public TechnologyKnowledgesController(TechnologyKnowledgeService  technologyKnowledgeService) {
		this.technologyKnowledgeService = technologyKnowledgeService;
	}
	
	@GetMapping("getall-technology-knowledges")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.technologyKnowledgeService.getAll());
	}
	
	@PostMapping("add-technology-knowledge")
	public ResponseEntity<?> add(@Valid @RequestBody TechnologyKnowledge technologyKnowledge) {
		return ResponseEntity.ok(this.technologyKnowledgeService.add(technologyKnowledge));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError: exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return new ErrorDataResult<Object>(validationErrors,"Validation Errors");
	}
	
}