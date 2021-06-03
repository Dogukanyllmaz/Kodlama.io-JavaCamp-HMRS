package kodlamaio.hmrs.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cv")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler","user"})
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_image")
    private String userImage;

    @Column(name = "github_link")
    private String github;

    @Column(name = "linkedin_link")
    private String linkedin;

    @Column(name = "foreground")
    private String foreground;

    @OneToMany(mappedBy = "cv")
    private List<School> schools;

    @OneToMany(mappedBy = "cv")
    private List<JobExperience> jobExperiences;

    @OneToMany(mappedBy = "cv")
    private  List<LanguageExperience> languageExperiences;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private Employee employee;

}
