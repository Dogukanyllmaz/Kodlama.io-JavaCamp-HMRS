package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CityService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CityDao;
import kodlamaio.hmrs.entities.concretes.City;

@Service
public class CityManager implements CityService{

	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(), "Şehirler listelendi");
	}

	@Override
	public Result add(City entity) {
		this.cityDao.save(entity);
		return new SuccessResult("Şehir eklendi");
	}

	@Override
	public Result delete(int id) {
		this.cityDao.deleteById(id);
		return new SuccessResult("Şehir kaldırıldı");
	}

	@Override
	public Result update(City entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<City> getByCityName(String cityName) {
		return new SuccessDataResult<City>(this.cityDao.getByCityName(cityName));
	}

}
