package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hmrs.business.abstracts.JobSeekerService;
import kodlamaio.hmrs.core.adapters.abstracts.JobSeekerValidationService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.core.validators.emailRegex.abstracts.JobSeekerEmailRegexValidatorService;
import kodlamaio.hmrs.core.validators.emailVerify.abstracts.JobSeekerEmailVerifyService;
import kodlamaio.hmrs.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hmrs.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	private JobSeekerEmailRegexValidatorService jobSeekerEmailRegexValidatorService;
	private JobSeekerValidationService jobSeekerValidationService;
	private JobSeekerEmailVerifyService jobSeekerEmailVerifyService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,
			JobSeekerEmailRegexValidatorService jobSeekerEmailRegexValidatorService,
			JobSeekerValidationService jobSeekerValidationService, 
			JobSeekerEmailVerifyService jobSeekerEmailVerifyService) {
		this.jobSeekerDao = jobSeekerDao;
		this.jobSeekerEmailRegexValidatorService = jobSeekerEmailRegexValidatorService;
		this.jobSeekerValidationService = jobSeekerValidationService;
		this.jobSeekerEmailVerifyService = jobSeekerEmailVerifyService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"Jobseekers listed successfully");
	}

	@Override
	public DataResult<JobSeeker> getById(int id) {
		if (this.jobSeekerDao.findById(id).orElse(null) != null ) {
			return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findById(id).get(),"The specified jobseeker was found successfully.");
		} else {
			return new ErrorDataResult<JobSeeker>("The specified jobseeker is not available.");
		}
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		if (!this.jobSeekerValidationService.isRealPerson(jobSeeker)) {
			return new ErrorResult("Invalid job seeker!");
		} else if (this.existsJobSeekerByNationalityId(jobSeeker.getNationalityId())) {
			return new ErrorResult("There is a jobseeker record with this identification number.");
		} else if (!this.jobSeekerEmailRegexValidatorService.isValidEmail(jobSeeker.getEmail())) {
			return new ErrorResult("Invalid email!");
		} else if (this.existsJobSeekerByEmail(jobSeeker.getEmail())) {
			return new ErrorResult("There is a jobseeker record with this email.");
		} else if (!this.jobSeekerEmailVerifyService.hasVerifyEmail(jobSeeker.getEmail())) {
			return new ErrorResult("Email not verified!");
		} else {
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Jobseeker added successfully.");
		}
	}

	@Override
	public Result delete(int id) {
		this.jobSeekerDao.deleteById(id);
		return new SuccessResult("Jobseeker deleted successfully.");
	}

	@Override
	public Result update(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Jobseeker updated successfully.");
	}

	@Override
	public boolean existsJobSeekerByNationalityId(String nationalityId) {
		return this.jobSeekerDao.existsJobSeekerByNationalityId(nationalityId);
	}

	@Override
	public boolean existsJobSeekerByEmail(String email) {
		return this.jobSeekerDao.existsJobSeekerByEmail(email);
	}
	
}
