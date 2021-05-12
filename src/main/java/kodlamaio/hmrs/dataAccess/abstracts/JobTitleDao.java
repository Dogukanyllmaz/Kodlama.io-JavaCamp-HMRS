package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer>{

	
	
}
