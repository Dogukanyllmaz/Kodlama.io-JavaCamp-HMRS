package kodlamaio.hmrs.business.abstracts;

import java.util.List;



import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService  {

	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getByActivated();
	DataResult<List<JobAdvertisement>> getByActivatedOrderByReleaseDateAsc();
	DataResult<List<JobAdvertisement>> getByActivatedOrderByApplicationDeadlineAsc();

	
	Result activateJobAdvertisement(Integer id);
	Result deactivateJobAdvertisement(Integer id);
	
}
