package fpt.edu.mlem.requests;




import fpt.edu.mlem.entities.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGeneralCourseRequest {
	Course generalCourse;
	int[] cateIdArray;
	int lvId;
}