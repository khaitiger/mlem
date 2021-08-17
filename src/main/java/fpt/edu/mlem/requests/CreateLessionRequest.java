package fpt.edu.mlem.requests;

import fpt.edu.mlem.entities.Lesson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateLessionRequest {
private int id;
	
	private Lesson lesson;
	
	private int teacher_id;
	
	private int chapter_id;
}
