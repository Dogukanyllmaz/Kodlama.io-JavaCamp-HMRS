package kodlamaio.hmrs.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.net.httpserver.Authenticator.Result;

import kodlamaio.hmrs.business.abstracts.EmailVertificationService;
import kodlamaio.hmrs.core.verifycode.GeneratedVerifyCode;
import kodlamaio.hmrs.dataAccess.abstracts.EmailVertificationDao;
import kodlamaio.hmrs.entities.concretes.EmailVertification;

@Service
public class EmailVertificationManager implements EmailVertificationService{
	
	private EmailVertificationDao emailVertificationDao;

	@Autowired
	public EmailVertificationManager(EmailVertificationDao emailVertificationDao) {
		super();
		this.emailVertificationDao = emailVertificationDao;
	}

	
	
	@Override
	public void generateCode(EmailVertification code, Integer id) {
		EmailVertification code_ = code;
		code_.setCode(null);
		code_.setVerified(false);
		if (code.isVerified() == false) {
			
			GeneratedVerifyCode generator = new GeneratedVerifyCode();
			String code_create = generator.create();
			code.setCode(code_create);
			code.setId(id);
			
			emailVertificationDao.save(code);
		}
		return ;
		
	}



	@Override
	public Result verify(String vertificationCode, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
