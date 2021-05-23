package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EmployerService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.EmployerDao;
import kodlamaio.hmrs.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employers listed");
		
	}

	@Override
	public Result add(Employer entity) {
		
		Result result = checkUserExist(employerDao.findAll(), entity);
		if (!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		employerDao.save(entity);
		return new SuccessResult("Employer added");
		
	}

	@Override
	public Result delete(int id) {
		
		Employer employer = employerDao.getOne(id);
		if (employer.getCompanyName().equals("")) {
			return new ErrorResult("No Data");
		}
		employerDao.delete(employer);
		return new SuccessResult("Employer deleted");
		
	}

	@Override
	public Result update(Employer entity) {
		
		Employer employerFromDb = employerDao.getOne(entity.getId());
		
		if (employerFromDb.getCompanyName().equals("")) {
			return new ErrorResult("No Data");
		}
		
		employerFromDb.setCompanyName(entity.getCompanyName());
		employerFromDb.setPhoneNumber(entity.getPhoneNumber());
		employerFromDb.setWebAddress(entity.getWebAddress());
		employerFromDb.setEmail(entity.getEmail());
		employerFromDb.setPassword(entity.getPassword());
		employerDao.save(employerFromDb);
		return new SuccessResult("Employer update");
		
	}

	@SuppressWarnings("unused")
	private Result checkUserExist(List<Employer> employers,Employer checkEmployer){
		for (Employer employer: employers) {
			if (employer.getEmail().equals(checkEmployer.getEmail())){
				return new ErrorResult("Already exist Email");
			}
		}
		return new SuccessResult();
	}
	
}
