package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.core.entities.User;
import kodlamaio.hmrs.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	
	List<Employer> findAllByTaxNumber(String taxNumber);
	List<User> findAllByEmail(String email);

}
