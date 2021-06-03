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

import kodlamaio.hmrs.business.abstracts.WorkExperienceService;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.entities.concretes.WorkExperience;

@RestController
@RequestMapping("/api/workexperiences/")
public class WorkExperiencesController {
	
	private WorkExperienceService workExperienceService;
	
	@Autowired
	public WorkExperiencesController(WorkExperienceService workExperienceService) {
		this.workExperienceService = workExperienceService;
	}
	
	@GetMapping("getall-work-experiences")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.workExperienceService.getAll());
	}
	
	@GetMapping("getallorderbyenddatedesc")
	public ResponseEntity<?> getAllOrderByEndDateDesc() {
		return ResponseEntity.ok(this.workExperienceService.getAllOrderByEndDateDesc());
	}
	
	@GetMapping("getbyenddateisnull")
	public ResponseEntity<?> getByEndDateIsNull() {
		return ResponseEntity.ok(this.workExperienceService.getByEndDateIsNull());
	}
	
	@GetMapping("getbyenddateisnotnullorderbyenddatedesc")
	public ResponseEntity<?> getByEndDateIsNotNullOrderByEndDateDesc() {
		return ResponseEntity.ok(this.workExperienceService.getByEndDateIsNotNullOrderByEndDateDesc());
	}
	
	@PostMapping("add-work-experience")
	public ResponseEntity<?> add(@Valid @RequestBody WorkExperience workExperience) {
		return ResponseEntity.ok(this.workExperienceService.add(workExperience));
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