package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.EmailVertification;

public interface EmailVertificationDao extends JpaRepository<EmailVertification, Integer>{

}
