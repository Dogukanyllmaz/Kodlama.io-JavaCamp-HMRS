package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concretes.City;

@Repository
public interface CityDao extends JpaRepository<City, Integer>{
	City getByCityName(String cityName);
}
