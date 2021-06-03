package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EmployerService;
<<<<<<< HEAD
=======
import kodlamaio.hmrs.business.abstracts.UserService;
import kodlamaio.hmrs.core.utilities.tools.BusinessRules;
import kodlamaio.hmrs.core.business.validation.TaxNumberValidation;
>>>>>>> b9e69758d6563fe3f9ed95825d2ad120553f39ab
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.core.validators.emailRegex.abstracts.EmployerEmailRegexValidatorService;
import kodlamaio.hmrs.core.validators.emailVerify.abstracts.EmployerEmailVerifyService;
import kodlamaio.hmrs.core.validators.systemEmployeeVerify.abstracts.EmployerSystemEmployeeVerifyService;
import kodlamaio.hmrs.dataAccess.abstracts.EmployerDao;
import kodlamaio.hmrs.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmployerEmailRegexValidatorService employerEmailRegexValidatorService;
	private EmployerEmailVerifyService employerEmailVerifyService;
	private EmployerSystemEmployeeVerifyService employerSystemEmployeeVerifyService;

	@Autowired
	public EmployerManager(EmployerDao employerDao,
			EmployerEmailRegexValidatorService employerEmailRegexValidatorService, 
			EmployerEmailVerifyService employerEmailVerifyService, 
			EmployerSystemEmployeeVerifyService employerSystemEmployeeVerifyService) {
		this.employerDao = employerDao;
		this.employerEmailRegexValidatorService = employerEmailRegexValidatorService;
		this.employerEmailVerifyService = employerEmailVerifyService;
		this.employerSystemEmployeeVerifyService = employerSystemEmployeeVerifyService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Listelendi");
	}

	@Override
	public DataResult<Employer> getById(int id) {
		if (this.employerDao.findById(id).orElse(null) != null) {
			return new SuccessDataResult<Employer>(this.employerDao.findById(id).get(),"Getirildi");
		} else {
			return new ErrorDataResult<Employer>("The specified employer is not available.");
		}
	}

	@Override
<<<<<<< HEAD
	public Result add(Employer employer) {
		if (!this.employerEmailRegexValidatorService.isValidEmail(employer.getEmail(),
				employer.getWebSite())) {
			return new ErrorResult("Email must have the same domain as the web site.");
		} else if (this.existsEmployerByEmail(employer.getEmail())) {
			return new ErrorResult("There is an employer record with this email.");
		} else if (!this.employerEmailVerifyService.hasVerifyEmail(employer.getEmail())) {
			return new ErrorResult("Email not verified!");
		} else if (!this.employerSystemEmployeeVerifyService.hasVerifyBySystemEmployee(employer)) {
			return new ErrorResult("The employer has not been verified by the system!");
		} else {
			this.employerDao.save(employer);
			return new SuccessResult("Employer added successfully.");
		}
=======
	public Result delete(int id) {
		this.employerDao.deleteById(id);
		return new SuccessResult("Silindi");
>>>>>>> b9e69758d6563fe3f9ed95825d2ad120553f39ab
	}

	@Override
	public Result delete(int id) {
		this.employerDao.deleteById(id);
		return new SuccessResult("Employer deleted successfully.");
	}

	@Override
	public Result update(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult("Employer updated successfully.");
	}

	@Override
	public boolean existsEmployerByEmail(String email) {
		return this.employerDao.existsEmployerByEmail(email);
	}
	
}
