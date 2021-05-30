package kodlamaio.hmrs.business.abstracts;

import com.sun.net.httpserver.Authenticator.Result;

import kodlamaio.hmrs.entities.concretes.EmailVertification;

public interface EmailVertificationService {

	void generateCode(EmailVertification code, Integer id);
	Result verify(String vertificationCode, Integer id);
	
}
