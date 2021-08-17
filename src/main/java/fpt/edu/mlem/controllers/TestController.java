  
package fpt.edu.mlem.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fpt.edu.mlem.entities.Account;
import fpt.edu.mlem.entities.Question;
import fpt.edu.mlem.entities.Test;
import fpt.edu.mlem.repositories.QuestionRepository;
import fpt.edu.mlem.repositories.TestRepository;
import fpt.edu.mlem.response.TestRes;
import fpt.edu.mlem.services.AccountService;
import fpt.edu.mlem.services.ListStudentService;
import fpt.edu.mlem.utils.TestUtil;

@Controller
public class TestController {
	
	@Autowired
	TestRepository testRepository; 
	@Autowired
	private AccountService userService;
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	ListStudentService studentSer;
	@GetMapping("/doExam")
	public String DetailQuestion(Model model,@RequestParam("idExam") int id) {
		Test test = testRepository.getById(id);
		model.addAttribute("tests",test);
		List<Question> questionList = questionRepository.findByTest(test);
		TestRes testRes = TestUtil.TestQuestionFormat(questionList);
		model.addAttribute("test",testRes);
		return "fullTestListen";
	}
	@RequestMapping(value = "/subScore", method = RequestMethod.POST)
	public String SubmitTest(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model,@RequestParam("score") String score,
			@RequestParam("idTest") int id){
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
			Account user = userService.getAccount(userCookie);
			Test test = testRepository.getById(id);
			int idCourse = test.getCourse().getId();
			int idStudent = user.getId();
			studentSer.updateStatusListStudent(idStudent, idCourse, "Passed", score, new Date());
			System.out.print(idCourse);
			System.out.print(score);
			System.out.print(idStudent);
			System.out.print(new Date());
		}
			
		return "redirect:/";
	}
}