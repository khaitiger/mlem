package fpt.edu.mlem.requests;




import fpt.edu.mlem.entities.Chapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateChapterRequest {
	private Chapter chapter;
	private int generalCourseId;
}
