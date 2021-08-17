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
public class ListTeacher {

	@EmbeddedId
	private chapterAcountKey id;

	@ManyToOne
	@MapsId("teacher_id")
	@JoinColumn(name = "teacher_id")
	private Account teacher;

	@ManyToOne
	@MapsId("id")
	@JoinColumn(name = "id")
	private Course course;

	private Date joinDate;
	private Date endDate;

}
