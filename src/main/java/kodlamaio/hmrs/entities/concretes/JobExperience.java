package kodlamaio.hmrs.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_experiences")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler","cv"})
public class JobExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "position_name")
    private String positionName;

    @Column(name = "date_of_start")
    private String dateOfStart;

    @Column(name = "date_of_end")
    private String dateOfEnd;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private Cv cv;

}
