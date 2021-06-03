package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.TechnologyKnowledgeService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.dataAccess.abstracts.TechnologyKnowledgeDao;
import kodlamaio.hmrs.entities.concretes.TechnologyKnowledge;

@Service
public class TechnologyKnowledgeManager implements TechnologyKnowledgeService {
	
	private TechnologyKnowledgeDao technologyKnowledgeDao;
	
	@Autowired
	public TechnologyKnowledgeManager(TechnologyKnowledgeDao technologyKnowledgeDao) {
		this.technologyKnowledgeDao = technologyKnowledgeDao;
	}

	@Override
	public DataResult<List<TechnologyKnowledge>> getAll() {
		return new SuccessDataResult<List<TechnologyKnowledge>>(this.technologyKnowledgeDao.findAll(),"Technology Knowledges listed succesfully.");
	}

	@Override
	public DataResult<TechnologyKnowledge> getById(int id) {
		return new SuccessDataResult<TechnologyKnowledge>(this.technologyKnowledgeDao.findById(id).get(),"Technology Knowledge got succesfully.");
	}

	@Override
	public Result add(TechnologyKnowledge schoolDegree) {
		this.technologyKnowledgeDao.save(schoolDegree);
		return new SuccessDataResult<TechnologyKnowledge>("Technology Knowledge added succesfully.");
	}

	@Override
	public Result delete(int id) {
		this.technologyKnowledgeDao.deleteById(id);
		return new SuccessDataResult<TechnologyKnowledge>("Technology Knowledge deleted succesfully.");
	}

	@Override
	public Result update(TechnologyKnowledge schoolDegree) {
		this.technologyKnowledgeDao.save(schoolDegree);
		return new SuccessDataResult<TechnologyKnowledge>("Technology Knowledge updated succesfully.");
	}

	
}