package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.WorkExperience;

public interface WorkExperienceService extends BaseService<WorkExperience> {

	DataResult<WorkExperience> getById(int id);
	DataResult<List<WorkExperience>> getAllOrderByEndDateDesc();
	DataResult<List<WorkExperience>> getByEndDateIsNull();
	DataResult<List<WorkExperience>> getByEndDateIsNotNullOrderByEndDateDesc();
	
}
