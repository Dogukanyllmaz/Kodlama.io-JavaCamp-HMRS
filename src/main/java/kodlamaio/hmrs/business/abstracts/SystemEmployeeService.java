package kodlamaio.hmrs.business.abstracts;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.SystemEmployee;

public interface SystemEmployeeService extends BaseService<SystemEmployee>{
	
	DataResult<SystemEmployee> getById(int id);
	Result existsSystemEmployeeByNationalityId(String nationalityId);
	Result existsSystemEmployeeByEmail(String email);
	
}
