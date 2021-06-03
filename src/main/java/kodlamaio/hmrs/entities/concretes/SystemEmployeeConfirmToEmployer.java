package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import kodlamaio.hmrs.entities.abstracts.SystemEmployeeConfirm;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@Table(name="system_employee_confirms_to_employer")
public class SystemEmployeeConfirmToEmployer extends SystemEmployeeConfirm {
	
	@OneToOne//Unidirectional
	private Employer employer;
	
	public SystemEmployeeConfirmToEmployer(boolean isConfirm, LocalDate dateOfConfirm) {
		super(isConfirm, dateOfConfirm);
	}
	
}