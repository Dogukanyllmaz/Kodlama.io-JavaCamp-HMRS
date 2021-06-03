package kodlamaio.hmrs.business.abstracts;

<<<<<<< HEAD
import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.School;

public interface SchoolService extends BaseService<School>{
	
	DataResult<School> getById(int id);
	
	DataResult<List<School>> getAllOrderByEndDateDesc();
	DataResult<List<School>> getByEndDateIsNull();
	DataResult<List<School>> getByEndDateIsNotNullOrderByEndDateDesc();
}
=======
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.School;

import java.util.List;

public interface SchoolService extends BaseService<School>{

    DataResult<List<School>> getAllByUserIdAndOrderingEndingYear(boolean isAsc, int userId);

}
>>>>>>> b9e69758d6563fe3f9ed95825d2ad120553f39ab
