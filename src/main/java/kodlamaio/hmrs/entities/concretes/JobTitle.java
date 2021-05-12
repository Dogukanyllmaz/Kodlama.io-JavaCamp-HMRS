package kodlamaio.hmrs.entities.concretes;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="job_titles")
public class JobTitle {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	public JobTitle() {}
	
	public JobTitle(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	
	
	
}
