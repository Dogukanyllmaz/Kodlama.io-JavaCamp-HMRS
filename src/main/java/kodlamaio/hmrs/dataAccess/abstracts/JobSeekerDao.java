package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concretes.JobSeeker;

@Repository
public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{
	
	boolean existsJobSeekerByNationalityId(String nationalityId);
	boolean existsJobSeekerByEmail(String email);
}
