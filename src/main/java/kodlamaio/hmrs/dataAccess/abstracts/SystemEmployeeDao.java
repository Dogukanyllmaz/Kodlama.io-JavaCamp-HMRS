package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.SystemEmployee;
import kodlamaio.hmrs.entities.concretes.User;

public interface SystemEmployeeDao extends JpaRepository<SystemEmployee, Integer>{

	List<User> findAllByEmail(String email);
	
}
