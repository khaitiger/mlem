package fpt.edu.mlem.response;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuestionRes {
	private String content;
	private String imageUrl;
	private String anwserSet;
}
