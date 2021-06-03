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
	//DataResult<List<JobAdvert>> getByPosition_PositionId(int positionId);
	
	Result add(JobAdvert jobAdvert);
	Result closeAdvert(JobAdvert jobAdvert);

/*
	DataResult<JobAdvert> getByPositionName(String positionName);
	DataResult<JobAdvert> getByCityName(String cityName);
*/
}
