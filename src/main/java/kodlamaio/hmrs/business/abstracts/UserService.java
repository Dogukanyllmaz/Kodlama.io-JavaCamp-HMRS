package kodlamaio.hmrs.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.User;

public interface UserService {

	DataResult<List<User>> getAll();
	DataResult <Optional<User>> getById(int id);
	User add(User user);
	User update(User user);
	
}
