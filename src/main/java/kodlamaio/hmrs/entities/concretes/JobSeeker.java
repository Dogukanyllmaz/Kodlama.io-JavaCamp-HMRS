package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import kodlamaio.hmrs.core.entities.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "job_seekers")
@EqualsAndHashCode(callSuper = false)
public class JobSeeker extends User{
	
	@Column(name="first_name", nullable = false)
	@NotNull
	@NotBlank
	private String firstName;
	
	@Column(name="last_name", nullable = false)
	@NotNull
	@NotBlank
	private String lastName;
	
	@Column(name="nationality_id", nullable = false, unique = true)
	@NotNull
	@NotBlank
	private String nationalityId;
	
	@Column(name="date_of_birth", nullable = false)
	@NotNull
	@Past
	private LocalDate dateOfBirth;
	
	@Column(name="gender", nullable = false)
	@NotNull
	@NotBlank
	private String gender;
	
	
	public JobSeeker(Integer id, String email, String password, String firstName, String lastName, String nationalityId,
			LocalDate dateOfBirth, String gender) {
		super(id, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}

	public JobSeeker(String email, String password, String firstName, String lastName, String nationalityId,
			LocalDate dateOfBirth, String gender) {
		super(email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}

}
