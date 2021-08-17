package fpt.edu.mlem.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class chapterAcountKey implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Column(name = "teacher_id")
	
	int studentId;

	@Column(name = "id")
	int id;
	
}