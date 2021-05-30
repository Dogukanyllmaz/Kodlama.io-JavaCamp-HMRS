package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.PositionService;
import kodlamaio.hmrs.core.business.BusinessRules;
import kodlamaio.hmrs.core.utilities.results.DataResult;
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
	public Result add(Position entity) {
		var result = BusinessRules.run(
				checkIfInfoIsNull(entity),
				CheckIfThePositionName(entity)
				);
		if (result != null) {
			return result;
		}
		this.positionDao.save(entity);
		return new SuccessResult("Pozisyon eklendi");
	}

	@Override
	public Result delete(Position entity) {
		this.positionDao.delete(entity);
		return new SuccessResult("Posizyon Silindi");
	}

	@Override
	public Result update(Position entity) {
		this.positionDao.save(entity);
		return new SuccessResult("Pozisyon güncellendi");
	}

	@Override
	public DataResult<Optional<Position>> getById(int id) {
		return new SuccessDataResult <Optional<Position>>(this.positionDao.findById(id),"Listelendi");
	}

	//*******************Business Rules*************************
	
	private Result checkIfInfoIsNull(Position position) {
		if (position.getPositionName().isBlank()) {
			return new ErrorResult("Lütfen tüm alanları doldurun");
		} else {
			return new SuccessResult();
		}
	}
	
	private Result CheckIfThePositionName(Position position) {
		if(positionDao.findAllByPositionName(position.getPositionName()).stream().count() != 0) {
			return new ErrorResult("'" + position.getPositionName() + "'" +" Bu departman daha önce eklenmiş.");
		}
		return new SuccessResult();
	}
	
}
