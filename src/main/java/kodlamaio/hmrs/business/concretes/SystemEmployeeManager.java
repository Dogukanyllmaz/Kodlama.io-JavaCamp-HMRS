package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.SystemEmployeeService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.SystemEmployeeDao;
import kodlamaio.hmrs.entities.concretes.SystemEmployee;

@Service
public class SystemEmployeeManager implements SystemEmployeeService {
	
	private SystemEmployeeDao systemEmployeeDao;
	
	@Autowired
	public SystemEmployeeManager(SystemEmployeeDao systemEmployeeDao) {
		this.systemEmployeeDao = systemEmployeeDao;
	}

	@Override
	public DataResult<List<SystemEmployee>> getAll() {
		return new SuccessDataResult<List<SystemEmployee>>(this.systemEmployeeDao.findAll(),"System employees listed successfully.");
	}

	@Override
	public DataResult<SystemEmployee> getById(int id) {
		if (this.systemEmployeeDao.findById(id).orElse(null) != null ) {
			return new SuccessDataResult<SystemEmployee>(this.systemEmployeeDao.findById(id).get(),"The specified system employee was found successfully.");
		} else {
			return new ErrorDataResult<SystemEmployee>("The specified system employee is not available.");
		}
	}

	@Override
	public Result add(SystemEmployee employeePosition) {
		this.systemEmployeeDao.save(employeePosition);
		return new SuccessResult("System employee added successfully.");
	}

	@Override
	public Result delete(int id) {
		this.systemEmployeeDao.deleteById(id);
		return new SuccessResult("System employee deleted successfully.");
	}

	@Override
	public Result update(SystemEmployee employeePosition) {
		this.systemEmployeeDao.save(employeePosition);
		return new SuccessResult("System employee updated successfully.");
	}

	@Override
	public Result existsSystemEmployeeByNationalityId(String nationalityId) {
		if (this.systemEmployeeDao.existsSystemEmployeeByNationalityId(nationalityId)) {
			return new SuccessResult("There is a system employee with this identification number: " + nationalityId);
		} else {
			return new ErrorResult("There is no system employee with this identification number."+ nationalityId);
		}
	}

	@Override
	public Result existsSystemEmployeeByEmail(String email) {
		if (this.systemEmployeeDao.existsSystemEmployeeByEmail(email)) {
			return new SuccessResult("There is system employee with this email: " + email);
		} else {
			return new ErrorResult("There is no system employee with email."+ email);
		}
	}

}