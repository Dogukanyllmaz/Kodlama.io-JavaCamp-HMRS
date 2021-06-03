package kodlamaio.hmrs.business.abstracts;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.School;

import java.util.List;

public interface SchoolService extends BaseService<School>{

    DataResult<List<School>> getAllByUserIdAndOrderingEndingYear(boolean isAsc, int userId);

}
