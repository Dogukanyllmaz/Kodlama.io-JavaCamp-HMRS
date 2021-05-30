package kodlamaio.hmrs.business.abstracts;

import java.util.Optional;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.Position;

public interface PositionService extends BaseService<Position>{
	
	DataResult<Optional<Position>> getById(int id);

}
