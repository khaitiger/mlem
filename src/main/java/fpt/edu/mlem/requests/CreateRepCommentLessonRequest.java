package fpt.edu.mlem.requests;
import fpt.edu.mlem.entities.CommentLesson;
import fpt.edu.mlem.entities.RepCommentLesson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRepCommentLessonRequest {	
		private RepCommentLesson repCommentLesson;
		private int cmtLessonId;
	

}
