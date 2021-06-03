package kodlamaio.hmrs.core.validators.systemEmployeeVerify.abstracts;

import kodlamaio.hmrs.entities.concretes.Employer;

public abstract class EmployerSystemEmployeeVerifyService implements SystemEmployeeVerifyService {

	@Override 
	public boolean hasVerifyBySystemEmployee(Employer employer) { // default verify!!
		return true;
	}

}