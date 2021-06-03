package kodlamaio.hmrs.business.concretes;

import kodlamaio.hmrs.business.abstracts.CvService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CvDao;
import kodlamaio.hmrs.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvManager implements CvService {

    private CvDao cvDao;

    @Autowired
    public CvManager(CvDao cvDao) {
        super();
        this.cvDao =cvDao;
    }

    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult(this.cvDao.findAll(),"Cv'ler listelendi");
    }

    @Override
    public Result add(Cv entity) {
        this.cvDao.save(entity);
        return new SuccessResult("Cv eklendi");
    }

    @Override
    public Result delete(int id) {
       this.cvDao.deleteById(id);
       return new SuccessResult("Cv silindi");
    }

    @Override
    public Result update(Cv entity) {
       this.cvDao.save(entity);
       return new SuccessResult("Cv güncellendi");
    }

    @Override
    public DataResult<Cv> getById(int id) {
       return null;
    }

    @Override
    public DataResult<List<Cv>> getByUserId(int userId) {
       return new SuccessDataResult<List<Cv>>(this.cvDao.getByUser_UserId(userId));
    }
}
