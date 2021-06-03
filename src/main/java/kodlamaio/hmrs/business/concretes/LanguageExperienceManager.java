package kodlamaio.hmrs.business.concretes;

import kodlamaio.hmrs.business.abstracts.LanguageExperienceService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.LanguageExperienceDao;
import kodlamaio.hmrs.entities.concretes.LanguageExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageExperienceManager implements LanguageExperienceService {

    private LanguageExperienceDao languageExperienceDao;

    @Autowired
    public LanguageExperienceManager(LanguageExperienceDao languageExperienceDao) {
        super();
        this.languageExperienceDao = languageExperienceDao;
    }

    @Override
    public DataResult<List<LanguageExperience>> getAll() {
        return new SuccessDataResult<List<LanguageExperience>>(this.languageExperienceDao.findAll(),"Listelendi");
    }

    @Override
    public Result add(LanguageExperience entity) {
        this.languageExperienceDao.save(entity);
        return new SuccessResult("Dil tecrübesi eklendi");
    }

    @Override
    public Result delete(int id) {
        this.languageExperienceDao.deleteById(id);
        return new SuccessResult("Dil tecrübesi kaldırıldı");
    }

    @Override
    public Result update(LanguageExperience entity) {
        return null;
    }
}
