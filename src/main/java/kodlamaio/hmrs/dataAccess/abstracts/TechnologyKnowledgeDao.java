package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concretes.TechnologyKnowledge;

@Repository
public interface TechnologyKnowledgeDao extends JpaRepository<TechnologyKnowledge, Integer> {

}