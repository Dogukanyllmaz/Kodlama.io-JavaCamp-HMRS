package kodlamaio.hmrs.core.dataAccess;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	User findByEmail(String email);

}
