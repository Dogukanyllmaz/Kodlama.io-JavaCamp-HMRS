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
@Table(name = "language_experiences")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler","cv"})
public class LanguageExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "language_name")
    private String languageName;

    @Column(name = "language_grade")
    private short languageGrade;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private Cv cv;



}
