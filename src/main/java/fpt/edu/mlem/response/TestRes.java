package fpt.edu.mlem.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestRes {
	 private List<QuestionRes> questionList;
	 private String correctAnwserList;
}
