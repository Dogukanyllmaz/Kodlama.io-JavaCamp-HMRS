package kodlamaio.hmrs.business.abstracts;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.City;

public interface CityService extends BaseService<City>{

	DataResult<City> getByCityName(String cityName);
	
}
