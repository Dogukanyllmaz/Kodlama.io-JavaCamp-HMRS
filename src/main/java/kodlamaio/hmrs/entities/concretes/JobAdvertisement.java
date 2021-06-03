package kodlamaio.hmrs.entities.concretes;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="min_salary")
	@Positive
	private float minSalary;
	
	@Column(name="max_salary")
	@Positive
	private float maxSalary;
	
	@Column(name="number_of_open_position", nullable = false)
	@NotNull
	@Positive
	private short numberOfOpenPosition;
	
	@Column(name="application_deadline")
	@Future
	private LocalDate applicationDeadline;
	
	@Column(name="release_date", nullable = false)
	@NotNull
	@PastOrPresent
	private LocalDate releaseDate = LocalDate.now();
	
	@Column(name="description", nullable = false)
	@NotNull
	@NotBlank
	private String description;
	
	@Column(name="active", nullable = false)
	@NotNull
	private boolean active;
	
	@ManyToOne()
	@JoinColumn(name = "position_id", nullable = false)
	private Position position;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "city_id", nullable = false)
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = LocalDate.now();
		// Json'da releaseDate gönderilirse çalışmaz.
	}

}