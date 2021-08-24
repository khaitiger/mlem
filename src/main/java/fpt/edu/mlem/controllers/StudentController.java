package fpt.edu.mlem.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fpt.edu.mlem.entities.Account;
import fpt.edu.mlem.entities.Course;
import fpt.edu.mlem.entities.Lesson;
import fpt.edu.mlem.entities.ListStudent;
import fpt.edu.mlem.entities.Test;
import fpt.edu.mlem.entities.Vote;
import fpt.edu.mlem.services.AccountService;
import fpt.edu.mlem.services.ChapterService;
import fpt.edu.mlem.services.CourseService;
import fpt.edu.mlem.services.LessonService;
import fpt.edu.mlem.services.ListStudentService;
import fpt.edu.mlem.services.TestService;
import fpt.edu.mlem.services.VoteService;


@Controller
public class StudentController {

	@Autowired
	private AccountService userService;
	@Autowired
	private ListStudentService studentService;
	@Autowired
	private ChapterService chapterService;
	@Autowired
	private CourseService courseS;
	@Autowired
	private LessonService lessonService;
	@Autowired
	private TestService testService;
	@Autowired
	private VoteService voteService;
	@RequestMapping("Course/{id}")
	public String LessonPage(@PathVariable(name = "id") int id,@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
			Account user = userService.getAccount(userCookie);
			model.addAttribute("user", user);
			
			List<ListStudent> list = studentService.GetBotMail(user);
			
			for(ListStudent listStudent : list) {
				if(listStudent.getCourse().getId()==id) {
					if(id != 1) {
					model.addAttribute("chapters", chapterService.getByCourse(id));
					return "course_study_view";
					}
					if(id == 1) {
						Course course = courseS.getCourseById(id);
						List<Test> listTest = testService.getTestbyCourse(id);
						model.addAttribute("course", course);
						model.addAttribute("listTest", listTest);
						return "study";
					}
				}
			}
			
		}
		
		return "redirect:/course_detail_view/"+id;	
	}

	@RequestMapping("/lesson")
	@ResponseBody
	public Lesson LessonRespone(
			 int chapterId,
			 int lessonId,
			@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
			Account user = userService.getAccount(userCookie);
			model.addAttribute("user", user);
			
			List<ListStudent> list = studentService.GetBotMail(user);
			
			return lessonService.getById(lessonId) ;
			
	
			
		}
		return null;	
	}
	@RequestMapping("/certification_test__result")
	public String Congratulations()	{
		return "certification_test__result";
	}
	@RequestMapping("/MyCertificate")
	public String MyCertificate(
			@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {
			
			model.addAttribute("user", null);
		} 
		else {
			Account user = userService.getAccount(userCookie);
			model.addAttribute("user", user);
			int idStudent = user.getId();
			List<ListStudent> list = studentService.getCoursebyStatus(idStudent);
			model.addAttribute("list", list);
			
			
	
			
		}
		return "certificate_view";	
	}
    @RequestMapping(value = "/savevote", method = RequestMethod.POST)
    public String saveVote(@ModelAttribute("vote") Vote votes,@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie) {
    	Account user = userService.getAccount(userCookie);
    	votes.setStudent(user);
    	votes.setDateReview(new Date());
        voteService.saveVote(votes);   
        	
        return "redirect:/course_detail_view/"+votes.getCourse().getId();	
    }
}
