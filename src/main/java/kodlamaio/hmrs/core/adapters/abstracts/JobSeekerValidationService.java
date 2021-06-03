package kodlamaio.hmrs.core.adapters.abstracts;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.entities.concretes.JobSeeker;


@Service
public interface JobSeekerValidationService {
	boolean isRealPerson(JobSeeker jobSeeker);
}