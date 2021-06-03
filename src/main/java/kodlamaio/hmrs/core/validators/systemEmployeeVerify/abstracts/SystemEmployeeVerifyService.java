package kodlamaio.hmrs.core.validators.systemEmployeeVerify.abstracts;

import kodlamaio.hmrs.entities.concretes.Employer;

public interface SystemEmployeeVerifyService {
	boolean hasVerifyBySystemEmployee(Employer employer);
}