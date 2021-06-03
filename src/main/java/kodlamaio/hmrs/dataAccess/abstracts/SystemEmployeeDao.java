package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concretes.SystemEmployee;

@Repository
public interface SystemEmployeeDao extends JpaRepository<SystemEmployee, Integer>{

	boolean existsSystemEmployeeByNationalityId(String nationalityId);
	boolean existsSystemEmployeeByEmail(String email);
	
}
