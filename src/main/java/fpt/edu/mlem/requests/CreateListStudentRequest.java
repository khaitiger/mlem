package fpt.edu.mlem.requests;


import fpt.edu.mlem.entities.ListStudent;
import lombok.Data;

@Data
public class CreateListStudentRequest {
	private ListStudent listStudent;
	private int studentId;
	private int courseId;
}
