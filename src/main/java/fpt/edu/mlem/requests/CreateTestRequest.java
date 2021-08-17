package fpt.edu.mlem.requests;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTestRequest {
	private MultipartFile reapExcelDataFile;
	private MultipartFile imageTest;
	private String testName;
	private int courseId;
}