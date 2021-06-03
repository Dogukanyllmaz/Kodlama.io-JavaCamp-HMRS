package kodlamaio.hmrs.business.abstracts;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeService extends BaseService<CurriculumVitae>{
	
	DataResult<CurriculumVitae> getById(int id);
	DataResult<String> uploadPhoto(Integer id, String filePath);
	
}