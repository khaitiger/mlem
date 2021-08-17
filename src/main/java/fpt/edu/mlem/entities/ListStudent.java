package fpt.edu.mlem.entities;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ListStudent {

	@EmbeddedId
	private courseAcountKey id;

	@ManyToOne
	@MapsId("student_id")
	@JoinColumn(name = "student_id")
	private Account student;

	@ManyToOne
	@MapsId("course_id")
	@JoinColumn(name = "course_id")
	private Course course;
	private String score;
	private Date Datepass;
	private Date joinDate;
	private Date endDate;
	private String status;
}
