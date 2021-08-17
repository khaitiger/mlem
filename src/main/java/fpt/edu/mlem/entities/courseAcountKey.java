package fpt.edu.mlem.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class courseAcountKey implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Column(name = "student_id")
	
	int studentId;

	@Column(name = "course_id")
	int courseId;
	
}