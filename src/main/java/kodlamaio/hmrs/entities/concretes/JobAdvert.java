package kodlamaio.hmrs.entities.concretes;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="job_adverts")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_advert_id")
	private int jobAdvertId;
	
	@Column(name="min_salary")
	private float minSalary;
	
	@Column(name="max_salary")
	private float maxSalary;
	
	@Column(name="quantity", nullable = false)
	private int quantity;
	
	@Temporal(TemporalType.DATE)
	@Column(name="advert_date")
	private Date advertDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="due_date", nullable = false)
	private Date dueDate;
	
	@Column(name="description", nullable = false)
	private String description;
	
	@Column(name="activity_status")
	private boolean activityStatus;
	
	@ManyToOne()
	@JoinColumn(name = "position_id", nullable = false)
	private Position position;
	
	@ManyToOne()
	@JoinColumn(name = "city_id", nullable = false)
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private Employer employer;

}