package kodlamaio.hmrs.business.abstracts;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.Cv;

import java.util.List;

public interface CvService extends BaseService<Cv> {

    DataResult<Cv> getById(int id);
    DataResult<List<Cv>> getByUserId(int userId);

}
