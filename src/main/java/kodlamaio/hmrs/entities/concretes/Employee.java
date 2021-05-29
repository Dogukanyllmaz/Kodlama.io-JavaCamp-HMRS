package kodlamaio.hmrs.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
@EqualsAndHashCode(callSuper = false)
public class Employee extends User{
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "nationality_id", nullable = false, unique = true)
	private String nationalityId;
	
	@Column(name = "birth_date", nullable = false)
	private Date birthDate;
	
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;
	

}
