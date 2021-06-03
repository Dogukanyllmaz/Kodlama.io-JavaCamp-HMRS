package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.School;

public interface SchoolService extends BaseService<School>{
	
	DataResult<School> getById(int id);
	
	DataResult<List<School>> getAllOrderByEndDateDesc();
	DataResult<List<School>> getByEndDateIsNull();
	DataResult<List<School>> getByEndDateIsNotNullOrderByEndDateDesc();
}