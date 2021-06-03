package kodlamaio.hmrs.dataAccess.abstracts;

import kodlamaio.hmrs.entities.concretes.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {

    @Query("from JobExperience where cv.employee.userId =: userId order by dateOfEnd asc nulls first ")
    List<JobExperience> getAllUserAndOrderedByAsc(int userId);

    @Query("from JobExperience where cv.employee.userId =: userId order by dateOfEnd desc nulls first ")
    List<JobExperience> getAllUserAndOrderedByDesc(int userId);

}
