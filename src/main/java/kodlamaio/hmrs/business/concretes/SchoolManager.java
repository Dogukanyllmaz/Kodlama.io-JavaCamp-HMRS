package kodlamaio.hmrs.business.concretes;

<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

=======
>>>>>>> b9e69758d6563fe3f9ed95825d2ad120553f39ab
import kodlamaio.hmrs.business.abstracts.SchoolService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
<<<<<<< HEAD
import kodlamaio.hmrs.dataAccess.abstracts.SchoolDao;
import kodlamaio.hmrs.entities.concretes.School;
=======
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.SchoolDao;
import kodlamaio.hmrs.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
>>>>>>> b9e69758d6563fe3f9ed95825d2ad120553f39ab

@Service
public class SchoolManager implements SchoolService {

<<<<<<< HEAD
	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"Schools listed succesfully.");
	}

	@Override
	public DataResult<School> getById(int id) {
		return new SuccessDataResult<School>(this.schoolDao.findById(id).get(),"School got succesfully.");
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessDataResult<School>("School added succesfully.");
	}

	@Override
	public Result delete(int id) {
		this.schoolDao.deleteById(id);
		return new SuccessDataResult<School>("School deleted succesfully.");
	}

	@Override
	public Result update(School school) {
		this.schoolDao.save(school);
		return new SuccessDataResult<School>("School updated succesfully.");
	}

	@Override
	public DataResult<List<School>> getAllOrderByEndDateDesc() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAllByOrderByEndDateDesc(),"Schools listed and ordered by end date (Desc) succesfully.");
	}

	@Override
	public DataResult<List<School>> getByEndDateIsNull() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findByEndDateIsNull(),"Schools in progress listed succesfully.");
	}

	@Override
	public DataResult<List<School>> getByEndDateIsNotNullOrderByEndDateDesc() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findByEndDateIsNotNullOrderByEndDateDesc(),"Graduated schools listed and ordered by end date (Desc) succesfully.");
	}

}
=======
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
>>>>>>> b9e69758d6563fe3f9ed95825d2ad120553f39ab
