package kodlamaio.hmrs.business.abstracts;

import java.util.List;



import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobAdvert;

public interface JobAdvertService {

	DataResult<List<JobAdvert>> getAll();
	DataResult<List<JobAdvert>> getByActivityStatusIsTrue();
	DataResult<List<JobAdvert>> getByActivityStatusIsTrueOrderByAdvertDateAsc();
	DataResult<List<JobAdvert>> getByActivityStatusIsTrueOrderByAdvertDateDesc();
	DataResult<List<JobAdvert>> getByEmployer_UserId(int userId);
	
	Result add(JobAdvert jobAdvert);
	Result closeAdvert(JobAdvert jobAdvert);
	
}
