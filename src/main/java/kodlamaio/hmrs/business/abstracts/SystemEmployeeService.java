package kodlamaio.hmrs.business.abstracts;

import java.util.Optional;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.SystemEmployee;

public interface SystemEmployeeService extends BaseService<SystemEmployee>{
	
	DataResult<Optional<SystemEmployee>> getByUserId(int userId);
	
}
