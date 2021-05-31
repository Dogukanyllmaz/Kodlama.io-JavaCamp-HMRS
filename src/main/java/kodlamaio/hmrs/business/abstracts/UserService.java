package kodlamaio.hmrs.business.abstracts;


import kodlamaio.hmrs.core.entities.User;
import kodlamaio.hmrs.core.utilities.results.DataResult;


public interface UserService extends BaseService<User>{

	DataResult<User> findByEmail(String email);
	
}
