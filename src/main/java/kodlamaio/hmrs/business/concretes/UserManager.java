package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.UserService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.dataAccess.abstracts.UserDao;
import kodlamaio.hmrs.entities.concretes.User;

@Service
public class UserManager implements UserService{
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Listelendi");
	}

	@Override
	public DataResult<Optional<User>> getById(int id) {
		return new SuccessDataResult<Optional<User>>(this.userDao.findById(id),"Listelendi");
	}

	@Override
	public User add(User user) {
		return this.userDao.save(user);
	}

	@Override
	public User update(User user) {
		return this.userDao.save(user);
	}

}
