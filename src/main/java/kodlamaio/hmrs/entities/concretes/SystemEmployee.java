package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import kodlamaio.hmrs.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name="system_employees")
public class SystemEmployee extends User{

	@Column(name="first_name", nullable = false)
	@NotNull
	@NotBlank
	private String firstName;
	
	@Column(name="last_name", nullable = false)
	@NotNull
	@NotBlank
	private String lastName;
	
	@Column(name="date_of_birth", nullable = false)
	@NotNull
	@NotBlank
	@Past
	private LocalDate dateOfBirth;
	
	@Column(name="nationality_id", nullable = false)
	@NotNull
	@NotBlank
	private String nationalityId;
	
	@Column(name = "gender", nullable = false)
	@NotNull
	@NotBlank
	private String gender;

	public SystemEmployee(int userId, String email, String password, String firstName, 
			String lastName, LocalDate dateOfBirth, String nationalityId, String gender) {
		super(userId, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.nationalityId = nationalityId;
		this.gender = gender;
	}
	
	public SystemEmployee(String email, String password, String firstName, 
			String lastName, LocalDate dateOfBirth, String nationalityId, String gender) {
		super(email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.nationalityId = nationalityId;
		this.gender = gender;
	}
	
	
	
	
}
