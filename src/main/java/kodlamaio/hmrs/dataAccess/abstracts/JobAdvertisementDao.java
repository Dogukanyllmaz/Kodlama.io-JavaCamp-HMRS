package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concretes.JobAdvertisement;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	List<JobAdvertisement> findByActiveTrue();
	List<JobAdvertisement> findByActiveTrueOrderByReleaseDateAsc();
	List<JobAdvertisement> findByActiveTrueOrderByApplicationDeadlineAsc();
	List<JobAdvertisement> findByActiveTrueAndEmployer_Id(Integer id);
	

}
