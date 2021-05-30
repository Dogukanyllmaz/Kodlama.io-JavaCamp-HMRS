package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;

//Generic baseService
public interface BaseService<T> {

	DataResult<List<T>> getAll();
	Result add(T entity);
	Result delete(T entity);
	Result update(T entity);
	
}
