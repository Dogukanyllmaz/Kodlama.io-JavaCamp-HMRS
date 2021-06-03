package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.WorkExperienceService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.dataAccess.abstracts.WorkExperienceDao;
import kodlamaio.hmrs.entities.concretes.WorkExperience;

@Service
public class WorkExperienceManager implements WorkExperienceService {
	
	private WorkExperienceDao workExperienceDao;
	
	@Autowired
	public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
		this.workExperienceDao = workExperienceDao;
	}

	@Override
	public DataResult<List<WorkExperience>> getAll() {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAll(),"Work experiences listed succesfully.");
	}

	@Override
	public DataResult<WorkExperience> getById(int id) {
		return new SuccessDataResult<WorkExperience>(this.workExperienceDao.findById(id).get(),"Work experience got succesfully.");
	}

	@Override
	public Result add(WorkExperience schoolDegree) {
		this.workExperienceDao.save(schoolDegree);
		return new SuccessDataResult<WorkExperience>("Work experience added succesfully.");
	}

	@Override
	public Result delete(int id) {
		this.workExperienceDao.deleteById(id);
		return new SuccessDataResult<WorkExperience>("Work experience deleted succesfully.");
	}

	@Override
	public Result update(WorkExperience schoolDegree) {
		this.workExperienceDao.save(schoolDegree);
		return new SuccessDataResult<WorkExperience>("Work experience updated succesfully.");
	}
	
	@Override
	public DataResult<List<WorkExperience>> getAllOrderByEndDateDesc() {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAllByOrderByEndDateDesc(),"Work experiences listed and ordered by end date (Desc) succesfully.");
	}

	@Override
	public DataResult<List<WorkExperience>> getByEndDateIsNull() {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findByEndDateIsNull(),"Work experiences in progress listed succesfully.");
	}

	@Override
	public DataResult<List<WorkExperience>> getByEndDateIsNotNullOrderByEndDateDesc() {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findByEndDateIsNotNullOrderByEndDateDesc(),"Finished work experiences listed and ordered by end date (Desc) succesfully.");
	}
	
}