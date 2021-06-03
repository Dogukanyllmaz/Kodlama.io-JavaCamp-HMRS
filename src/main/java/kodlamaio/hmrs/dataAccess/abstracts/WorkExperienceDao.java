package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concretes.WorkExperience;


@Repository
public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer> {
	List<WorkExperience> findAllByOrderByEndDateDesc();
	List<WorkExperience> findByEndDateIsNull();
	List<WorkExperience> findByEndDateIsNotNullOrderByEndDateDesc();
}