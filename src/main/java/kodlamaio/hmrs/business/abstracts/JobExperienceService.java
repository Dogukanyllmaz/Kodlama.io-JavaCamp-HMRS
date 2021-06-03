package kodlamaio.hmrs.business.abstracts;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.JobExperience;

import java.util.List;

public interface JobExperienceService extends BaseService<JobExperience>{

    DataResult<List<JobExperience>> getAllUserIdAndOrderingEndingYear(boolean isAsc,int userId);

}
