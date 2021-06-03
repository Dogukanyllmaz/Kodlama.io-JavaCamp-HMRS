package kodlamaio.hmrs.business.concretes;

import kodlamaio.hmrs.business.abstracts.JobExperienceService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hmrs.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {

    private JobExperienceDao jobExperienceDao;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao) {
        super();
        this.jobExperienceDao = jobExperienceDao;
    }

    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(),"Listelendi");
    }

    @Override
    public Result add(JobExperience entity) {
        this.jobExperienceDao.save(entity);
        return new SuccessResult("İş tecrüebsi eklendi");
    }

    @Override
    public Result delete(int id) {
       this.jobExperienceDao.deleteById(id);
       return new SuccessResult("İş tecrübesi kaldırıldı");
    }

    @Override
    public Result update(JobExperience entity) {
        return null;
    }

    @Override
    public DataResult<List<JobExperience>> getAllUserIdAndOrderingEndingYear(boolean isAsc, int userId) {
        if (isAsc) {
            return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.getAllUserAndOrderedByAsc(userId));
        }
        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.getAllUserAndOrderedByDesc(userId));
    }
}
