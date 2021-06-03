package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobAdvertService;
import kodlamaio.hmrs.core.utilities.tools.BusinessRules;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hmrs.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService{

	private JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		var result = BusinessRules.run(
				checkIfInfoIsNull(jobAdvert)
				);
		if (result != null) {
			return result;
		}
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Yayınlandı");
		
	}
	
	@Override
	public Result closeAdvert(JobAdvert jobAdvert) {
		jobAdvert.setActivityStatus(false);
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Yayından kaldırıldı");
		
	}
/*
	@Override
	public DataResult<JobAdvert> getByPositionName(String positionName) {
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getByPositionName(positionName),"Data listelendi");
	}

	@Override
	public DataResult<JobAdvert> getByCityName(String cityName) {
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getByCityName(cityName),"Data listelendi");
	}
*/
	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(),"İlanlar Listlendi");
	}
	
	@Override
	public DataResult<List<JobAdvert>> getByActivityStatusIsTrue() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByActivityStatusIsTrue(),"Aktif İlanlar Listelendi");
	}
	
	@Override
	public DataResult<List<JobAdvert>> getByActivityStatusIsTrueOrderByAdvertDateAsc() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByActivityStatusIsTrueOrderByAdvertDateAsc(),"Aktif ilanlar tarihi artan sırayla listelendi");
	}

	@Override
	public DataResult<List<JobAdvert>> getByActivityStatusIsTrueOrderByAdvertDateDesc() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByActivityStatusIsTrueOrderByAdvertDateDesc(),"Aktif ilanlar tarihi azalan sırayla listelendi");
	}
	
	@Override
	public DataResult<List<JobAdvert>> getByEmployer_UserId(int userId) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByEmployer_UserId(userId),"Firmanın İlanları Listelendi");
	}
/*
	@Override
	public DataResult<List<JobAdvert>> getByPosition_PositionId(int positionId) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByPosition_PositionId(positionId));
	}
	*/
	//**********************Business Rules***************************
	private Result checkIfInfoIsNull(JobAdvert jobAdvert) {
		if (jobAdvert.getDescription().isBlank()) {
			return new ErrorResult("Lütfen tüm alanları doldurun");
		} else {
			return new SuccessResult();
		}
	}

	

	
}
