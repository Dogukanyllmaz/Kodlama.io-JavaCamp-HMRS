package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.core.entities.User;
import kodlamaio.hmrs.entities.concretes.Employer;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer>{
	
	boolean existsEmployerByEmail(String email);
	List<User> findAllByEmail(String email);

}
