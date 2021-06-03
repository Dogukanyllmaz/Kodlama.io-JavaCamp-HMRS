package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.PositionService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.PositionDao;
import kodlamaio.hmrs.entities.concretes.Position;

@Service
public class PositionManager implements PositionService{
	
	private PositionDao positionDao;
	
	@Autowired
	public PositionManager(PositionDao positionDao) {
		super();
		this.positionDao = positionDao;
	}

	@Override
	public DataResult<List<Position>> getAll() {
		return new SuccessDataResult<List<Position>>(this.positionDao.findAll(),"Listelendi");
	}

	@Override
	public DataResult<Position> getById(int id) {
		if (this.positionDao.findById(id).orElse(null) != null ) {
			return new SuccessDataResult<Position>(this.positionDao.findById(id).get(),"Id'ye göre getirildi");
		} else {
			return new ErrorDataResult<Position>("The specified employee position is not available.");
		}
	}

	@Override
	public Result add(Position position) {
		if (this.positionDao.existsEmployeePositionByPositionNameIgnoreCase(position.getPositionName())) {
			return new ErrorResult("There's a employee position with that name.");
		} else {
			this.positionDao.save(position);
			return new SuccessResult("Employee position added successfully.");
		}
		
	}

	@Override
	public Result delete(int id) {
		this.positionDao.deleteById(id);
		return new SuccessResult("Employee position deleted successfully.");
	}

	@Override
	public Result update(Position position) {
		this.positionDao.save(position);
		return new SuccessResult("Employee position updated successfully.");
	}

	@Override
	public boolean existsEmployeePositionByPositionName(String positionName) {
		return this.positionDao.existsEmployeePositionByPositionNameIgnoreCase(positionName);
	}

	
}
