package kodlamaio.hmrs.dataAccess.abstracts;

<<<<<<< HEAD
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concretes.School;


@Repository
public interface SchoolDao extends JpaRepository<School, Integer> {
	List<School> findAllByOrderByEndDateDesc();
	List<School> findByEndDateIsNull();
	List<School> findByEndDateIsNotNullOrderByEndDateDesc();
}
=======
import kodlamaio.hmrs.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolDao extends JpaRepository<School, Integer> {

    @Query("from School where cv.employee.userId =: userId order by graduationYear asc nulls first ")
    List<School> getAllUserAndOrderedByAsc(int userId);

    @Query("from School where cv.employee.userId =: userId order by graduationYear desc nulls first ")
    List<School> getAllUserAndOrderedByDesc(int userId);

}
>>>>>>> b9e69758d6563fe3f9ed95825d2ad120553f39ab
