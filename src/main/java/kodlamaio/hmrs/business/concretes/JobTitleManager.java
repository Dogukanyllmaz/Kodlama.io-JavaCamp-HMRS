package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobTitleService;
import kodlamaio.hmrs.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hmrs.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{

	private JobTitleDao jobTitleDao;
	
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public List<JobTitle> getAll() {
		return this.jobTitleDao.findAll();
	}

	
	
}
