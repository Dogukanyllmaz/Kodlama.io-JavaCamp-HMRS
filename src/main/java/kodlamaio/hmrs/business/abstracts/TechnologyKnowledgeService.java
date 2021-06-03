package kodlamaio.hmrs.business.abstracts;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.TechnologyKnowledge;

public interface TechnologyKnowledgeService extends BaseService<TechnologyKnowledge>{

	DataResult<TechnologyKnowledge> getById(int id);
	
}
