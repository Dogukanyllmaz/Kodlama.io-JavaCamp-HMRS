package kodlamaio.hmrs.core.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.core.adapters.abstracts.JobSeekerValidationService;
import kodlamaio.hmrs.entities.concretes.JobSeeker;
import kodlamaio.hmrs.externalServices.mernis.FakeMernis;

@Service
public class MernisValidationAdapter implements JobSeekerValidationService {

	@Override
	public boolean isRealPerson(JobSeeker jobSeeker) {
		return new FakeMernis().isRealPerson(jobSeeker.getFirstName(), jobSeeker.getLastName(),
				Long.parseLong(jobSeeker.getNationalityId()));
	}

}
