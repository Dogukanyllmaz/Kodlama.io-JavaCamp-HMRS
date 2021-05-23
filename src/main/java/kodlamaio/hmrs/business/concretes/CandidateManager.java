package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CandidateService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CandidateDao;
import kodlamaio.hmrs.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Candidates listed");
		
	}

	@Override
	public Result add(Candidate entity) {
		candidateDao.save(entity);
		return new SuccessResult("Candidate added");
	}

	@Override
	public Result delete(int id) {
		
		Candidate candidate = candidateDao.getOne(id);
		if (candidate.getFirstName().equals("")) {
			return new ErrorResult("No Data");
		}
		candidateDao.delete(candidate);
		return new SuccessResult("Candidate deleted");
	}

	@Override
	public Result update(Candidate entity) {
		Candidate candidateFromDb = candidateDao.getOne(entity.getId());
		candidateFromDb.setBirthDate(entity.getBirthDate());
		candidateFromDb.setFirstName(entity.getFirstName());
		candidateFromDb.setLastName(entity.getLastName());
		candidateFromDb.setEmail(entity.getEmail());
		candidateFromDb.setIdentityNumber(entity.getIdentityNumber());
		candidateFromDb.setPassword(entity.getPassword());
		candidateDao.save(candidateFromDb);
		return new SuccessResult("Candidate updated");
	}	
	
	
	@SuppressWarnings("unused")
	private Result checkUserExist(List<Candidate> candidates, Candidate checkCandidate){
		for (Candidate candidate: candidates) {
			if (candidate.getEmail().equals(checkCandidate.getEmail())){
				return new ErrorResult("Already exist email");
			}
			if (candidate.getIdentityNumber().equals(checkCandidate.getIdentityNumber())){
				return new ErrorResult("Already exist identity number");
			}
		}
		return new SuccessResult();
	}
}
