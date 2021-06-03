package kodlamaio.hmrs.core.validators.emailVerify.abstracts;

public abstract class EmployerEmailVerifyService implements EmailVerifyService {

	@Override 
	public boolean hasVerifyEmail(String email) { // default verify!!
		return true;
	}

}