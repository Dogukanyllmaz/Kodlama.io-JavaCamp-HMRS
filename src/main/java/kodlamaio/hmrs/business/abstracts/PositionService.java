package kodlamaio.hmrs.business.abstracts;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.Position;

public interface PositionService extends BaseService<Position>{
	
	DataResult<Position> getById(int id);
	boolean existsEmployeePositionByPositionName(String positionName);

}
