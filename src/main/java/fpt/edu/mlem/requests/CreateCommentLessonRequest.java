package fpt.edu.mlem.requests;

import fpt.edu.mlem.entities.CommentLesson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCommentLessonRequest {
	private CommentLesson commentLesson;
	private int lessonId;
}
