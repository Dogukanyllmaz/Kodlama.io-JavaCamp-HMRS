package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EmailVertificationService;
import kodlamaio.hmrs.business.abstracts.EmployeeService;
import kodlamaio.hmrs.business.abstracts.UserService;
import kodlamaio.hmrs.core.business.BusinessRules;
import kodlamaio.hmrs.core.business.validation.NationalityValidation;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hmrs.entities.concretes.EmailVertification;
import kodlamaio.hmrs.entities.concretes.Employee;
import kodlamaio.hmrs.entities.concretes.User;

@Service
public class EmployeeManager implements EmployeeService{

	private EmployeeDao employeeDao;
	private UserService userService;
	private EmailVertificationService emailVerificationService;

	@Autowired
	public EmployeeManager(
			EmployeeDao employeeDao,
			UserService userService, 
			EmailVertificationService emailVerificationService) {
		super();
		this.employeeDao = employeeDao;
		this.userService = userService;
		this.emailVerificationService = emailVerificationService; 
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Listelendi");
	}

	@Override
	public Result add(Employee entity) {
		var result =BusinessRules.run(
				checkIfInfoIsNull(entity),
				CheckIfTheEmailIsRegistered(entity),
				CheckIfTheNationalityIdIsRegistered(entity),
				isRealEmail(entity),
				NationalityIdValidation(entity)
				);
		
		if (result != null) {
			return result;
		}
		
		User user = this.userService.add(entity);
		this.employeeDao.save(entity);
		this.emailVerificationService.generateCode(new EmailVertification(), user.getId());
		return new SuccessResult("Kayıt başarılı. Lütfefn emailinizi kontrol ediniz.");
		
	}

	@Override
	public Result delete(Employee entity) {
		this.employeeDao.delete(entity);
		return new SuccessResult("Silindi");
	}

	@Override
	public Result update(Employee entity) {
		this.employeeDao.save(entity);
		return new SuccessResult("Güncellendi");
	}

	@Override
	public DataResult<Optional<Employee>> getByUserId(int id) {
		return new SuccessDataResult <Optional<Employee>>(this.employeeDao.findById(id),"Listelendi");
	}
	
	//***************Business Rules********************
	
	
	private Result checkIfInfoIsNull(Employee employee) {
		if (employee.getFirstName().isBlank() || employee.getLastName().isBlank()|| employee.getPhoneNumber().isBlank()||
				employee.getNationalityId().isBlank() || employee.getBirthDate()==null)
			{
			return new ErrorResult("Lütfen tüm alanları doldurun");
		}
		return new SuccessResult();
	}
	
	private Result CheckIfTheNationalityIdIsRegistered(Employee employee) {
		if(employeeDao.findAllByNationalityId(employee.getNationalityId()).stream().count() != 0) {
			return new ErrorResult("'" + employee.getNationalityId() + "'" +" kimlik numarasıyla daha önce hesap açılmış. Tekrar hesap açamazsınız.");
		}
		return new SuccessResult();
	}
	
	private Result CheckIfTheEmailIsRegistered(Employee employee) {
		if(employeeDao.findAllByEmail(employee.getEmail()).stream().count() != 0) {
			return new ErrorResult("'" + employee.getEmail() + "'" +" adresiyle daha önce hesap açılmış");
		}
		return new SuccessResult();
	}
	
	private Result isRealEmail(Employee employee) {
		 String regex = "^(.+)@(.+)$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(employee.getEmail());
	     if(!matcher.matches()) {
	    	 return new ErrorResult("Hatalı Email adresi girdiniz");
	     }
	     return new SuccessResult();
	     }
	
	private Result NationalityIdValidation(Employee employee) {
		if(!NationalityValidation.isRealPerson(employee.getNationalityId())) {
			return new ErrorResult("Kimlik doğrulanamadı");
		}
		return new SuccessResult();
	}
	
}
