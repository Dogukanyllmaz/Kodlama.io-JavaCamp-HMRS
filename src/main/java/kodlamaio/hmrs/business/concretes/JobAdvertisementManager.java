package kodlamaio.hmrs.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobAdvertisementService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hmrs.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job advertisement added successfully.");
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getByActivated() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByActiveTrue(),"Active job advertisements listed successfully.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActivatedOrderByReleaseDateAsc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByActiveTrueOrderByReleaseDateAsc(),"Active job advertisements listed and ordered by release date (Asc) successfully.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActivatedOrderByApplicationDeadlineAsc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByActiveTrueOrderByApplicationDeadlineAsc(), "Active job advertisements listed and ordered by application deadline date (Asc) successfully.");
	}


	@Override
	public Result activateJobAdvertisement(Integer id) {
		JobAdvertisement j = this.jobAdvertisementDao.findById(id).get();
		j.setActive(true);
		this.jobAdvertisementDao.save(j);
		return new SuccessResult("Job advertisement activated successfully.");
	}

	@Override
	public Result deactivateJobAdvertisement(Integer id) {
		JobAdvertisement j = this.jobAdvertisementDao.findById(id).get();
		j.setActive(false);
		this.jobAdvertisementDao.save(j);
		return new SuccessResult("Job advertisement deactivated successfully.");
	}
	
}
