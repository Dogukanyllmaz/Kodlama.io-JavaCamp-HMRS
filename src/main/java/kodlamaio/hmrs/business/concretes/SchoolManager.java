package kodlamaio.hmrs.business.concretes;

import kodlamaio.hmrs.business.abstracts.SchoolService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.SchoolDao;
import kodlamaio.hmrs.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {

    private SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        super();
        this.schoolDao = schoolDao;
    }

    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"Okullar listelendi");
    }

    @Override
    public Result add(School entity) {
        this.schoolDao.save(entity);
        return new SuccessResult("Okul eklendi");
    }

    @Override
    public Result delete(int id) {
        this.schoolDao.deleteById(id);
        return new SuccessResult("Okul silindi");
    }

    @Override
    public Result update(School entity) {
        return null;
    }

    @Override
    public DataResult<List<School>> getAllByUserIdAndOrderingEndingYear(boolean isAsc, int userId) {
       if (isAsc) {
           return new SuccessDataResult<List<School>>(this.schoolDao.getAllUserAndOrderedByAsc(userId));
       }
       return new SuccessDataResult<List<School>>(this.schoolDao.getAllUserAndOrderedByDesc(userId));

    }
}
