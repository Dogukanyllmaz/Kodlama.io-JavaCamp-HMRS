package kodlamaio.hmrs.business.abstracts;

import java.util.Optional;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.Employee;

public interface EmployeeService extends BaseService<Employee>{
	
	DataResult<Optional<Employee>> getByUserId(int id);
	
}
