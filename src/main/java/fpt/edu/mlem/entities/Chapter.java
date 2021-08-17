package fpt.edu.mlem.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chapter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private Date creatDate;
	
	
	@ManyToOne
	private Course course;
	
	@OneToMany(
			mappedBy = "chapter",
			cascade = CascadeType.ALL
			)
	@EqualsAndHashCode.Exclude
	private Set<Lesson> lessonList = new HashSet<>();
	
	@ManyToOne
	private Account teacher;

	
}
