package kodlamaio.hmrs.dataAccess.abstracts;

import kodlamaio.hmrs.entities.concretes.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvDao extends JpaRepository<Cv,Integer> {

    List<Cv> getByUser_UserId(int userId);

}
