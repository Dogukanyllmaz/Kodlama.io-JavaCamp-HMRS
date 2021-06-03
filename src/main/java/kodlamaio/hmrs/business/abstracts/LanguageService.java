package kodlamaio.hmrs.business.abstracts;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.Language;

public interface LanguageService extends BaseService<Language>{
	
	
	DataResult<Language> getById(int id);
	
	
}