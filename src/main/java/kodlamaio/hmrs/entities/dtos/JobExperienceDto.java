package kodlamaio.hmrs.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JobExperienceDto {

    private int id;
    private String companyName;
    private String positionName;
    private String firstName;
    private String lastName;
    private String dateOfStart;
    private String dateOfEnd;

}
