package kodlamaio.hmrs.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers")
@Entity
@EqualsAndHashCode(callSuper=false)
public class Employer extends User{
	
	
	@Column(name= "company_name")
	private String companyName;
	
	@Column(name = "web_address")
	private String webAddress;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "is_activated")
	private boolean isActivated;
	
}
