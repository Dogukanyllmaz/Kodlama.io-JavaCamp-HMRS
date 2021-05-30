package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.SystemEmployeeService;
import kodlamaio.hmrs.business.abstracts.UserService;
import kodlamaio.hmrs.core.business.BusinessRules;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.SystemEmployeeDao;
import kodlamaio.hmrs.entities.concretes.SystemEmployee;

@Service
public class SystemEmployeeManager implements SystemEmployeeService{
	
	private SystemEmployeeDao systemEmployeeDao;
	private UserService userService;
	
	@Autowired
	public SystemEmployeeManager(SystemEmployeeDao systemEmployeeDao, UserService userService) {
		super();
		this.systemEmployeeDao = systemEmployeeDao;
		this.userService = userService;
	}
	
	@Override
	public DataResult<List<SystemEmployee>> getAll() {
		return new SuccessDataResult<List<SystemEmployee>>(this.systemEmployeeDao.findAll(),"Listelendi");
	}

	@Override
	public Result add(SystemEmployee entity) {
		var result = BusinessRules.run(checkIfInfoIsNull(entity),
										CheckIfTheEmailIsRegistered(entity),
										isRealEmail(entity)
										);
		if (result != null) {
			return result;
		}
		this.userService.add(entity);
		this.systemEmployeeDao.save(entity);
		return new SuccessResult("Çalışan kayıt edildi(system)");
	}

	@Override
	public Result delete(SystemEmployee entity) {
		this.systemEmployeeDao.delete(entity);
		return new SuccessResult("Çalışan silindi(system)");
	}

	@Override
	public Result update(SystemEmployee entity) {
		this.systemEmployeeDao.save(entity);
		return new SuccessResult("Çalışanı güncellendi(system)");
	}

	@Override
	public DataResult<Optional<SystemEmployee>> getByUserId(int userId) {
		return new SuccessDataResult<Optional<SystemEmployee>>(this.systemEmployeeDao.findById(userId),"Listelendi");
	}
	
	//*******************Business Rules***************************
	
	
	private Result checkIfInfoIsNull(SystemEmployee systemEmployee) {
		if (systemEmployee.getEmail().isBlank() ||systemEmployee.getPassword().isBlank() ||
			systemEmployee.getFirstName().isBlank() || systemEmployee.getLastName().isBlank() ||
			systemEmployee.getPhoneNumber().isBlank() || systemEmployee.getPhoneNumber().isBlank()) {
			return new ErrorResult("Lütfen tüm alanları doldurun");
		} else {
			return new SuccessResult();
		}
	}
	

	private Result CheckIfTheEmailIsRegistered(SystemEmployee systemEmployee) {
		if(systemEmployeeDao.findAllByEmail(systemEmployee.getEmail()).stream().count() != 0) {
			return new ErrorResult("'" + systemEmployee.getEmail() + "'" +" adresiyle daha önce hesap açılmış");
		}
		return new SuccessResult();
	}
	
	
	private Result isRealEmail(SystemEmployee systemEmployee) {
		 String regex = "^(.+)@(.+)$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(systemEmployee.getEmail());
	     if(!matcher.matches()) {
	    	 return new ErrorResult("Hatalı Email adresi girdiniz");
	     }
	     return new SuccessResult();
	     }
	

}
