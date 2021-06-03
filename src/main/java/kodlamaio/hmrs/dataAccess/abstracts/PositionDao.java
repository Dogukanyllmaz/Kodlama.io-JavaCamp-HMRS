package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concretes.Position;

@Repository
public interface PositionDao extends JpaRepository<Position, Integer>{
	
	boolean existsEmployeePositionByPositionNameIgnoreCase(String positionName);

}
