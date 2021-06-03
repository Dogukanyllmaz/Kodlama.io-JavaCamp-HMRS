package kodlamaio.hmrs.business.abstracts;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.JobSeeker;

public interface JobSeekerService extends BaseService<JobSeeker>{
	
	DataResult<JobSeeker> getById(int id);
	boolean existsJobSeekerByNationalityId(String nationalityId);
	boolean existsJobSeekerByEmail(String email);
	
}