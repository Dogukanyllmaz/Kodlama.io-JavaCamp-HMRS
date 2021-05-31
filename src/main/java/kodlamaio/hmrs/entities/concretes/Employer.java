package kodlamaio.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hmrs.core.entities.User;
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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class Employer extends User{
	
	
	@Column(name="company_name", nullable = false)
	private String companyName;
	
	@Column(name="web_site", nullable = false)
	private String webSite;
	
	@Column(name="phone_number", nullable = false)
	private String phoneNumber;
	
	@Column(name="tax_number", nullable = false)
	private String taxNumber;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdverts;
	
}
