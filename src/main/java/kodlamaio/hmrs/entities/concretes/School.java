package kodlamaio.hmrs.entities.concretes;

<<<<<<< HEAD
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

=======

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
>>>>>>> b9e69758d6563fe3f9ed95825d2ad120553f39ab
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="schools")
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name", nullable = false)
	@NotNull
	@NotBlank
	private String name;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "start_date", nullable = false)
	@NotNull
	@PastOrPresent
	private LocalDate startDate;
	
	@Column(name = "end_date")
	@PastOrPresent
	private LocalDate endDate;
	
	@Column(name = "add_date", nullable = false)
	@NotNull
	@PastOrPresent
	private LocalDate addDate = LocalDate.now();
	
	
	@ManyToOne
	@JoinColumn(name = "curriculum_vitae_id")
	private CurriculumVitae curriculumVitae;
	
	
	public void setAddDate(LocalDate addDate) {
		this.addDate = LocalDate.now();
	}

}
=======
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "schools")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler","cv"})
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "graduation_year")
    private String graduationYear;

    @ManyToOne()
    @JoinColumn(name = "cv_id")
    private Cv cv;

}
>>>>>>> b9e69758d6563fe3f9ed95825d2ad120553f39ab
