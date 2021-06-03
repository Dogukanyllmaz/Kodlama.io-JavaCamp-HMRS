package kodlamaio.hmrs.core.validators.emailVerify.abstracts;

public abstract class JobSeekerEmailVerifyService implements EmailVerifyService {

	@Override 
	public boolean hasVerifyEmail(String email) { // default verify!!
		return true;
	}

}