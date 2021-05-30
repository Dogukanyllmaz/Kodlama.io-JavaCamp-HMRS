package kodlamaio.hmrs.business.abstracts;

import java.util.Optional;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.Employer;

public interface EmployerService extends BaseService<Employer>{

	DataResult<Optional<Employer>> getByUserId(int id);
	
}
