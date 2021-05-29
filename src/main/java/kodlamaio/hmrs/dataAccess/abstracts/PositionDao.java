package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.Position;

public interface PositionDao extends JpaRepository<Position, Integer>{
	
	List<Position> findAllByPositionName(String positionName);

}
