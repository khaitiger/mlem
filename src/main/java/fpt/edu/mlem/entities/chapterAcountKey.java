package fpt.edu.mlem.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Data
public class chapterAcountKey implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Column(name = "teacher_id")
	
	int teacherId;

	@Column(name = "course_id")
	int courseId;
	
	
}