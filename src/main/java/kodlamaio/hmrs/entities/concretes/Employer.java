package kodlamaio.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	@NotNull
	@NotBlank
	private String companyName;
	
	@Column(name="web_site", nullable = false)
	@NotNull
	@NotBlank
	private String webSite;
	
	@Column(name = "phone_number", nullable= false)
	@NotNull
	@NotBlank
	private String phoneNumber;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdverts;
	
	public Employer(int id, String email, String password, String companyName, String webSite) {
		super(id, email, password);
		this.companyName = companyName;
		this.webSite = webSite;
	}

	public Employer(String email, String password, String companyName, String webSite) {
		super(email, password);
		this.companyName = companyName;
		this.webSite = webSite;
	}
	
}
