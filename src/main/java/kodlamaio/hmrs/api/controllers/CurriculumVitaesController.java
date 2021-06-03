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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CurriculumVitaeService;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.entities.concretes.CurriculumVitae;

@RestController
@RequestMapping("/api/curriculumvitaes/")
public class CurriculumVitaesController {
	
	private CurriculumVitaeService curriculumVitaeService;
	
	@Autowired
	public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
		this.curriculumVitaeService = curriculumVitaeService;
	}
	
	@GetMapping("getall-curriculum-vitaes")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.curriculumVitaeService.getAll());
	}
	
	@PostMapping("add-curriculum-vitaes")
	public ResponseEntity<?> add(@Valid @RequestBody CurriculumVitae curriculumVitae) {
		return ResponseEntity.ok(this.curriculumVitaeService.add(curriculumVitae));
	}
	
	@PostMapping("uploadphoto")
	public ResponseEntity<?> uploadPhoto(@RequestParam(name = "id") Integer id,
			@RequestParam(name = "filePath") String filePath) {
		return ResponseEntity.ok(this.curriculumVitaeService.uploadPhoto(id, filePath));
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