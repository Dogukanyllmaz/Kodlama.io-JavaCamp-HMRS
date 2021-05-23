package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hmrs.business.abstracts.JobTitleService;
import kodlamaio.hmrs.core.utilities.results.*;
import kodlamaio.hmrs.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hmrs.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{

	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(), "Titles are listed");
	}

	@Override
	public Result add(JobTitle entity) {
		
		Result result = checkTitleExist(entity);
		if (!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		jobTitleDao.save(entity);
		return new SuccessResult("Title added");
		
	}

	@Override
	public Result delete(int id) {
		
		JobTitle jobTitle = jobTitleDao.getOne(id);
		if (jobTitle.getTitle().equals("")) {
			return new ErrorResult("No Data");
		}
		jobTitleDao.delete(jobTitle);
		return new SuccessResult("Title deleted");
	}

	@Override
	public Result update(JobTitle entity) {
		
		JobTitle jobTitleFromDb = jobTitleDao.getOne(entity.getId());
		jobTitleFromDb.setTitle(entity.getTitle());
		jobTitleDao.save(entity);
		return new SuccessResult("Title updated");
		
	}

	
	private Result checkTitleExist(JobTitle checkedJobTitle) {
		
		for(JobTitle jobTitle: jobTitleDao.findAll()) {
			if (jobTitle.getTitle().equals(checkedJobTitle.getTitle())) {
				return new ErrorResult("Exist title");
			}
		}
		return new SuccessResult("Title is okey");
	}
	
	
}
