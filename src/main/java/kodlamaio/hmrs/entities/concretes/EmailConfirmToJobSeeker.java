package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import kodlamaio.hmrs.entities.abstracts.EmailConfirm;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@Table(name="email_confirms_to_job_seeker")
public class EmailConfirmToJobSeeker extends EmailConfirm {
	
	@OneToOne//Unidirectional
	private JobSeeker jobSeeker;
	
	public EmailConfirmToJobSeeker(boolean isConfirm, LocalDate dateOfConfirm) {
		super(isConfirm, dateOfConfirm);
	}
	
}