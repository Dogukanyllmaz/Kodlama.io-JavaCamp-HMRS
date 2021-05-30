package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EmailVertificationService;
import kodlamaio.hmrs.business.abstracts.EmployerService;
import kodlamaio.hmrs.business.abstracts.UserService;
import kodlamaio.hmrs.core.business.BusinessRules;
import kodlamaio.hmrs.core.business.validation.TaxNumberValidation;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.EmployerDao;
import kodlamaio.hmrs.entities.concretes.EmailVertification;
import kodlamaio.hmrs.entities.concretes.Employer;
import kodlamaio.hmrs.entities.concretes.User;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private UserService userService;
	private EmailVertificationService emailVertificationService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, UserService userService,
			EmailVertificationService emailVertificationService) {
		super();
		this.employerDao = employerDao;
		this.userService = userService;
		this.emailVertificationService = emailVertificationService;
	}
	
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Listelendi");
	}
	
	@Override
	public Result add(Employer entity) {
		var result = BusinessRules.run(
				checkInfoIsNull(entity),
				CheckIfTheEmailIsRegistered(entity),
				isRealEmail(entity),
				CheckIfTheTaxNumberIsRegistered(entity),
				NationalityIdValidation(entity)
				);
		
		if (result != null) {
			return result;
		}
		User user = this.userService.add(entity);
		this.emailVertificationService.generateCode(new EmailVertification(), user.getUserId());
		this.employerDao.save(entity);
		return new SuccessResult("Kayıt olundu. Lütfen emailinizi kontrol ediniz.");
		
				
	}
	
	@Override
	public Result delete(Employer entity) {
		this.employerDao.delete(entity);
		return new SuccessResult("Silindi");
	}
	
	@Override
	public Result update(Employer entity) {
		this.employerDao.save(entity);
		return new SuccessResult("Güncellendi");
	}
	
	@Override
	public DataResult<Optional<Employer>> getByUserId(int id) {
		return new SuccessDataResult<Optional<Employer>>(this.employerDao.findById(id),"Listelendi");
	}
	
	//********************Business Rules****************************
	
	
	//Free space control.
	private Result checkInfoIsNull(Employer employer) {
		if (employer.getEmail().isBlank() || 
				employer.getCompanyName().isBlank() || 
				employer.getPhoneNumber().isBlank() ||
				employer.getPassword().isBlank() ||
				employer.getWebSite().isBlank()) 
		{
			return new ErrorResult("Tüm alanları doldurun");
			
		}
		return new SuccessResult();
	}
	
	
	private Result CheckIfTheEmailIsRegistered(Employer employer) {
		if(employerDao.findAllByEmail(employer.getEmail()).stream().count() != 0) {
			return new ErrorResult("'" + employer.getEmail() + "'" +" adresiyle daha önce hesap açılmış");
		}
		return new SuccessResult();
	}
	
	private Result isRealEmail(Employer employer) {
		 String regex = "^(.+)@(.+)$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(employer.getEmail());
	     if(!matcher.matches()) {
	    	 return new ErrorResult("Hatalı Email adresi girdiniz");
	     }
	     return new SuccessResult();
	     }
	
	private Result CheckIfTheTaxNumberIsRegistered(Employer employer) {
		if(employerDao.findAllByTaxNumber(employer.getTaxNumber()).stream().count() != 0) {
			return new ErrorResult("'" + employer.getTaxNumber() + "'" +" kimlik numarasıyla daha önce hesap açılmış. Tekrar hesap açamazsınız.");
		}
		return new SuccessResult();
	}
	
	private Result NationalityIdValidation(Employer employer) {
		if(!TaxNumberValidation.isRealPerson(employer.getTaxNumber())) {
			return new ErrorResult("Vergi numarası doğrulanamadı");
		}
		return new SuccessResult();
	}
	
	
	
	
	
	
	
	
	
	
	
}
