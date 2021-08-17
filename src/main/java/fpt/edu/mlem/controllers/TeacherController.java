package fpt.edu.mlem.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fpt.edu.mlem.entities.Account;
import fpt.edu.mlem.entities.Chapter;
import fpt.edu.mlem.entities.ListStudent;
import fpt.edu.mlem.entities.ListTeacher;
import fpt.edu.mlem.requests.CreateChapterRequest;
import fpt.edu.mlem.requests.CreateTestRequest;
import fpt.edu.mlem.services.AccountService;
import fpt.edu.mlem.services.ChapterService;
import fpt.edu.mlem.services.ImportExecelTestService;
import fpt.edu.mlem.services.ListStudentService;
import fpt.edu.mlem.services.ListTeacherService;



@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	ListTeacherService teacherService;
	@Autowired
	ChapterService chapterservice;
	@Autowired
	ImportExecelTestService importExecelTestService;
	@Autowired
	private AccountService userService;
	@RequestMapping(value = "/chapter/create", method = RequestMethod.POST)
	@ResponseBody
	public Chapter createChapter(@RequestBody CreateChapterRequest request) {
		return chapterservice.createChapter(request.getChapter(), request.getGeneralCourseId());
	}
	@RequestMapping(value = "/test/create", method = RequestMethod.GET)
	public String createTestPage(Model model,@RequestParam int courseId){
		model.addAttribute("courseId", courseId);
		return "test_import";
	}
	@RequestMapping("managercourse")
	public String ManagerTeacher(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
			Account user = userService.getAccount(userCookie);
			int  idTeacher = user.getId();
			model.addAttribute("user", user);
			List<ListTeacher> listTeachers = teacherService.getCoursebyTeacher(idTeacher);
			model.addAttribute("listTeachers", listTeachers);
		}
			
		
	
			
		return "manager_teacher";
	}
	@RequestMapping(value = "/test/create", method = RequestMethod.POST)
	@ResponseBody
	public String createTest(CreateTestRequest formData) throws EncryptedDocumentException, InvalidFormatException, IOException {
		System.out.println(formData.getCourseId());
		return importExecelTestService.ReadDataFromExcel(formData);
		
	}
}