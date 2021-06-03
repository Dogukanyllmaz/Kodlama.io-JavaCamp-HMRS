package kodlamaio.hmrs.business.abstracts;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.Employer;

public interface EmployerService extends BaseService<Employer>{

	DataResult<Employer> getById(int id);
	boolean existsEmployerByEmail(String email);
	
}
