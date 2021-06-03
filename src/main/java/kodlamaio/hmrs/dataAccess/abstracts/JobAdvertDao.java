package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hmrs.entities.concretes.JobAdvert;
import org.springframework.data.jpa.repository.Query;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{
	
	List<JobAdvert> getByActivityStatusIsTrue();
	List<JobAdvert> getByActivityStatusIsTrueOrderByAdvertDateAsc();
	List<JobAdvert> getByActivityStatusIsTrueOrderByAdvertDateDesc();
	List<JobAdvert> getByEmployer_UserId(int userId);


/*
	JobAdvert getByPositionName(String positionName);

	JobAdvert getByCityName(String cityName);

	//Querysi tamamlanmadı denemelere devam
	@Query("From JobAdvert where position.positionId =: positionId")
	List<JobAdvert> getByPosition_PositionId(int positionId);
*/
}
